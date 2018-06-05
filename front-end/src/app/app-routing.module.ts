import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent} from './components/login/login.component';
import {HomeComponent } from './components/home/home.component';
import {NewsComponent} from './components/news/news.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'news', component: NewsComponent }
  

];


export const routing = RouterModule.forRoot(routes);
