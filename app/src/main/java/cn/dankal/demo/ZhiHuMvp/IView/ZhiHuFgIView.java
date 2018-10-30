package cn.dankal.demo.ZhiHuMvp.IView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public interface ZhiHuFgIView {
  void setDataRefresh(Boolean refresh);

  RecyclerView getRecyclerView();

  LinearLayoutManager getLinearLayoutManager();
}
