package model;

public enum Timers {
    // A cada 40 segundos um novo processo deve ser criado (ID randômico)
    ADICIONA(40000),
    // A cada 1 minuto o coordenador morre
    INATIVAR_COORDENADOR(60000);

    private int desc;
    Timers(int i) {
        this.desc = i;
    }

    public int getTimer() {return this.desc;}
}
