import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';
import { Login } from '../models/login';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {

  constructor(private userService: UserService, private router: Router) {}

  canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot): Observable<boolean> | boolean {
    if(this.userService.principal !== undefined && this.userService.principal !== null) {
      return true;
    }

    return new Observable<boolean>(observer => {
      this.userService.getPrincipal().subscribe(user => {
        this.userService.principal = user;
        observer.next(true);
        observer.complete();
      }, error => {
        this.userService.principal = undefined;
        observer.next(false);
        observer.complete();

        this.router.navigate['/login'];
      });
    });
  }

}
