
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { VistaPerfilComponent } from './components/perfil/vista-perfil/vista-perfil.component';
import { FondoPerfilComponent } from './components/perfil/fondo-perfil/fondo-perfil.component';
import { RegisternewsComponent } from './components/perfil/registernews/registernews.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  
  { path: 'vista-perfil', component: FondoPerfilComponent,
    
  children: [
          { path: 'registrar', component: RegisternewsComponent}

        ]
      }

    ];


    export const routing = RouterModule.forRoot(routes);
   