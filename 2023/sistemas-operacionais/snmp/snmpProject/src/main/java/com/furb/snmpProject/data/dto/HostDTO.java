package com.furb.snmpProject.data.dto;

import com.furb.snmpProject.data.entities.Host;

public class HostDTO extends Host {
    private boolean pingRede;
    private int latencia;

    public  HostDTO() {
        super();
    }

    public boolean isPingRede() {
        return pingRede;
    }

    public void setPingRede(boolean pingRede) {
        this.pingRede = pingRede;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }
}
