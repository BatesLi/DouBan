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
import cn.dankal.demo.ViewPagerHeaderMvp.adapter.ViewAdapterHeaderAdapter;
import java.util.ArrayList;
import java.util.List;

public class InquisitiveFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

  public List<Integer> mData;
  public ViewAdapterHeaderAdapter mViewAdapterHeaderAdapter;
  public LinearLayoutManager mLinearLayoutManager;
  @BindView(R.id.Recycler_fragment_inquisitive) RecyclerView mRecyclerFragmentInquisitive;
  @BindView(R.id.refresh_inquisitive) SwipeRefreshLayout mRefreshInquisitive;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container
      , Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_inquisitive, container, false);
    ButterKnife.bind(this, view);
    mRefreshInquisitive.setOnRefreshListener(this);
    initData();
    initView();
    return view;
  }

  private void initData() {
    mData = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      mData.add(i);
    }
  }

  private void initView() {
    mViewAdapterHeaderAdapter = new ViewAdapterHeaderAdapter(getContext(), mData);
    mLinearLayoutManager = new LinearLayoutManager(getContext());
    mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerFragmentInquisitive.setLayoutManager(mLinearLayoutManager);
    mRecyclerFragmentInquisitive.setAdapter(mViewAdapterHeaderAdapter);
  }

  @Override public void onRefresh() {
    ToastUtil.toToast("更新完成");
    mRefreshInquisitive.setRefreshing(false);
  }
}















