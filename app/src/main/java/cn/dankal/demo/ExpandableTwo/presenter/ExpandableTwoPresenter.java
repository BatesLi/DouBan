package cn.dankal.demo.ExpandableTwo.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import cn.dankal.demo.ExpandableTwo.api.StoryService;
import cn.dankal.demo.ExpandableTwo.bean.StoryBean;
import cn.dankal.demo.ExpandableTwo.contact.ExpandableTwoContact;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExpandableTwoPresenter implements ExpandableTwoContact.ExpandableTwoIPresenter {

  public ExpandableTwoContact.ExpandableTwoIView iView;
  private static final String TAG = "main";

  @Override public void RequestData(String url, ExpandableTwoContact.OnClick onClick) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    //动态代理得到网络接口
    StoryService storyService = retrofit.create(StoryService.class);

    Observable<StoryBean> wxNews = storyService.getStoryData();
    wxNews.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<StoryBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            Log.d(TAG, "onError:============ ");
          }

          @Override public void onNext(StoryBean storyBean) {
            //将值传出去
            List<StoryBean.StoriesBean> storiesBeanList = storyBean.getStories();
            iView.Success(storiesBeanList);
          }
        });
  }

  @Override public void attachView(@NonNull ExpandableTwoContact.ExpandableTwoIView view) {
    this.iView = view;
  }

  @Override public void detachView() {
    iView = null;
  }
}
