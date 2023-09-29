import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  fG!:FormGroup;
  registrationData: any = {};
  errorMessage: string = '';
  error: string | undefined;

  constructor(private authSvc:AuthService, private router:Router) { }

  ngOnInit(): void {
    this.fG=new FormGroup({
      name: new FormControl(""),
      lastname: new FormControl(""),
      username: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required),
    });

  }


  submit(){
      this.authSvc.register(this.fG.value).subscribe(res=>{
        this.router.navigate(["/login"]);
      });
    }
  register() {
      this.authSvc.register(this.fG.value).subscribe(
        (response) => {
          console.log('Risposta dal server:', response);
          this.router.navigate(['/login']);
        },
        (error) => {
          console.error('Errore durante la registrazione:', error);
          this.errorMessage = 'Errore durante la registrazione. Riprova più tardi.';
        }
      );
    }
}

