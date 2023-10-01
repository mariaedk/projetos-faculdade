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
        try {
            novoProcesso().start();
            desativarCoordenador().start();
            consumirRecurso().start();
        } catch (EncerrarProgramaExeception e) {
            System.exit(130);
        }
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
                    fila.clear();
                    throw new EncerrarProgramaExeception("Coordenador morto");
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
//                    mostrarConsole("Tentando consumir recurso em " + tempo + "ms");
                    Thread.sleep(tempo);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }

                // Se existir mais que um processo na lista
                if (processosAtivos.size() > 1) {
                    Processo processoRequisicao = selecionarProcesso();
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
        });

        return aux;
    }

    private void processarRecurso(Processo processoRequisicao, Processo coordenador) {
        Thread processamentoThread = new Thread(() -> {
            int tempoProcessar = gerarTempoAleatorioProcessamento();
//            mostrarConsole("Processando " + processoRequisicao.getCdProcesso() + " por " + tempoProcessar + "ms");
            processoRequisicao.consumirRecurso();

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
        System.out.println("--------------------------------------------------------");
        System.out.println(str);
    }

    private Processo selecionarProcesso() {
        int posicaoProcessoAleatorio = new Random().nextInt(processosAtivos.size());
        Processo processoRequisicao =  processosAtivos.get(posicaoProcessoAleatorio);

        // Se escolheu o coordenador, ou se escolheu o que esta acessando recursos agora, ou se ja esta na fila de processamento, escolher outro
        while (processoRequisicao.isCoordenador() ||
                processoRequisicao.equals(processoAcessandoRecursos) ||
                fila.contains(processoRequisicao)) {
            processoRequisicao = selecionarProcesso();
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
        // de 1 a 10 gere número aleatório e adicione 5
        return (new Random().nextInt(11) + 5) * 1000;
    }

    private int gerarTempoAleatorioConsumirRecurso() {
        return (new Random().nextInt(16) + 10) * 1000;
    }

}
