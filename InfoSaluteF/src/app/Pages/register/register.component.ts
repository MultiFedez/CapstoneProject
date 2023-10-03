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


 // submit(){
      //this.authSvc.register(this.fG.value).subscribe(res=>{
        //this.router.navigate(["/login"]);
      //});
    //}

//   register() {
//       this.authSvc.register(this.fG.value).subscribe(
//         (response) => {
//           console.log('Risposta dal server:', response);
//           this.router.navigate(['/login']);
//         },
//         (error) => {
//           console.error('Errore durante la registrazione:', error);
//           this.errorMessage = 'Errore durante la registrazione. Riprova più tardi.';
//         }
//       );
//     }
// }

register() {
  if (this.fG.value.username.trim() !== '' && this.fG.value.password.trim() !== '' && this.fG.value.name.trim() !== ''
    && this.fG.value.email.trim() !== '') {
    this.authSvc.register(this.fG.value).subscribe(
      resp => {
        console.log(resp);
        this.error = undefined;
        this.router.navigate(['/login'])
      }, err => {
        console.log(err.error.message);
        this.error = err.error.message;
        this.router.navigate(['/login']);
      })
    this.error = undefined;
  } else {
    this.error = 'Tutti i campi sono obbligatori';
  }
}
}
