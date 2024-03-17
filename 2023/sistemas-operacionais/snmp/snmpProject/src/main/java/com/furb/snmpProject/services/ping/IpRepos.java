package com.furb.snmpProject.services.ping;

import com.furb.snmpProject.data.dto.HostDTO;
import com.furb.snmpProject.data.entities.Host;
import com.furb.snmpProject.data.enums.TipoOID;
import com.furb.snmpProject.data.repositories.HostRepository;
import com.furb.snmpProject.services.snmp.RequisicaoSNMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpRepos {

    @Autowired
    private HostRepository hostRepository;

    public static boolean ping(String host) {
        try {
            return InetAddress.getByName(host).isReachable(3000);
        } catch (IOException e) {
            return false;
        }
    }
    public static int latenciaPing(String host) {
            long tempoInicial = System.nanoTime();
            long tempoFinal;

            if (ping(host)) {
                tempoFinal = System.nanoTime();
                return (int) ((tempoFinal - tempoInicial) / 1000000);
            } else {
                return -1;
            }
    }

    public static boolean validaIPV4(String ip) {
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        return ip.matches(ipv4Pattern);
    }

    public static Host cadastraIP(String ip, HostRepository repos) {

        Host host = new Host();

        try {
            if (validaIPV4(ip) && ping(ip)) {

                host.setIpHost(ip);
                host.setDsHost(RequisicaoSNMP.requisicaoString(ip, TipoOID.NOME_HOST));

                repos.save(host);
            }

        } catch (Exception e) {
            //TODO ver exceção
        }

        return host;
    }

    public static List<HostDTO> retornaIPs(HostRepository repository) {
        List<Host> hosts = repository.findAll();
        List<HostDTO> ret = new ArrayList<>();

        for(Host host : hosts) {
            HostDTO aux = new HostDTO();
                    aux.setCdHost(host.getCdHost());
                    aux.setIpHost(host.getIpHost());
                    aux.setDsHost(host.getDsHost());
                    aux.setPingRede(ping(host.getIpHost()));
                    aux.setLatencia(latenciaPing(host.getIpHost()));

            ret.add(aux);
        }

        return ret;
    }
}
