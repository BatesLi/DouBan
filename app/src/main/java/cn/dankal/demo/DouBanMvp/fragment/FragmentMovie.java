package cn.dankal.demo.DouBanMvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.DouBanMvp.adapter.RvMovieAdapter;
import cn.dankal.demo.R;
import java.util.ArrayList;
import java.util.List;

public class FragmentMovie extends Fragment {

  public List<Integer> mData;
  public RvMovieAdapter rvMovieAdapter;
  @BindView(R.id.recycler_movie) RecyclerView mRecyclerMovie;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie, container, false);
    ButterKnife.bind(this, view);
    initData();
    initView();
    return view;
  }

  private void initData() {
    mData = new ArrayList<>();
    for (int i = 0; i < 21; i++) {
      mData.add(i);
    }
    rvMovieAdapter = new RvMovieAdapter(getContext(), mData);
    mRecyclerMovie.setAdapter(rvMovieAdapter);
  }

  private void initView() {
    GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerMovie.setLayoutManager(layoutManager);
  }
}
