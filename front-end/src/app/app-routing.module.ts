
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './guards/login.guard';
import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';
import { FooterComponent } from './components/footer/footer.component';
import { EditnewsComponent } from './components/perfil/editnews/editnews.component';
import { ListnewsComponent } from './components/perfil/listnews/listnews.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
<<<<<<< HEAD
  { path: 'news', component: NewsComponent },
  { path: 'lista', component: ListnewsComponent},
=======
  { path: 'news/:id', component: NewsComponent },
>>>>>>> 5c3f520855021de21f3c68fe21c20dd442a82ed2
  { path: 'registrar', component: RegisternewsComponent},
  { path: 'editar', component: EditnewsComponent},
  { path: 'footer', component: FooterComponent },
  { path: 'news/edit/:id', component: EditnewsComponent, canActivate: [LoginGuard] },
  { path: 'news/new', component: EditnewsComponent, canActivate: [LoginGuard] }

];


export const routing = RouterModule.forRoot(routes);