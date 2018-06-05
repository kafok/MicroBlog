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


enableProdMode();
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    routing,
    CommonModule,
    FormsModule,
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
