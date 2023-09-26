import { OspedaleService } from './../../Service/ospedale.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IComune } from 'src/app/Interfaces/iComune';
import { ComuneService } from 'src/app/Service/comune.service';

@Component({
  selector: 'app-comune',
  templateUrl: './comune.component.html',
  styleUrls: ['./comune.component.scss']
})
export class ComuneComponent implements OnInit {

  comune: IComune = {
    nome: '',
    ospedali: []
  };
  @ViewChild('f') form!: NgForm;

  constructor(private route: ActivatedRoute, private service: ComuneService, private ospSvc: OspedaleService) { }

  ngOnInit(): void {
    this.getComune()
  }

  getComune() {
    this.route.params.subscribe
      ((params: any) => {
        this.service.getById(params).subscribe(
          (res) => {
            console.log(res);
            this.comune = res;
            this.ospSvc.findByComune(this.comune.nome).subscribe(
            (res) => {
              console.log(res);
              this.comune.ospedali = res;
            },
            (err) => {
              console.log(err.error.message);
            })
          },
          (err) => {
            console.log(err.error.message);
          })
      }
      )
  }
}
