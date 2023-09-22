import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Pages/login/login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { HomeComponent } from './Pages/home/home.component';
import { OspedaliComponent } from './Pages/ospedali/ospedali.component';
import { AuthGuard } from './Guard/auth.guard';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
