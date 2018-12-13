package cn.dankal.demo.Expandable.presenter;

import cn.dankal.demo.Expandable.HttpModel;
import cn.dankal.demo.Expandable.bean.NewsBean;
import cn.dankal.demo.Expandable.contact.IView;

public class ExpandablePresenter implements HttpModel.OnFinish {

  private final IView iView;
  private final HttpModel httpModel;

  public ExpandablePresenter(IView iView) {
    this.iView = iView;
    this.httpModel = new HttpModel();
    httpModel.setOnFinish(this);
  }

  public void setNews(String url) {
    httpModel.getJson(url);
  }

  @Override
  public void OnFinishListener(NewsBean newsBean) {
    iView.getHttpJson(newsBean);
  }
}
