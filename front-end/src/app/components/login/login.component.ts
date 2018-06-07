import { Component, OnInit } from '@angular/core';
import { Login } from '../../models/login';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 
  public login: Login;
  public msgError: string;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    this.login = new Login();
    if(!this.userService.isAnonymous())
      this.router.navigate(['/home']);
  }


  onSubmit() {
    this.userService.login(this.login).subscribe(res => {
      this.userService.principal = res;
      this.router.navigate(['/home']);
    }, error => {
      this.msgError = "Email o contraseña incorrectos";
    });
  }
}