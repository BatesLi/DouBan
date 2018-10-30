package cn.dankal.demo.ZhiHuMvp.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.ZhiHuMvp.IView.ZhiHuFgIView;
import cn.dankal.demo.ZhiHuMvp.adapter.RvZhiHuAdapter;
import cn.dankal.demo.ZhiHuMvp.api.ApiService;
import cn.dankal.demo.ZhiHuMvp.bean.NewsTimeLine;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ZhiHuFgPresenter extends BasePresenter<ZhiHuFgIView> {

  public RecyclerView recyclerView;
  public LinearLayoutManager linearLayoutManager;
  public RvZhiHuAdapter rvZhiHuAdapter;
  public NewsTimeLine timeLine;
  public Context mContext;
  String time;
  private boolean isLoadMore = false; // 是否加载过更多
  private ZhiHuFgIView zhiHuFgIView;

  public ZhiHuFgPresenter(Context context) {
    this.mContext = context;
  }

  public void getZhiHuListData() {
    zhiHuFgIView = getView();
    if (zhiHuFgIView != null) {
      recyclerView = zhiHuFgIView.getRecyclerView();
      linearLayoutManager = zhiHuFgIView.getLinearLayoutManager();
    }
    ApiService.getZhiuApiSingleton().getLatestNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(newsTimeLine -> {
          disPlayZhiHuList(newsTimeLine, mContext
              , zhiHuFgIView, recyclerView);
        }, this::loadError);
  }

  private void loadError(Throwable throwable) {
    throwable.printStackTrace();
    ToastUtil.toToast("没有网络");
  }

  private void disPlayZhiHuList(NewsTimeLine newsTimeLine, Context context,
      ZhiHuFgIView zhiHuFgIView
      , RecyclerView recyclerView) {
    if (isLoadMore) {
      if (time == null) {
        ToastUtil.toToast("数据为null");
        zhiHuFgIView.setDataRefresh(false);
        return;
      } else {
        newsTimeLine.getStories().addAll(newsTimeLine.getStories());
      }
      rvZhiHuAdapter.notifyDataSetChanged();
    } else {
      timeLine = newsTimeLine;
      rvZhiHuAdapter = new RvZhiHuAdapter(context, timeLine);
      recyclerView.setAdapter(rvZhiHuAdapter);
      rvZhiHuAdapter.notifyDataSetChanged();
    }
    zhiHuFgIView.setDataRefresh(false);
    time = newsTimeLine.getDate();
  }
}
