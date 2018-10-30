package cn.dankal.demo.ZhiHuTest.P;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.ZhiHuTest.ApiServices.ApiTestService;
import cn.dankal.demo.ZhiHuTest.adapter.ZhiHuTestAdapter;
import cn.dankal.demo.ZhiHuTest.bean.TestNewsTimeLine;
import cn.dankal.demo.ZhiHuTest.contact.ZhiHuTestContact;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ZhiHuTestPresenter implements ZhiHuTestContact.ZhiHuTestIPrsenter {

  public RecyclerView mRecyclerView;
  public LinearLayoutManager linearLayoutManager;
  public ZhiHuTestContact.ZhiHuTestIView mZhiHuTestIView;
  public Context mContext;
  protected TestNewsTimeLine mNewsTimeLine;
  protected ZhiHuTestAdapter zhiHuTestAdapter;
  String time;
  private boolean isLoadMore = false;

  public ZhiHuTestPresenter(Context context) {
    this.mContext = context;
  }

  public void getData() {
    /*if (mRecyclerView != null) {
      mRecyclerView = mZhiHuTestIView.getRecyclerView();
      linearLayoutManager = mZhiHuTestIView.getLinearManager();
    }*/
    ApiTestService.getZhiuApiSingleton().getLatestNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<TestNewsTimeLine>() {
          @Override public void call(TestNewsTimeLine testNewsTimeLine) {
            mZhiHuTestIView.success();
            mRecyclerView = mZhiHuTestIView.getRecyclerView();
            linearLayoutManager = mZhiHuTestIView.getLinearManager();
            zhiHuTestAdapter = new ZhiHuTestAdapter(mContext, testNewsTimeLine);
            mRecyclerView.setAdapter(zhiHuTestAdapter);
            zhiHuTestAdapter.notifyDataSetChanged();
          }
        });
  }

  private void loadError(Throwable throwable) {
    throwable.printStackTrace();
    ToastUtil.toToast("出错啦");
  }

  public void disPlayZhiHuList(TestNewsTimeLine newsTimeLine, Context context
      , ZhiHuTestContact.ZhiHuTestIView zhiHuTestIView, RecyclerView recyclerView) {

    newsTimeLine.getStories().addAll(newsTimeLine.getStories());

    zhiHuTestAdapter.notifyDataSetChanged();

    mNewsTimeLine = newsTimeLine;
    zhiHuTestAdapter = new ZhiHuTestAdapter(context, newsTimeLine);
    recyclerView.setAdapter(zhiHuTestAdapter);//出错为null
    zhiHuTestAdapter.notifyDataSetChanged();
    time = newsTimeLine.getDate();
  }

  @Override public void attachView(@NonNull ZhiHuTestContact.ZhiHuTestIView zhiHuTestIView) {
    mZhiHuTestIView = zhiHuTestIView;
  }
}
