package com.furb.snmpProject.data.dto;

public class InfoMemoriaDTO {

    private float memoriaTotal;
    private float memoriaUsada;
    private String memoriaRam;
    private String porcetagemMemoria;

    public InfoMemoriaDTO(float memoriaTotal, float memoriaUsada, String memoriaRam) {
        this.memoriaTotal = memoriaTotal;
        this.memoriaUsada = memoriaUsada;
        this.memoriaRam = memoriaRam;
        setPorcetagemMemoria();
    }

    public InfoMemoriaDTO() {}

    public float getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(float memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public float getMemoriaUsada() {
        return memoriaUsada;
    }

    public void setMemoriaUsada(float memoriaUsada) {
        this.memoriaUsada = memoriaUsada;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getPorcetagemMemoria() {
        return porcetagemMemoria;
    }
    public void setPorcetagemMemoria() {
        this.porcetagemMemoria = Math.round((this.memoriaUsada / this.memoriaTotal ) * 100) + "%";
    }
}
