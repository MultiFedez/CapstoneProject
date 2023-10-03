import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, map, pipe, tap } from 'rxjs';
import { environment } from 'src/Environment/environment.prod';
import { IAuthData } from '../Interfaces/iAuthData';
import { IRegister } from '../Interfaces/iRegister';
import { ILogin } from '../Interfaces/iLogin';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  headers = new HttpHeaders;
  loggedIn: boolean = false;

  jwtHelper: JwtHelperService = new JwtHelperService();
  private authSubject = new BehaviorSubject<null | Object>(null);

  user$ = this.authSubject.asObservable();
  isLoggedIn$ = this.user$.pipe(map((data: any) => Boolean(data)));

  constructor(private http: HttpClient, private router: Router) {
    this.restoreUser();
  }

  register(user:IRegister) : Observable<any> {
    return this.http.post(environment.urlRegister, user);
  }

  login(user:ILogin) : Observable<any> {
    return this.http.post(environment.urlLogin, user)
    .pipe(tap((data: any) => this.authSubject.next(data)));
  }

  logout() {
    this.authSubject.next(null);
    localStorage.removeItem('user');
    console.log('Utente Sloggato');
    this.router.navigate(['/login']);
  }

  isAuth() {
    // return false;
    // return this.loggedIn;
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(this.loggedIn)
      }, 1000)
    })
  }

  restoreUser() {
    const userJson = localStorage.getItem('user');
    if (!userJson) {
      return;
    }
    const user = JSON.parse(userJson);
    if (this.jwtHelper.isTokenExpired(user.accessToken)) {
      console.log(user.accessToken);
      this.router.navigate(['/auth/login']);
      localStorage.clear();
      return;
    } else {
      this.authSubject.next(user);
     // this.router.navigate(['/home']);
      return;
    }
  }


}
