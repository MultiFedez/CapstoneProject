import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { IReparto } from '../Interfaces/iReparto';

@Injectable({
  providedIn: 'root'
})
export class RepartoService {

  url: string = 'http://localhost:8080/api/reparto';
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

  findRepartoByOspedaleid(params: any) {
    console.log(params);
    return this.http.get<IReparto[]>(this.url + '/byOspedale/' + params.id, { headers: this.headers});
  }

  getById(params:any){
    console.log(params);
    return this.http.get<IReparto>(this.url + '/' + params.id, { headers: this.headers});
  }

}
