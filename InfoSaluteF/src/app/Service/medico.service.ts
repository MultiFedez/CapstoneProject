import { IRecensione } from './../Interfaces/iRecensione';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { IMedico } from '../Interfaces/iMedico';
import { Observable } from 'rxjs';
import { IRecensioneTO } from '../Interfaces/iRecensioneTO';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  url: string = 'http://localhost:8080/api/medico';
  headers = new HttpHeaders();

constructor(private http:HttpClient, private usvc:UserService) {
  this.setHeaders();
 }

setHeaders(){
  this.headers = this.headers.set(
    'Authorization',
    'Bearer ' + this.usvc.getToken()
  );
}

  getMediciByReparto(params: any) {
    console.log(params);
    return this.http.get<IMedico[]>(this.url + '/byReparto/' + params.id, { headers: this.headers});
  }

  getById(params: any) {
    console.log(params);
    return this.http.get<IMedico>(this.url + '/' + params.id, { headers: this.headers});
  }

  creaCommento(rec: IRecensioneTO): Observable<IRecensione> {
    console.log(rec);
    return this.http.post('http://localhost:8080/api/recensione' + '/create', rec ,{headers: this.headers});
  }

  getRecensione(id:any){
    console.log();
    return this.http.get<IRecensione[]>('http://localhost:8080/api/recensione' + '/medico/' + id,{headers: this.headers});
  }
}
