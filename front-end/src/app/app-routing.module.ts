
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './guards/login.guard';

const routes: Routes = [

  { path: 'login', component: LoginComponent },

];


export const routing = RouterModule.forRoot(routes);
