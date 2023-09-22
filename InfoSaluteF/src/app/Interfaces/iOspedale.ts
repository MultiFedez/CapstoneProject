import { IComune } from "./iComune";

export interface IOspedale {
  id ? : number;
  nome : string;
  indirizzo : string;
  descrizione : string;
  comune : IComune;
}
