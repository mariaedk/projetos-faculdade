package com.furb.snmpProject.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "HOSTS")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_host")
    private Long cdHost;
    @Column(name = "ip_host", nullable = false, unique = true, length = 15)
    private String ipHost;
    @Column(name = "ds_ip_host", nullable = false, length = 80)
    private String dsHost;

    public Host() {}

    public Long getCdHost() {
        return cdHost;
    }

    public String getIpHost() {
        return ipHost;
    }

    public String getDsHost() {
        return dsHost;
    }
    public void setCdHost(Long cdHost) {
        this.cdHost = cdHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    public void setDsHost(String dsHost) {
        this.dsHost = dsHost;
    }

}
