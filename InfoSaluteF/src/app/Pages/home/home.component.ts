import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { IComune } from 'src/app/Interfaces/iComune';
import { ComuneService } from 'src/app/Service/comune.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  searchLocation : string = '';

  constructor(private router: Router, private comsvc:ComuneService){
  }

  submit() {
    if (this.searchLocation.trim() !== '') {
      console.log('Valore di searchLocation:', this.searchLocation);
      this.comsvc.findByNome(this.searchLocation).subscribe(
      (res) => {
        console.log(res);
        const c : IComune = res;
        this.router.navigate(['/comune/'+ c.id]);
      },
      (err) => {
        console.log(err.error.message);
      })

    }
  }

}
