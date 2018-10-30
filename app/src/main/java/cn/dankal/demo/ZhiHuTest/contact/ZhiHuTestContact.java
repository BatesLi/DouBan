package cn.dankal.demo.ZhiHuTest.contact;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public interface ZhiHuTestContact {

  interface ZhiHuTestIView extends ZhiHuTestBaseView {
    RecyclerView getRecyclerView();

    LinearLayoutManager getLinearManager();
  }

  interface ZhiHuTestIPrsenter extends ZhiHuTestBasePresenter<ZhiHuTestContact.ZhiHuTestIView> {
    void getData();
  }
}
