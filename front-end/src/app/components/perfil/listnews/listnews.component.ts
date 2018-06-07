import { Component, OnInit } from '@angular/core';
import { News } from '../../../models/news';
import { NewsService } from '../../../services/news.service';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'listnews',
  templateUrl: './listnews.component.html',
  styleUrls: ['./listnews.component.scss']
})
export class ListnewsComponent implements OnInit {

  public news: Array<News>;
  public offset: number;

  constructor(private newsService: NewsService, private userService: UserService) { }

  ngOnInit() {
    this.news = new Array<News>();
    this.offset = 0;
    this.mas();
  }

  public mas() {
    this.newsService.listByUser(this.offset, 10, this.userService.principal.id).subscribe(news => {
      for(var n of news)
        this.news.push(n);
      this.offset += 10;
    });
  }
}