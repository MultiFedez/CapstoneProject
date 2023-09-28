import { IMedico } from "./iMedico";

export interface IRecensione {
  id?:number;
  commento?:string;
  voto?:number;
  medico?:IMedico
}
