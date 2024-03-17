package com.furb.snmpProject.services.snmp;

import com.furb.snmpProject.data.dto.*;
import com.furb.snmpProject.data.enums.TipoOID;
import com.furb.snmpProject.services.ping.IpRepos;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.util.TableEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TrataRequisicaoSNMP {

    private static String retorno;

    public static DetalhesHostDTO detalhesHost(String ip) {
            DetalhesHostDTO detalhesHost = new DetalhesHostDTO();

        if (IpRepos.ping(ip)) {
            detalhesHost.setInfoSistemaDTO(infoSistema(ip));
            detalhesHost.setInfoHostDTO(infoHost(ip));
            detalhesHost.setInfoMemoriaDTO(infoMemoria(ip));
            detalhesHost.setInfoProcessosDTO(infoProcessos(ip));
        }

        return detalhesHost;
    }


    // INFORMAÇÕES DO SISTEMA
    private static InfoSistemaDTO infoSistema(String ip) {
        InfoSistemaDTO infoSistema = new InfoSistemaDTO();

        tipoSO(ip, infoSistema);
        totalUsuariosSistema(ip, infoSistema);
        descSistema(ip, infoSistema);
        porcentagemProcessadoresOciosos(ip, infoSistema);

        return infoSistema;
    }

    private static void tipoSO(String ip, InfoSistemaDTO infoSistema) {

        try {
            retorno = RequisicaoSNMP.requisicaoString(ip, TipoOID.TIPO_SO).toUpperCase();
            infoSistema.setSistemaOperacional(retorno);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void descSistema(String ip, InfoSistemaDTO infoSistema) {

        try {
            retorno = RequisicaoSNMP.requisicaoString(ip, TipoOID.DESC_SISTEMA).toUpperCase();

            if(!retorno.isEmpty()) {
                String[] arr = retorno.split(" - ");
                arr[0] = arr[0].toUpperCase().replace("HARDWARE: ", "");
                arr[1] = arr[1].toUpperCase().replace("SOFTWARE: ", "");
                infoSistema.setHardware(arr[0]);
                infoSistema.setSoftware(arr[1]);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void totalUsuariosSistema(String ip, InfoSistemaDTO infoSistema) {

        try {
           retorno =  RequisicaoSNMP.requisicaoString(ip, TipoOID.TOTAL_USUARIOS);
           infoSistema.setTotalUsuarios(retorno + " usuários");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void porcentagemProcessadoresOciosos(String ip, InfoSistemaDTO infoSistema) {

        int totalProcessadores = 0;
        int porcetagemOcioso = 0;
        int totalPorcentagem;

        try {
            List<String> arr = retornaListaDadosTabela(RequisicaoSNMP.requisicaoTabela(ip, TipoOID.CPU_LOAD));

            if(!arr.isEmpty()) {
                for(String qtd : arr) {
                    porcetagemOcioso += Integer.parseInt(qtd);
                    totalProcessadores ++;
                }

                if (totalProcessadores > 0 && porcetagemOcioso > 0) {
                    totalPorcentagem = (porcetagemOcioso * 100) / (totalProcessadores * 100);
                    //TODO arredondar para cima

                    infoSistema.setNucleoProcessadores(totalProcessadores + " núcleos");
                    infoSistema.setCpuOcisoso(100 - totalPorcentagem + " %");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // INFORMAÇÕES DE HOST
    private static InfoHostDTO infoHost(String ip) {

        InfoHostDTO infoHost = new InfoHostDTO();

        nomeHost(ip, infoHost);
        tempoAtividade(ip, infoHost);

        return infoHost;
    }

    private static void nomeHost(String ip, InfoHostDTO infoHost) {
        try {
            retorno = RequisicaoSNMP.requisicaoString(ip, TipoOID.NOME_HOST);

            if(!retorno.isEmpty()) {
                infoHost.setNomeHost(retorno);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void tempoAtividade(String ip, InfoHostDTO infoHost) {
        try {
            retorno = RequisicaoSNMP.requisicaoString(ip, TipoOID.TEMPO_ATIVIDADE);

           if(!retorno.isEmpty()) {
               String[] arr = retorno.split(", ");
               if (arr.length > 1) {
                   arr[0] = arr[0].substring(arr[0].indexOf(")") + 1);
                   arr[1] = arr[1].substring(0,5);

                   infoHost.setDiasAtivos(arr[0]);
                   infoHost.setHoraUltimoReinicio(arr[1]);
               } else {
                   infoHost.setDiasAtivos("0");
                   infoHost.setHoraUltimoReinicio(arr[0]);
               }


           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    // INFORMAÇÕES DE MEMÓRIA
    private static InfoMemoriaDTO infoMemoria(String ip) {
        InfoMemoriaDTO infoMemoria = new InfoMemoriaDTO();

        memRamDisponivel(ip, infoMemoria);
        memoriaFisica(ip, infoMemoria, 'P');
        memoriaFisica(ip, infoMemoria, 'U');
        infoMemoria.setPorcetagemMemoria();

        return  infoMemoria;
    }

    private static void memRamDisponivel(String ip, InfoMemoriaDTO infoMemoria) {
        try {
            retorno = RequisicaoSNMP.requisicaoString(ip, TipoOID.RAM_DISPONIVEL).replaceAll("\\D", "");

            if(!retorno.isEmpty()) {
                float ram = converterParaGB(Long.parseLong(retorno), "kb");
                infoMemoria.setMemoriaRam(ram + " GB");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void memoriaFisica(String ip, InfoMemoriaDTO infoMemoria, char tipo) {
         try {
             TipoOID mem;

             if(tipo == 'U') {
                 mem = TipoOID.TOTAL_MEMORIA_USADA;
             } else if (tipo == 'P') {
                 mem = TipoOID.TOTAL_MEMORIA_PRINCIPAL;
             } else {
                 return;
             }

            int unidadeMemoria = Integer.parseInt(RequisicaoSNMP.requisicaoString(ip, TipoOID.VALOR_HRSTORAGEALLOCATIONUNITS));
            Long memoria= Long.parseLong(RequisicaoSNMP.requisicaoString(ip, mem));

            if (unidadeMemoria > 0 && memoria > 0) {
                float total = (float) memoria * unidadeMemoria;

                float memoriaTotal = converterParaGB(total, "b");

                if(tipo == 'U') {
                    infoMemoria.setMemoriaUsada(memoriaTotal);
                } else {
                    infoMemoria.setMemoriaTotal(memoriaTotal);
                }
            }

         } catch (Exception e) {

         }
    }


    // INFORMAÇÕES DE PROCESSOS
    private static List<InfoProcessosDTO> infoProcessos(String ip) {
        List<InfoProcessosDTO> listaProcessos = new ArrayList<>();
        tabelaDeProcessos(ip, listaProcessos);

        return  listaProcessos;
    }

    private static void tabelaDeProcessos(String ip, List<InfoProcessosDTO> listaProcessos) {
        try {
            List<String> processos = retornaListaDadosTabela(RequisicaoSNMP.requisicaoTabela(ip, TipoOID.LISTA_PROCESSOS));
            List<String> memoria = retornaListaDadosTabela(RequisicaoSNMP.requisicaoTabela(ip, TipoOID.LISTA_MEM_PROCESSOS));
            List<String> tipo = retornaListaDadosTabela(RequisicaoSNMP.requisicaoTabela(ip, TipoOID.LISTA_TIPO_PROCESSOS));

        int i = 0;

       while (i < processos.size()) {
           InfoProcessosDTO processo = new InfoProcessosDTO();

           if (processos.get(i) != null) {
               processo.setProcesso(processos.get(i));
           }
           if (tipo.get(i) != null) {
               processo.setTipoProcesso(retornaTipoProcesso(Integer.parseInt(tipo.get(i))));
           }

           if (memoria.get(i) != null) {
               processo.setMemoriaProcesso(memoria.get(i) + " KB");
           }

           i ++;
           listaProcessos.add(processo);
       }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /*  METODOS AUXILIARES */
    private static List<String> retornaListaDadosTabela( List<TableEvent> tableEvents) {
        List<String> ret = new ArrayList<>();

        for (TableEvent tableEvent : tableEvents) {
            VariableBinding[] variableBindings = tableEvent.getColumns();
            for (VariableBinding variableBinding : variableBindings) {
                ret.add(variableBinding.getVariable().toString());
            }
        }

        return ret;
    }

    private static String retornaTipoProcesso(int num) {
        String aux = switch (num) {
            case 2 ->  "SISTEMA OPERACIONAL";
            case 3 ->  "DRIVER";
            case 4 ->  "APLICAÇÃO";
            default -> "DESCONHECIDO";
        };

        return aux;
    }

    private static float converterParaGB(float numero, String unidade) {
        BigDecimal divisor;

        if (unidade.equalsIgnoreCase("kb")) {
            divisor = BigDecimal.valueOf(Math.pow(1024, 2));
        } else if (unidade.equalsIgnoreCase("b")) {
            divisor = BigDecimal.valueOf(Math.pow(1024, 3));
        } else {
            return 0;
        }

        if (divisor.compareTo(BigDecimal.ZERO) == 0) {
            return 0;
        }

        return BigDecimal.valueOf(numero).divide(divisor, 2, RoundingMode.HALF_UP).floatValue();
    }

}
