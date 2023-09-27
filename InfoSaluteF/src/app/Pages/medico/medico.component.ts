import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicoService } from 'src/app/Service/medico.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent implements OnInit {

  medico: any;
  percorso: string = '';

  constructor(private route:ActivatedRoute ,private medSvc :MedicoService){}

  ngOnInit(): void {
    this.getById();
    this.setPercorso();
  }
  setPercorso() {
    const page = 'medico'
    const num = Math.floor(Math.random() * 5) + 1;
    this.percorso = page + num
  }

  getById(){
    this.route.params.subscribe
    ((params: any) => {
      this.medSvc.getById(params).subscribe(
        (res) => {
          console.log(res);
          this.medico = res;
        },
        (err) => {
          console.log(err.error.message);
        })
    }
    )
  }
}
