package com.furb.snmpProject.data.dto;

public class InfoProcessosDTO {
    private String processo;
    private String tipoProcesso;
    private String memoriaProcesso;


    public InfoProcessosDTO(String processo, String tipoProcesso, String memoriaProcesso) {
        this.processo = processo;
        this.tipoProcesso = tipoProcesso;
        this.memoriaProcesso = memoriaProcesso;
    }

    public InfoProcessosDTO() {}

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public String getMemoriaProcesso() {
        return memoriaProcesso;
    }

    public void setMemoriaProcesso(String memoriaProcesso) {
        this.memoriaProcesso = memoriaProcesso;
    }
}
