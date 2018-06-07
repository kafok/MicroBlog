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
  public offset: number;

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.offset = 0;
    this.news = new Array<News>();
    this.mas();
  }


  public mas() {
    this.newsService.list(this.offset, 10).subscribe(news => {
      for(var n of news)
        this.news.push(n);
      this.offset += 10;
    });
  }
}