import { DetalhesHostDTO } from "../dto/DetalhesHostDTO";

export const MOCK_DETALHES_HOST_DTO: DetalhesHostDTO[] = [
    {
        infoHostDTO: {
            nomeHost: "LUAN",
            horaUltimoReinicio: "07/07/07",
            diasAtivos: "8"
        },
        infoMemoriaDTO: {
            memoriaTotal: 2,
            memoriaUsada: 2,
            memoriaRam: "2",
            porcetagemMemoria: "2"
        },
        infoSistemaDTO: {
            hardware: "INTEL",
            software: "windows",
            sistemaOperacional: "windows",
            totalUsuarios: "2",
            nucleoProcessadores: "8",
            cpuOcisoso: "90"
        },
        infoProcessosDTO: [
            {
                processo: "oi",
                tipoProcesso: "Oi",
                memoriaProcesso: "oi"
            },
            {
                processo: "whatsapp",
                tipoProcesso: "whatsapp",
                memoriaProcesso: "53"
            }
        ]
    },
]