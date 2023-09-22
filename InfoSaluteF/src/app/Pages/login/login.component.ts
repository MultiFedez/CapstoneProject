import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {


  @ViewChild('f') form!: NgForm;
  error: undefined | string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  submit() {
    if( this.form.value.username.trim() !== '' && this.form.value.password.trim() !== '') {
        this.authService.login(this.form.value).subscribe(
          resp => {
            console.log(resp);
            this.error = undefined;
            this.authService.loggedIn = true;
            localStorage.setItem('user', JSON.stringify(resp));
            this.router.navigate(['/home'])
          }, err => {
            console.log(err.error.message);
            this.error = err.error.message;
          })
        this.error = undefined;
    } else {
      this.error = 'Field Required';
    }

  }
}

