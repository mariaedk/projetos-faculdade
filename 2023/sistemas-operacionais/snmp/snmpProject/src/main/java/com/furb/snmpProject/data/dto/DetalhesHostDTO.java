package com.furb.snmpProject.data.dto;

import java.util.ArrayList;
import java.util.List;

public class DetalhesHostDTO {
    private InfoHostDTO infoHostDTO;
    private InfoMemoriaDTO infoMemoriaDTO;
    private InfoSistemaDTO infoSistemaDTO;
    private List<InfoProcessosDTO> infoProcessosDTO = new ArrayList<>();


    public DetalhesHostDTO(InfoHostDTO infoHostDTO, InfoMemoriaDTO infoMemoriaDTO, InfoSistemaDTO infoSistemaDTO, List<InfoProcessosDTO> infoProcessosDTO) {
        this.infoHostDTO = infoHostDTO;
        this.infoMemoriaDTO = infoMemoriaDTO;
        this.infoSistemaDTO = infoSistemaDTO;
        this.infoProcessosDTO = infoProcessosDTO;
    }

    public DetalhesHostDTO() {};

    public InfoHostDTO getInfoHostDTO() {
        return infoHostDTO;
    }

    public void setInfoHostDTO(InfoHostDTO infoHostDTO) {
        this.infoHostDTO = infoHostDTO;
    }

    public InfoMemoriaDTO getInfoMemoriaDTO() {
        return infoMemoriaDTO;
    }

    public void setInfoMemoriaDTO(InfoMemoriaDTO infoMemoriaDTO) {
        this.infoMemoriaDTO = infoMemoriaDTO;
    }

    public InfoSistemaDTO getInfoSistemaDTO() {
        return infoSistemaDTO;
    }

    public void setInfoSistemaDTO(InfoSistemaDTO infoSistemaDTO) {
        this.infoSistemaDTO = infoSistemaDTO;
    }

    public List<InfoProcessosDTO> getInfoProcessosDTO() {
        return infoProcessosDTO;
    }

    public void setInfoProcessosDTO(List<InfoProcessosDTO> infoProcessosDTO) {
        this.infoProcessosDTO = infoProcessosDTO;
    }
}
