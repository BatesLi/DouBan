package cn.dankal.demo.ZhiHuTest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;
import cn.dankal.demo.ZhiHuTest.P.ZhiHuTestPresenter;
import cn.dankal.demo.ZhiHuTest.contact.ZhiHuTestContact;

public class ZhiHuTestActivity extends AppCompatActivity
    implements ZhiHuTestContact.ZhiHuTestIView {

  public LinearLayoutManager linearLayoutManager;
  @BindView(R.id.recycler_zhihu_test) RecyclerView mRecyclerZhiHuTest;
  @BindView(R.id.swipe_test_refresh) SwipeRefreshLayout mSwipeTestRefresh;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zhi_hu_test);
    ButterKnife.bind(this);

    ZhiHuTestPresenter presenter = new ZhiHuTestPresenter(this);
    presenter.getData();
    presenter.attachView(this);
    //setDataRefresh();
  }

  /*@Override public void setDataRefresh() {
    if (mSwipeTestRefresh == null) {
        mSwipeTestRefresh.postDelayed(new Runnable() {
          @Override public void run() {
            if (mSwipeTestRefresh != null) {
                mSwipeTestRefresh.setRefreshing(false);
            }
          }
        },1000);
    }else {
      mSwipeTestRefresh.setRefreshing(false);
    }
  }*/

  @Override public RecyclerView getRecyclerView() {
    return mRecyclerZhiHuTest;
  }

  @Override public LinearLayoutManager getLinearManager() {
    linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerZhiHuTest.setLayoutManager(linearLayoutManager);
    return linearLayoutManager;
  }

  @Override public void success() {
    ToastUtil.toToast("显示数据成功");
  }
}
