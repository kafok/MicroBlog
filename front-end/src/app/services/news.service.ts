import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { News } from '../models/news';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) { }
  

  public getNews(id: number): Observable<News> {
    return this.http.get<News>(environment.baseApi + "news/get?id=" + id);
  }

  public save(news: News): Observable<News> {
    return this.http.post<News>(environment.baseApi + "news/save", news);
  }

  public list(offset: number, limit: number): Observable<News[]> {
    return this.http.get<News[]>(environment.baseApi + "news/list?offset=" + offset + "&limit=" + limit);
  }

  public listByUser(offset: number, limit: number, id:number): Observable<News[]> {
    return this.http.get<News[]>(environment.baseApi + "news/listByUser?offset=" + offset + "&limit=" + limit + "&id=" + id);
  }


}
