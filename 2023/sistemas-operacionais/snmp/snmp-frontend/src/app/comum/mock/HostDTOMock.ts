import { HostDTO } from "../dto/HostDTO"

export const ARRAY_HOST_DTO: HostDTO[] = [
    {
        cdHost: 1,
        ipHost: "192.168.1.2",
        dsHost: "Luan",
        pingRede: true,
        latencia: 12
    },
    {
        cdHost: 2,
        ipHost: "192.168.1.5",
        dsHost: "Maria",
        pingRede: true,
        latencia: 3
    },
    {
        cdHost: 3,
        ipHost: "128.211.4.2",
        dsHost: "Heitor",
        pingRede: false,
        latencia: -2
    }
]