package cn.dankal.demo.ZhiHuMvp.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
  private static ZhiHuApi zhiuApiSingleton = null;

  public static ZhiHuApi getZhiuApiSingleton() {
    if (zhiuApiSingleton == null) {
      synchronized (ZhiHuApi.class) {
        Retrofit retrofit_zhihu = new Retrofit.Builder()
            .baseUrl("http://news-at.zhihu.com/api/4/")
            //.client(OkHttpManager.getInstance())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
        zhiuApiSingleton = retrofit_zhihu.create(ZhiHuApi.class);
      }
    }
    return zhiuApiSingleton;
  }
}
