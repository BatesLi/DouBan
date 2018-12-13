package cn.dankal.demo.TestMvp;

import android.support.annotation.NonNull;

public interface BaseLinkmanIPresenter<T extends BaseLinkmanIView> {
  void attachView(@NonNull T view);
}
