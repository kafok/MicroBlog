import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import {routing} from './app-routing.module';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';
import { VistaPerfilComponent } from './components/perfil/vista-perfil/vista-perfil.component';
import { FondoPerfilComponent } from './components/perfil/fondo-perfil/fondo-perfil.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
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
