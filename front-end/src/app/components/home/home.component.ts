import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../services/news.service';
import { News } from '../../models/news';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: []
})
export class HomeComponent implements OnInit {

  public news: Array<News>;

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.news = new Array<News>();
    this.newsService.list(0, 10).subscribe(news => {
      this.news = news;
    });
  }
}