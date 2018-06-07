import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../services/news.service';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from '../../models/news';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {

  public loaded: boolean;
  public news: News;

  constructor(private newsService: NewsService, 
    private aroute: ActivatedRoute, 
    private userService: UserService,
    private router: Router) { }

  ngOnInit() {
    this.aroute.params.subscribe(params => {
      this.newsService.getNews(params.id).subscribe(res => {
        this.news = res;
        this.loaded = true;
      }, error => {
        this.news = null;
        this.loaded = true;
      });
    });
  }


  public imOwner(): boolean {
    if(this.userService.isAnonymous())
      return false;

    return this.userService.principal.id == this.news.userId;
  }
}
