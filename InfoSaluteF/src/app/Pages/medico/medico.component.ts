import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IRecensione } from 'src/app/Interfaces/iRecensione';
import { IRecensioneTO } from 'src/app/Interfaces/iRecensioneTO';
import { MedicoService } from 'src/app/Service/medico.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.scss']
})
export class MedicoComponent implements OnInit {

  medicoid!: number | any;
  medico: any;
  percorso: string = '';
  recensioni: IRecensione[] = [];
  recensione: IRecensione = {
    commento: '',
    voto: 0,
  };
  valutazione: number = 0;

  constructor(private route:ActivatedRoute ,private medSvc :MedicoService){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.medicoid = JSON.parse(params.get('id')!)
      this.findRecensione();
      this.getById();
      this.setPercorso();
    });

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

  inviaCommento(){
    const formData = new FormData();
    console.log(this.recensione.commento, this.recensione.voto);
    const rec : IRecensioneTO = {
      commento: this.recensione.commento,
      voto: this.recensione.voto,
      medico: {
        id: this.medicoid
      }
    };
   // formData.append("commento", this.recensione.commento!);
   //formData.append("voto", this.recensione.voto!.toString());
    rec.commento = this.recensione.commento;
    console.log(this.medicoid);
    rec.medico!.id! = this.medicoid;
    rec.voto = this.recensione.voto;

    this.medSvc.creaCommento(rec).subscribe((data) =>{
      console.log("Commento creato con successo!");
      this.findRecensione();
      this.recensione = {};
    },(err)=>{
      console.log(err);
    })
  }

  findRecensione(){
    this.recensioni = [];
    this.medSvc.getRecensione(this.medicoid).subscribe(
      (res) => {
        console.log(res);
        this.recensioni=res;
        this.findValutazioneMedia();
      },
      (err) => {
        console.log(err.error.message);
      }
    )
  }

  findValutazioneMedia() {
    this.valutazione = 0
    this.recensioni.forEach((rec)=>{
      console.log(rec.voto);

      this.valutazione = this.valutazione + rec.voto!;
      console.log(this.valutazione);
    })
    this.valutazione = Math.round(this.valutazione/this.recensioni.length)
    console.log(this.valutazione);

  }
}
