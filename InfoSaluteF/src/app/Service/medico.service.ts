import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { IMedico } from '../Interfaces/iMedico';

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

}
