package cn.dankal.demo.ZhiHuTest.ApiServices;

import cn.dankal.demo.ZhiHuTest.bean.TestNewsTimeLine;
import retrofit2.http.GET;
import rx.Observable;

public interface ZhiHuTestApi {
  //http://news-at.zhihu.com/api/4/news/latest
  @GET("news/latest") Observable<TestNewsTimeLine> getLatestNews();
}
