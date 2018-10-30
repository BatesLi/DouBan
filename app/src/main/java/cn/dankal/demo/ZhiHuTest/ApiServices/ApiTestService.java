package cn.dankal.demo.ZhiHuTest.ApiServices;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiTestService {
  private static ZhiHuTestApi zhiuApiSingleton = null;

  public static ZhiHuTestApi getZhiuApiSingleton() {
    if (zhiuApiSingleton == null) {
      synchronized (ZhiHuTestApi.class) {
        Retrofit retrofit_zhihu = new Retrofit.Builder()
            .baseUrl("http://news-at.zhihu.com/api/4/")
            //.client(OkHttpManager.getInstance())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
        zhiuApiSingleton = retrofit_zhihu.create(ZhiHuTestApi.class);
      }
    }
    return zhiuApiSingleton;
  }
}
