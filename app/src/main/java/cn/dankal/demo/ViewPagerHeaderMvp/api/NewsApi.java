package cn.dankal.demo.ViewPagerHeaderMvp.api;

import cn.dankal.demo.ViewPagerHeaderMvp.bean.NewsBean;
import retrofit2.http.GET;
import rx.Observable;

public interface NewsApi {
  // http://news-at.zhihu.com/api/4/news/latest
  @GET("api/4/news/latest")
  Observable<NewsBean> getNewsData();
}
