package cn.dankal.demo.ZhiHuMvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import cn.dankal.demo.R;
import cn.dankal.demo.ZhiHuMvp.IView.ZhiHuFgIView;
import cn.dankal.demo.ZhiHuMvp.presenter.ZhiHuFgPresenter;

public class ZhiHuFragment extends MvpBaseFragment<ZhiHuFgIView, ZhiHuFgPresenter>
    implements ZhiHuFgIView {

  @BindView(R.id.recycler_zhihu) RecyclerView mRecyclerZhiHu;
  private LinearLayoutManager mLinearLayoutManager;

  @Override protected int createViewLayoutId() {
    return R.layout.fragment_zhihu;
  }

  @Override
  public void initView(View rootView) {
    mLinearLayoutManager = new LinearLayoutManager(getContext());
    mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerZhiHu.setLayoutManager(mLinearLayoutManager);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    setDataRefresh(true);
    mPresenter.getZhiHuListData();
  }

  @Override
  public void requestDataRefresh() {
    super.requestDataRefresh();
    setDataRefresh(true);
    mPresenter.getZhiHuListData();
  }

  @Override public void setDataRefresh(Boolean refresh) {
    setRefresh(refresh);
  }

  @Override public RecyclerView getRecyclerView() {
    return mRecyclerZhiHu;
  }

  @Override public LinearLayoutManager getLinearLayoutManager() {
    return mLinearLayoutManager;
  }

  @Override protected ZhiHuFgPresenter createPresenter() {
    return new ZhiHuFgPresenter(getContext());
  }
}
