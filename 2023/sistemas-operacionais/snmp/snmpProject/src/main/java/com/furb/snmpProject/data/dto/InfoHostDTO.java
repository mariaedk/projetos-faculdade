package com.furb.snmpProject.data.dto;

public class InfoHostDTO {

    private String nomeHost;
    private String horaUltimoReinicio;
    private String diasAtivos;

    public InfoHostDTO(String nomeHost, String horaUltimoReinicio, String diasAtivos) {
        this.nomeHost = nomeHost;
        this.horaUltimoReinicio = horaUltimoReinicio;
        this.diasAtivos = diasAtivos;
    }

    public InfoHostDTO() {}

    public String getNomeHost() {
        return nomeHost;
    }

    public void setNomeHost(String nomeHost) {
        this.nomeHost = nomeHost;
    }

    public String getHoraUltimoReinicio() {
        return horaUltimoReinicio;
    }

    public void setHoraUltimoReinicio(String horaUltimoReinicio) {
        this.horaUltimoReinicio = horaUltimoReinicio;
    }

    public String getDiasAtivos() {
        return diasAtivos;
    }

    public void setDiasAtivos(String diasAtivos) {
        this.diasAtivos = diasAtivos;
    }
}
