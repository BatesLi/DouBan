package cn.dankal.demo.TestMvp;

import android.widget.TextView;

public interface LinkmanContact {

  interface LinkmanIView extends BaseLinkmanIView {
    void Test();
  }

  interface LinkmanIPresenter extends BaseLinkmanIPresenter<LinkmanIView> {
    void getData(TextView textView);
  }
}
