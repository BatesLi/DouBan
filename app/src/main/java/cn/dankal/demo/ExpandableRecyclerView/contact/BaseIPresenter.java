package cn.dankal.demo.ExpandableRecyclerView.contact;

import android.support.annotation.NonNull;

public interface BaseIPresenter<T extends BaseIView> {
  void attachView(@NonNull T view);
}
