package cn.dankal.demo.ViewPagerHeaderMvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.ExpandableContact.ExpandableContact;
import cn.dankal.demo.ViewPagerHeaderMvp.adapter.NewsStoryAdapter;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.NewsBean;
import cn.dankal.demo.ViewPagerHeaderMvp.presenter.NewsPresenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment
    implements ExpandableContact.ExpandableIView,SwipeRefreshLayout.OnRefreshListener {

  public NewsStoryAdapter mViewAdapterHeaderAdapter;

  @BindView(R.id.Recycler_fragment_inquisitive) RecyclerView mRecyclerFragmentInquisitive;
  @BindView(R.id.refresh_inquisitive) SwipeRefreshLayout mRefreshInquisitive;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container
      , Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_news, container, false);
    ButterKnife.bind(this, view);
    mRefreshInquisitive.setOnRefreshListener(this);
    mRecyclerFragmentInquisitive.setLayoutManager(new LinearLayoutManager(getContext()));
    NewsPresenter presenter = new NewsPresenter();
    presenter.attachView(this);
    presenter.requestExpandableJso();
    return view;
  }

  @Override public void onRefresh() {
    ToastUtil.toToast("更新完成");
    mRefreshInquisitive.setRefreshing(false);
  }

  @Override public void getExpandableData(List<NewsBean.StoriesBean> storiesBeanList) {
    mViewAdapterHeaderAdapter = new NewsStoryAdapter(getContext(), storiesBeanList);
    mRecyclerFragmentInquisitive.setAdapter(mViewAdapterHeaderAdapter);
  }

  @Override public void showLoadingDialog() {

  }

  @Override public void dismissLoadingDialog() {

  }

  @Override public void showToast(String message) {

  }

  @Override public void tokenInvalid() {

  }

  @Override public void addNetworkRequest(Disposable d) {

  }
}















