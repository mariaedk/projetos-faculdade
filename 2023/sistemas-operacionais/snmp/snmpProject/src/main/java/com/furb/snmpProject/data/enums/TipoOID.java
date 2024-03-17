package com.furb.snmpProject.data.enums;

public enum TipoOID {

    // INFORMAÇÕES DE SISTEMAS
    TIPO_SO(".1.3.6.1.2.1.1.6.0", "Tipo do sistema operacional", SNMPType.STRING),
    DESC_SISTEMA(".1.3.6.1.2.1.1.1.0", "Descrição do sistema", SNMPType.STRING),
    TOTAL_USUARIOS(".1.3.6.1.2.1.25.1.5.0", "Número total de usuários no sistema", SNMPType.INTEGER),
    CPU_LOAD(".1.3.6.1.2.1.25.3.3.1.2", "Carga média que as CPUs não ficaram ociosos no ultimo minuto em %", SNMPType.INTEGER),


    //INFORMAÇÕES DE HOST
    NOME_HOST(".1.3.6.1.2.1.1.5.0", "Nome do host", SNMPType.STRING),
    DATA_HORA_HOST(".1.3.6.1.2.1.25.1.2.0", "Data e Hora do host", SNMPType.STRING), //  formato não pega n irei colocar
    TEMPO_ATIVIDADE(".1.3.6.1.2.1.25.1.1.0", "Tempo de atividade do sistema", SNMPType.INTEGER),



    // INFORMAÇÕES DE MEMÓRIA
    RAM_DISPONIVEL(".1.3.6.1.2.1.25.2.2.0", "Memória RAM disponível em kb", SNMPType.INTEGER),
    TOTAL_MEMORIA_USADA(".1.3.6.1.2.1.25.2.3.1.6.1", "Total da memoria em  hrstorageallocationunits", SNMPType.INTEGER),
    TOTAL_MEMORIA_PRINCIPAL(".1.3.6.1.2.1.25.2.3.1.5.1", "Total da memória principal em hrStorageAllocationUnits", SNMPType.INTEGER),
    VALOR_HRSTORAGEALLOCATIONUNITS(".1.3.6.1.2.1.25.2.3.1.4.1", "Valor de uma unidade de  hrStorageAllocationUnits", SNMPType.INTEGER),


    // Informações de Processos
    LISTA_PROCESSOS(".1.3.6.1.2.1.25.4.2.1.2", "Lista de Nomes de Processos em Execução", SNMPType.TABLE),
    LISTA_TIPO_PROCESSOS(".1.3.6.1.2.1.25.4.2.1.6", "lista de Tipos de Processos", SNMPType.TABLE),
    LISTA_MEM_PROCESSOS(".1.3.6.1.2.1.25.5.1.1.2", "lista de Memoria dos Processos", SNMPType.TABLE);


    private final String oid;
    private final String descricao;
    private final SNMPType type;

    TipoOID(String oid, String descricao, SNMPType type) {
        this.oid = oid;
        this.descricao = descricao;
        this.type = type;
    }

    public enum SNMPType {
        STRING, INTEGER, TABLE
    }

    public String getOID() {
        return oid;
    }

    public String getDescricao() {
        return descricao;
    }

    public SNMPType getType() {
        return type;
    }
}
