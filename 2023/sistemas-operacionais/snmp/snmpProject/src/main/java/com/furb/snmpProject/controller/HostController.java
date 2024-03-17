package com.furb.snmpProject.controller;

import com.furb.snmpProject.data.dto.DetalhesHostDTO;
import com.furb.snmpProject.data.dto.HostDTO;
import com.furb.snmpProject.data.entities.Host;
import com.furb.snmpProject.data.repositories.HostRepository;
import com.furb.snmpProject.services.ping.IpRepos;
import com.furb.snmpProject.services.snmp.TrataRequisicaoSNMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/hosts")
public class HostController {

    @Autowired
    HostRepository hostRepository;

    @GetMapping("/detalhe/{ip}")
    public DetalhesHostDTO detalhesHost(@PathVariable String ip) {
        return TrataRequisicaoSNMP.detalhesHost(ip);
    }

    @GetMapping
    public List<HostDTO> listaHosts() {
        return IpRepos.retornaIPs(hostRepository);
    }

    @PostMapping("/cadastro")
    public Host cadastrarIP(@RequestBody String ip) {
        return IpRepos.cadastraIP(ip.replaceAll("[^0-9.]", ""), hostRepository);
    }

}
