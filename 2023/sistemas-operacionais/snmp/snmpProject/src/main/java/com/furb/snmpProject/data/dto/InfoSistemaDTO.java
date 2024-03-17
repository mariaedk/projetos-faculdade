package com.furb.snmpProject.data.dto;

public class InfoSistemaDTO {

    private String hardware;
    private String software;
    private String sistemaOperacional;
    private String totalUsuarios;
    private String nucleoProcessadores;
    private String cpuOcisoso;

    public InfoSistemaDTO(String hardware, String software, String sistemaOperacional, String totalUsuarios, String nucleoProcessadores, String cpuOcisoso) {
        this.hardware = hardware;
        this.software = software;
        this.sistemaOperacional = sistemaOperacional;
        this.totalUsuarios = totalUsuarios;
        this.nucleoProcessadores = nucleoProcessadores;
        this.cpuOcisoso = cpuOcisoso;
    }

    public InfoSistemaDTO() {};

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(String totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public String getNucleoProcessadores() {
        return nucleoProcessadores;
    }

    public void setNucleoProcessadores(String nucleoProcessadores) {
        this.nucleoProcessadores = nucleoProcessadores;
    }

    public String getCpuOcisoso() {
        return cpuOcisoso;
    }

    public void setCpuOcisoso(String cpuOcisoso) {
        this.cpuOcisoso = cpuOcisoso;
    }
}
