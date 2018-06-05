import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/login';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public principal: User;


  constructor(public http: HttpClient) { }


  public login(login: Login): Observable<any> {
    return this.http.post(environment.baseApi + "user/signin", login);
  }

  public logout(): Observable<any> {
    return this.http.post(environment.baseApi + "user/signout", {});
  }

  public getUser(id: number) {
    return this.http.get(environment.baseApi + "user/get?id=" + id);
  }

  public getPrincipal() {
    return this.http.get(environment.baseApi + "user/principal");
  }
}
