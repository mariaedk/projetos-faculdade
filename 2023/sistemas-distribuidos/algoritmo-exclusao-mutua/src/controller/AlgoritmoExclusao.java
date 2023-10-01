package controller;

import exception.EncerrarProgramaExeception;
import model.Processo;
import model.Timers;

import java.text.SimpleDateFormat;
import java.util.*;


public class AlgoritmoExclusao {

    // Lista para manter informação dos processos criados
    private static final ArrayList<Processo> processosAtivos = new ArrayList<>();

    // Fila que de armazenamento de processos em espera
    private static final Queue<Processo> fila = new LinkedList<>();

    // Referência do processo que está consumindo recursos
    private Processo processoAcessandoRecursos;

    public AlgoritmoExclusao() {
        init();
    }

    private void init() {
        novoProcesso().start();
        desativarCoordenador().start();
        consumirRecurso().start();
    }

    // Criar um novo processo
    private Thread novoProcesso() {
       Thread aux;
       aux =  new Thread(() -> {
            while (true) {
                // Se a lista estiver vazia, é o coordenador que deve criar
                Processo proc = new Processo(gerarIdProcesso(), processosAtivos.isEmpty());
                processosAtivos.add(proc);
                mostrarConsole("Criado novo processo id: " + proc.getCdProcesso());

                try {
                    Thread.sleep(Timers.ADICIONA.getTimer());
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
       });
       return aux;
    }

    // Desativar o coordenador
    private Thread desativarCoordenador() {
        Thread aux;
        aux = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(Timers.INATIVAR_COORDENADOR.getTimer());
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }

                Processo p = retornaCoordenador();
                if (p != null) {
                    processosAtivos.remove(p);
                    // Quando o coordenador morre, a fila também morre
                    fila.clear();
                    try {
                        throw new EncerrarProgramaExeception("Coordenador morto");
                    } catch (EncerrarProgramaExeception ex) {
                        mostrarConsole("O coordenador foi inativado.");
                        System.exit(130); // Encerre o programa
                    }
                }
            }
        });
        return aux;
    }

    // Tentar consumir um recurso
    private Thread consumirRecurso() {
        Thread aux;
        aux = new Thread(() -> {
            while (true) {
                try {
                    int tempo = gerarTempoAleatorioConsumirRecurso();
                    mostrarConsole("Nova tentativa de consumir recursos em " + tempo/1000 + "s");
                    Thread.sleep(tempo);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }

                // Se existir mais que um processo na lista
                if (processosAtivos.size() > 1) {
                    Processo processoRequisicao = selecionarProcesso();
                    if (processoRequisicao != null) {
                        mostrarConsole(processoRequisicao.getCdProcesso() + " deseja acessar recursos");

                        Processo coordenador = retornaCoordenador();
                        // Se não estiver ocupado com outro processo
                        if (!coordenador.isOcupado()) {
                            // Se houver processos em espera na fila, executar eles primeiro
                            if (!fila.isEmpty()) {
                                Processo proximoProcessoNaFila = fila.poll();
                                processoAcessandoRecursos = proximoProcessoNaFila;
                                processarRecurso(proximoProcessoNaFila, coordenador);
                            } else {
                                // Se a fila estiver limpa, pode executar um outro processo
//                            mostrarConsole("Coordenador não está ocupado");
                                coordenador.concederPermissaoAcesso(processoRequisicao.getCdProcesso());
                                retornaCoordenador().setIsOcupado(true);
                                processoAcessandoRecursos = processoRequisicao;
                                processarRecurso(processoRequisicao, coordenador);
                            }
                        } else {
                            // Se estiver ocupado com outro processo, adicione a fila
                            mostrarConsole("Coordenador está ocupado, adicionar " + processoRequisicao.getCdProcesso() + " a fila de espera");
                            fila.add(processoRequisicao);
                        }
                    }
                }
            }
        });

        return aux;
    }

    private void processarRecurso(Processo processoRequisicao, Processo coordenador) {
        Thread processamentoThread = new Thread(() -> {
            int tempoProcessar = gerarTempoAleatorioProcessamento();
//            mostrarConsole("Processando " + processoRequisicao.getCdProcesso() + " por " + tempoProcessar + "ms");
            processoRequisicao.consumirRecurso(tempoProcessar);

            try {
                Thread.sleep(tempoProcessar);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Acabou de executar o processo, não está mais ocupado. Pode finalizar
            retornaCoordenador().setIsOcupado(false);
            processoAcessandoRecursos = null;
            processoRequisicao.finalizarConsumirRecurso();

            // Se houver processo na fila, volta a se ocupar com eles
            if (!fila.isEmpty()) {
                retornaCoordenador().setIsOcupado(true);
                Processo proximoProcessoNaFila = fila.poll();
                processoAcessandoRecursos = proximoProcessoNaFila;
                processarRecurso(proximoProcessoNaFila, coordenador);
            }
        });

        processamentoThread.start();
    }

    public static void mostrarConsole(String str) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(str);
    }

    private Processo selecionarProcesso() {
        int posicaoProcessoAleatorio = new Random().nextInt(processosAtivos.size());
        Processo processoRequisicao =  processosAtivos.get(posicaoProcessoAleatorio);

        if (processosAtivos.size() > 2) {
            // todo mundo ocupado
            if (fila.size() + 2 == processosAtivos.size()) {
                mostrarConsole("Todos os processos estão ocupados ou na fila de espera.");
                return null;
            }
            // Se escolheu o coordenador, ou se escolheu o que esta acessando recursos agora, ou se ja esta na fila de processamento, escolher outro
            while (processoRequisicao.isCoordenador() ||
                    processoRequisicao.equals(processoAcessandoRecursos) ||
                    fila.contains(processoRequisicao)) {
                processoRequisicao = selecionarProcesso();
            }
        } else if (processosAtivos.size() == 2 && Objects.isNull(processoAcessandoRecursos)) {
            return processosAtivos.get(1);
        } else {
            return null;
        }
        return processoRequisicao;
    }

    private Long gerarIdProcesso() {
        Long num = new Random().nextLong();
        boolean igual = false;

        for (Processo proc : processosAtivos) {
            if (proc.getCdProcesso().equals(num)) {
                igual = true;
                break;
            }
        }
        // dois processos não podem ter o mesmo ID
        if (igual) {
            num = gerarIdProcesso();
        }

        return num;
    }

    private Processo retornaCoordenador() {
        if (processosAtivos.isEmpty()) {
            return null;
        }

        Processo aux = null;

        for (Processo p : processosAtivos) {
            if (p.isCoordenador()) {
                aux = p;
                break;
            }
        }

        return aux;
    }

    private int gerarTempoAleatorioProcessamento() {
        // O tempo de processamento de um recurso é de 5 a 15 segundos
        return (new Random().nextInt(11) + 5) * 1000;
    }

    private int gerarTempoAleatorioConsumirRecurso() {
        // Os processos tentam consumir o(s) recurso(s) num intervalo de 10 a 25 segundos
        return (new Random().nextInt(16) + 10) * 1000;
    }

}
