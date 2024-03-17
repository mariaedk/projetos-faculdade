import { InfoHostDTO } from "./InfoHostDTO";
import { InfoMemoriaDTO } from "./InfoMemoriaDTO";
import { InfoProcessosDTO } from "./InfoProcessosDTO";
import { InfoSistemaDTO } from "./InfoSistemaDTO";

export interface DetalhesHostDTO {
    infoHostDTO: InfoHostDTO,
    infoMemoriaDTO: InfoMemoriaDTO,
    infoSistemaDTO: InfoSistemaDTO,
    infoProcessosDTO: Array<InfoProcessosDTO>
}