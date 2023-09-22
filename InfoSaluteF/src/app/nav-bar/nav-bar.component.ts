import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  ngOnInit(): void {
    // Inizializza il toggler della barra di navigazione
    const navbarToggler = document.querySelector('.navbar-toggler') as HTMLElement;
    const navbarCollapse = document.querySelector('.navbar-collapse') as HTMLElement;

    navbarToggler.addEventListener('click', () => {
      navbarToggler.classList.toggle('show');

    });
  }
}
