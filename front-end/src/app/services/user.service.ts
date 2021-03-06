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


  constructor(private http: HttpClient) { }


  public login(login: Login): Observable<any> {
    return this.http.post(environment.baseApi + "user/signin", login);
  }

  public logout(): Observable<any> {
    return this.http.post(environment.baseApi + "user/signout", {});
  }

  public getUser(id: number): Observable<User> {
    return this.http.get<User>(environment.baseApi + "user/get?id=" + id);
  }

  public getPrincipal(): Observable<User> {
    return this.http.get<User>(environment.baseApi + "user/principal");
  }

  public isAnonymous(): boolean {
    return this.principal === undefined || this.principal === null;
  }
}
