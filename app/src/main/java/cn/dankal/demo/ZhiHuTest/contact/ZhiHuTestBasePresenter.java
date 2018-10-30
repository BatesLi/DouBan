package cn.dankal.demo.ZhiHuTest.contact;

import android.support.annotation.NonNull;

public interface ZhiHuTestBasePresenter<V extends ZhiHuTestBaseView> {
  void attachView(@NonNull V View);
}
