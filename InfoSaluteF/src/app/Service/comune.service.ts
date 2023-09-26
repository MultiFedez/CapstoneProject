import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { IComune } from '../Interfaces/iComune';

@Injectable({
  providedIn: 'root'
})
export class ComuneService {

  url: string = 'http://localhost:8080/api/comune';
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

  findByNome(nome: string){
    return this.http.get<IComune>(this.url + '/nome/' + nome, { headers: this.headers})
  }

  getById(params: any) {
    console.log(params);
    return this.http.get<IComune>(this.url + '/' + params.id, { headers: this.headers})
  }
}
