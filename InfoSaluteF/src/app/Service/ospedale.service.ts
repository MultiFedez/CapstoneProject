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
  console.log(nome);
  return this.http.get<IOspedale[]>(this.url + '/nome/' + nome, { headers: this.headers})
}
getById(params: any) {
  console.log(params);
  return this.http.get<IOspedale>(this.url + '/' + params.id, { headers: this.headers})
}
findByComune(nome:any) {
  console.log(nome);
  return this.http.get<IOspedale[]>(this.url + '/byLocation/' + nome, { headers: this.headers})
}

}
