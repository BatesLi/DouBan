package cn.dankal.demo.Expandable;

import android.util.Log;
import cn.dankal.demo.Expandable.api.ApiService;
import cn.dankal.demo.Expandable.bean.NewsBean;
import cn.dankal.demo.Expandable.contact.IModel;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpModel implements IModel {

  private static final String TAG = "main";
  private OnFinish onFinish;

  public interface OnFinish {
    void OnFinishListener(NewsBean newsBean);
  }

  public void setOnFinish(OnFinish onFinish) {
    this.onFinish = onFinish;
  }

  @Override public void getJson(String url) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    //动态代理得到网络接口
    ApiService apiService = retrofit.create(ApiService.class);

    Observable<NewsBean> wxNews = apiService.getWXNews();
    wxNews.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<NewsBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            Log.d(TAG, "onError:============ ");
          }

          @Override public void onNext(NewsBean newsBean) {
            //将值传出去
            onFinish.OnFinishListener(newsBean);
          }
        });
  }
}
