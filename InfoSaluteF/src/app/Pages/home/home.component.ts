import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  searchLocation : string = '';

  constructor(private router: Router){}

  submit() {
    if (this.searchLocation.trim() !== '') {
      console.log('Valore di searchLocation:', this.searchLocation);
      this.router.navigate(['/ospedali', this.searchLocation]);
    }
  }

}
