import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app';
  public loaded;

  public constructor(private userService: UserService) {}

  ngOnInit() {
    this.loaded = false;
    this.userService.getPrincipal().subscribe(res => {
      this.userService.principal = res;
      this.loaded = true;
    }, error => {
      this.loaded = true;
    });
  }
}
