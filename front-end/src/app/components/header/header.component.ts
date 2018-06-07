import { Component, OnInit,Input } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input() public title: string;
  @Input() public isUserLoggedIn: boolean;

  constructor(public userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  public logout() {
    this.userService.logout().subscribe(res => {
      this.userService.principal = undefined;
      this.router.navigate(['/home']);
    })
  }
}
