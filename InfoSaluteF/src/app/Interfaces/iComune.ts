import { IOspedale } from "./iOspedale";

export interface IComune {
  id ? : number;
  nome : string;
  ospedali : IOspedale [];
}
