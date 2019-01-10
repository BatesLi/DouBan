package cn.dankal.demo.ExpandableRecyclerView.presenter;

import android.support.annotation.NonNull;
import cn.dankal.demo.ExpandableRecyclerView.api.ExpandableRecyclerService;
import cn.dankal.demo.ExpandableRecyclerView.bean.Tale;
import cn.dankal.demo.ExpandableRecyclerView.contact.ExpandableRecyclerContact;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExpandableRecyclerPresenter implements
    ExpandableRecyclerContact.ExpandableRecyclerIPresenter {

  public ExpandableRecyclerContact.ExpandableRecyclerIView iView;

  @Override public void addNetworkRequest() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://news-at.zhihu.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    ExpandableRecyclerService service = retrofit.create(ExpandableRecyclerService.class);
    Observable<Tale> tale = service.getTaleData();
    tale.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Tale>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(Tale tale) {
            iView.getExpandableRecyclerData(tale);
          }
        });
  }

  @Override
  public void attachView(@NonNull ExpandableRecyclerContact.ExpandableRecyclerIView view) {
    this.iView = view;
  }
}
