import { Component, OnInit, ViewChild } from '@angular/core';
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
  @ViewChild('f') form!: NgForm;

  constructor(private svc:OspedaleService){}

  submit() {
    this.svc.findByNome(this.form.value.nome).subscribe(
      (res) => {
        console.log(res);
        this.ospedali=res;
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
