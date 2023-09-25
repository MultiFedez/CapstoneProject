import { IReparto } from './../../../Interfaces/iReparto';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IOspedale } from 'src/app/Interfaces/iOspedale';
import { OspedaleService } from 'src/app/Service/ospedale.service';

@Component({
  selector: 'app-ospedale',
  templateUrl: './ospedale.component.html',
  styleUrls: ['./ospedale.component.scss']
})
export class OspedaleComponent implements OnInit {
  ospedale: IOspedale = {};
  reparti: IReparto[]=[];
  @ViewChild('f') form!: NgForm;

  constructor(private route: ActivatedRoute, private service: OspedaleService) { }

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
}
