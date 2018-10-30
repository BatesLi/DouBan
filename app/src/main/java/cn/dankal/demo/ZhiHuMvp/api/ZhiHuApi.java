package cn.dankal.demo.ZhiHuMvp.api;

import cn.dankal.demo.ZhiHuMvp.bean.NewsTimeLine;
import retrofit2.http.GET;
import rx.Observable;

public interface ZhiHuApi {
  //http://news-at.zhihu.com/api/4/news/latest
  @GET("news/latest") Observable<NewsTimeLine> getLatestNews();
}
