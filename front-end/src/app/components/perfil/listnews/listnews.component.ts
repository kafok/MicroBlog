import { Component, OnInit } from '@angular/core';
import { News } from '../../../models/news';
import { NewsService } from '../../../services/news.service';

@Component({
  selector: 'listnews',
  templateUrl: './listnews.component.html',
  styleUrls: ['./listnews.component.scss']
})
export class ListnewsComponent implements OnInit {

  public news: Array<News>;
  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.news = new Array<News>();
    this.newsService.listByUser(0, 10, 0).subscribe(news => {
      this.news = news;
    });
  }
}