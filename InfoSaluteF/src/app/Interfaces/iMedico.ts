import { Specializzazione } from "./Specializzazione.enum";

export interface IMedico {
  id ? : number;
  nome? : string;
  specializzazione? :Specializzazione ;
  valutazione? : number[];
  repartoid? : number;
}
