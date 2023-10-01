package model;

import controller.AlgoritmoExclusao;

public class Processo {

    // único e imutável
    private final Long cdProcesso;

    private boolean isOcupado;

    // mantém a informação se o processo é um coordenador ou nao
    private boolean isCoordenador;
    // mantem tambem a informação do antecessor e sucessor do processo, partindo do principio que no algoritmo os processos
    // se comunicam ao redor de um anel no sentido horario
    // tem o construtor e os respectivos getters setters
    public Processo(Long cdProcesso, boolean isCoordenador) {
        this.cdProcesso = cdProcesso;
        setIsCoordenador(isCoordenador);
    }

    public void setIsCoordenador(boolean isCoordenador) {
        this.isCoordenador = isCoordenador;
        this.setIsOcupado(false);
    }

    public boolean isCoordenador() {
        return this.isCoordenador;
    }

    public Long getCdProcesso() {
        return this.cdProcesso;
    }

    public void setIsOcupado(boolean isOcupado) {
        if (this.isCoordenador) {
            this.isOcupado = isOcupado;
        }
    }

    public boolean isOcupado() {
        return this.isOcupado;
    }

    public void consumirRecurso() {
        AlgoritmoExclusao.mostrarConsole("Processo " + getCdProcesso() + " consumindo recurso do coordenador");
    }

    public void concederPermissaoAcesso(Long cdProcesso) {
        AlgoritmoExclusao.mostrarConsole("Coordenador concedeu permissão de acesso a recursos para processo " + cdProcesso);
    }

    public void finalizarConsumirRecurso() {
        AlgoritmoExclusao.mostrarConsole("Processo " + getCdProcesso() + " parou de consumir recursos do coordenador, liberando");
    }
}
