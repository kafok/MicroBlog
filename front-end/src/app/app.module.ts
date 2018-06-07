import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgModule, enableProdMode, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { routing } from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';
import { RouterModule } from '@angular/router';
import { EditnewsComponent } from './components/perfil/editnews/editnews.component';
import { DeletenewsComponent } from './components/perfil/deletenews/deletenews.component';
import { ListnewsComponent } from './components/perfil/listnews/listnews.component';
import { LoadingComponent } from './components/loading/loading.component';
import { MarkdownModule } from 'ngx-markdown';


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
    EditnewsComponent,
    DeletenewsComponent,
    ListnewsComponent,
    LoadingComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    routing,
    MarkdownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }