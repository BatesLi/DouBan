package cn.dankal.demo.TestMvp;

import android.support.annotation.NonNull;
import android.widget.TextView;

public class LinkmanPresenter implements LinkmanContact.LinkmanIPresenter {

  public LinkmanContact.LinkmanIView iView;

  @Override public void getData(TextView textView) {
    LinkmanData linkmanData = new LinkmanData();
    linkmanData.setName("Elaine");
    textView.setText(linkmanData.getName());
  }

  @Override public void attachView(@NonNull LinkmanContact.LinkmanIView view) {
    iView = view;
    iView.UpdatePages();
  }
}
