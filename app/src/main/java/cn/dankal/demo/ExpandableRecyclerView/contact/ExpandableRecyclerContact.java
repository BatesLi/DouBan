package cn.dankal.demo.ExpandableRecyclerView.contact;

import cn.dankal.demo.ExpandableRecyclerView.bean.Tale;

public interface ExpandableRecyclerContact {

  interface ExpandableRecyclerIView extends BaseIView {
    void getExpandableRecyclerData(Tale tale);
  }

  interface ExpandableRecyclerIPresenter extends BaseIPresenter<ExpandableRecyclerIView> {
    void addNetworkRequest();
  }
}
