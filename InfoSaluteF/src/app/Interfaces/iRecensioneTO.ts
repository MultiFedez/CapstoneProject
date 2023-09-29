import { IMedicoIdDTO } from "./iMedicoIdDTO";

export interface IRecensioneTO {
  commento?:string;
  voto?:number;
  medico?: IMedicoIdDTO
}
