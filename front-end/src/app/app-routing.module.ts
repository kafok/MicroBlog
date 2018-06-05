
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent} from './components/login/login.component';
import {HomeComponent } from './components/home/home.component';
import {NewsComponent} from './components/news/news.component';

import { VistaPerfilComponent } from './components/perfil/vista-perfil/vista-perfil.component';
import { FondoPerfilComponent } from './components/perfil/fondo-perfil/fondo-perfil.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'news', component: NewsComponent },
  
  {
    path: 'fondo-perfil', component: FondoPerfilComponent,
    children: [
      {
        path: 'vista-perfil', component: VistaPerfilComponent,

        children: [
          { path: 'registernews', component: RegisternewsComponent},

        ]
      }

    ]
  }

];


export const routing = RouterModule.forRoot(routes);
