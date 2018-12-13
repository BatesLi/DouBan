package cn.dankal.demo.Expandable.api;

import cn.dankal.demo.Expandable.bean.NewsBean;
import retrofit2.http.GET;

public interface ApiService {
  @GET("api/4/news/latest")
  rx.Observable<NewsBean> getWXNews();
}
