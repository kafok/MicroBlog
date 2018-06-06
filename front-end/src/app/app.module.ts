import { BrowserModule } from '@angular/platform-browser';
import { NgModule,enableProdMode } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule}   from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import {routing} from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';
import { VistaPerfilComponent } from './components/perfil/vista-perfil/vista-perfil.component';
import { FondoPerfilComponent } from './components/perfil/fondo-perfil/fondo-perfil.component';


enableProdMode();
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    NewsComponent,
    RegisternewsComponent,
    VistaPerfilComponent,
    FondoPerfilComponent
  ],
  imports: [
    BrowserModule,
    routing
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
