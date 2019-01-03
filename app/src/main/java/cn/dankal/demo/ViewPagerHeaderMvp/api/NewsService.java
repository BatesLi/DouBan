package cn.dankal.demo.ViewPagerHeaderMvp.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsService {

  private static NewsApi getNewsData = null;

  public static NewsApi getNewsJsonData() {
    if (getNewsData == null) {
      synchronized (NewsApi.class) {
        if (getNewsData == null) {
          Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("http://news-at.zhihu.com/")
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
              .build();
          getNewsData = retrofit.create(NewsApi.class);
        }
      }
    }
    return getNewsData;
  }
}









