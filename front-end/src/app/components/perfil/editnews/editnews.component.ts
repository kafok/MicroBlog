import { Component, OnInit } from '@angular/core';
import { NewsService } from '../../../services/news.service';
import { News } from '../../../models/news';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'editnews',
  templateUrl: './editnews.component.html',
  styleUrls: ['./editnews.component.scss']
})
export class EditnewsComponent implements OnInit {

  public news: News;
  public msgError;
  private id: number;

  constructor(private newsService: NewsService, 
    private aroute: ActivatedRoute, 
    private userService: UserService, 
    private router: Router) { }

  ngOnInit() {
    this.news = new News();
    this.aroute.params.subscribe(params => {
      if(params.id !== undefined) {
        this.id = params.id;
        this.newsService.getNews(this.id).subscribe(res => {
          this.news = res;
          if(this.news.userId != this.userService.principal.id)
            this.router.navigate(['/home']);
        });
      } else {
        this.id = 0;
      }
    });
  }

  onSubmit() {
    if(this.id == 0)
      this.news.userId = this.userService.principal.id;

    this.newsService.save(this.news).subscribe(res => {
      this.router.navigate(['/news', res.id]);
    }, error => {
      this.msgError = "Compruebe que todos los valores son validos";
    });
  }
}
