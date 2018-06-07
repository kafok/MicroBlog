
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './guards/login.guard';
import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';
import { FooterComponent } from './components/footer/footer.component';
import { EditnewsComponent } from './components/perfil/editnews/editnews.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'news', component: NewsComponent },
  { path: 'registrar', component: RegisternewsComponent},
  { path: 'editar', component: EditnewsComponent},
  { path: 'footer', component: FooterComponent }

];


export const routing = RouterModule.forRoot(routes);