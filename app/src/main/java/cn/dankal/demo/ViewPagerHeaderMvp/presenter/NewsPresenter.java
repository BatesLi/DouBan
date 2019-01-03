package cn.dankal.demo.ViewPagerHeaderMvp.presenter;

import android.support.annotation.NonNull;
import cn.dankal.demo.ViewPagerHeaderMvp.ExpandableContact.ExpandableContact;
import cn.dankal.demo.ViewPagerHeaderMvp.api.NewsService;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.NewsBean;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsPresenter implements ExpandableContact.ExpandableIPresenter {

  public ExpandableContact.ExpandableIView iView;

  @Override public void requestExpandableJso() {
    Observable<NewsBean> newsBean = NewsService.getNewsJsonData().getNewsData();
    newsBean.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<NewsBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(NewsBean newsBean) {
            iView.getExpandableData(newsBean.getStories());
          }
  });
  }

  @Override public void attachView(@NonNull ExpandableContact.ExpandableIView view) {
    this.iView = view;
  }

  @Override public void detachView() {

  }
}
