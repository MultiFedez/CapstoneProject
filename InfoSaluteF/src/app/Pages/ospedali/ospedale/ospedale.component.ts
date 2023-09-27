import { IReparto } from './../../../Interfaces/iReparto';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IOspedale } from 'src/app/Interfaces/iOspedale';
import { OspedaleService } from 'src/app/Service/ospedale.service';
import { RepartoService } from 'src/app/Service/reparto.service';

@Component({
  selector: 'app-ospedale',
  templateUrl: './ospedale.component.html',
  styleUrls: ['./ospedale.component.scss']
})
export class OspedaleComponent implements OnInit {

  ospedale: IOspedale = {};
  reparti: IReparto[]=[];
  percorso: string = '';
  @ViewChild('f') form!: NgForm;

  constructor(private route: ActivatedRoute, private service: OspedaleService, private repSvc:RepartoService) { }

  submit() {

  }

  /*getAllReparti() {
    this.svc.getAllReparti().subscribe(
      (res: IReparto[]) => {
        console.log(res);
        this.reparti=res;
      },
      (err: { error: { message: any; }; }) => {
        console.log(err.error.message);

      }
    )
  }*/

  ngOnInit(): void {
    this.getOspedale()
    this.findRepartoByOspedaleid()
    this.setPercorso()
  }

  setPercorso() {
    const page = 'ospedale'
    const num = Math.floor(Math.random() * 5) + 1;
    this.percorso = page + num
  }

  getOspedale() {
    this.route.params.subscribe
      ((params: any) => {
        this.service.getById(params).subscribe(
          (res) => {
            console.log(res);
            this.ospedale = res;
          },
          (err) => {
            console.log(err.error.message);
          })
      }
      )
  }

  findRepartoByOspedaleid(){
    this.route.params.subscribe
      ((params: any) => {
        this.repSvc.findRepartoByOspedaleid(params).subscribe(
          (res) => {
            console.log(res);
            this.reparti = res;
          },
          (err) => {
            console.log(err.error.message);
          })
      }
      )
  }



}
