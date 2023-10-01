package model;

public enum Timers {
    ADICIONA(10000),
    INATIVAR_COORDENADOR(100000);

    private int desc;
    Timers(int i) {
        this.desc = i;
    }

    public int getTimer() {return this.desc;}
}
