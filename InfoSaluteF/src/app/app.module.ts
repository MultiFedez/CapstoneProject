import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './Pages/login/login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './Pages/home/home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { OspedaliComponent } from './Pages/ospedali/ospedali.component';
import { OspedaleComponent } from './Pages/ospedali/ospedale/ospedale.component';
import { ComuneComponent } from './Pages/comune/comune.component';
import { RepartoComponent } from './Pages/reparto/reparto.component';
import { MedicoComponent } from './Pages/medico/medico.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavBarComponent,
    OspedaliComponent,
    OspedaleComponent,
    ComuneComponent,
    RepartoComponent,
    MedicoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
