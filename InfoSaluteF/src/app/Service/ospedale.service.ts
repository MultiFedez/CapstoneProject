import { UserService } from './user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IOspedale } from '../Interfaces/iOspedale';

@Injectable({
  providedIn: 'root'
})
export class OspedaleService {

  url: string = 'http://localhost:8080/api/ospedale';
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


getAllOspedali() {
  return this.http.get<IOspedale[]>(this.url + '/all', { headers: this.headers})
}
findByNome(nome : string){
  return this.http.get<IOspedale[]>(this.url + '/' + nome, { headers: this.headers})
}
}
