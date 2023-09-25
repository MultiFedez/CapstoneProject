import { Component, OnInit, ViewChild, untracked } from '@angular/core';
import { NgForm } from '@angular/forms';
import { IOspedale } from 'src/app/Interfaces/iOspedale';
import { OspedaleService } from 'src/app/Service/ospedale.service';

@Component({
  selector: 'app-ospedali',
  templateUrl: './ospedali.component.html',
  styleUrls: ['./ospedali.component.scss']
})
export class OspedaliComponent implements OnInit {
  ospedali: IOspedale [] = [];
  @ViewChild('f') Bform!: NgForm;
  @ViewChild('s') Sform!: NgForm;

  best : string = '';

  constructor(private svc:OspedaleService){}

  submit() {
    console.log(this.Bform.value.nome);
    console.log(this.Sform.value.nome);
    let nome = "";
    if(this.Sform.value.nome == null || this.Sform.value.nome == undefined || this.Sform.value.nome == ""){
      nome = this.Bform.value.nome
    }else{
      nome = this.Sform.value.nome
    }
    this.svc.findByNome(nome).subscribe(
      (res) => {
        console.log(res);
        this.ospedali=res;
        this.Bform.reset();
        this.Sform.reset();
      },
      (err) => {
        console.log(err.error.message);
      }
    )
  }

  ngOnInit(): void {
    this.getAllOspedali();
  }
  getAllOspedali() {
    this.svc.getAllOspedali().subscribe(
      (res) => {
        console.log(res);
        this.ospedali=res;
      },
      (err) => {
        console.log(err.error.message);

      }
    )
  }

}
