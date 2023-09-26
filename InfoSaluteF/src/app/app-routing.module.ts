import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Pages/login/login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { HomeComponent } from './Pages/home/home.component';
import { OspedaliComponent } from './Pages/ospedali/ospedali.component';
import { AuthGuard } from './Guard/auth.guard';
import { OspedaleComponent } from './Pages/ospedali/ospedale/ospedale.component';
import { ComuneComponent } from './Pages/comune/comune.component';
import { RepartoComponent } from './Pages/reparto/reparto.component';
import { MedicoComponent } from './Pages/medico/medico.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },{
    path: 'login',
    component: LoginComponent
  },{
    path: "register",
  component: RegisterComponent
  },{
    path: "home",
    component: HomeComponent,
    canActivate: [AuthGuard]
  },{
    path: "ospedali",
    component: OspedaliComponent,
    canActivate: [AuthGuard]
  },{
    path: "ospedale/:id",
    component: OspedaleComponent,
    canActivate: [AuthGuard]
  },{
    path: "comune/:id",
    component: ComuneComponent,
    canActivate: [AuthGuard]
  },{
    path: "reparto/:id",
    component: RepartoComponent,
    canActivate: [AuthGuard]
  },{
    path: "medico/:id",
    component: MedicoComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
