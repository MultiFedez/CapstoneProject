import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IMedico } from 'src/app/Interfaces/iMedico';
import { IReparto } from 'src/app/Interfaces/iReparto';
import { MedicoService } from 'src/app/Service/medico.service';
import { RepartoService } from 'src/app/Service/reparto.service';

@Component({
  selector: 'app-reparto',
  templateUrl: './reparto.component.html',
  styleUrls: ['./reparto.component.scss']
})
export class RepartoComponent implements OnInit {

  reparto: IReparto = {};
  medici : IMedico[] = [];

  constructor(private route:ActivatedRoute ,private repSvc: RepartoService, private medSvc :MedicoService){}

  ngOnInit(): void {
    this.getById()
    this.getMediciByReparto()
  }

  submit(){
  }

  getById(){
    this.route.params.subscribe
    ((params: any) => {
      this.repSvc.getById(params).subscribe(
        (res) => {
          console.log(res);
          this.reparto = res;
        },
        (err) => {
          console.log(err.error.message);
        })
    }
    )
  }

  getMediciByReparto(){
    this.route.params.subscribe
      ((params: any) => {
        this.medSvc.getMediciByReparto(params).subscribe(
          (res) => {
            console.log(res);
            this.medici = res;
          },
          (err) => {
            console.log(err.error.message);
          })
      }
      )
  }
}
