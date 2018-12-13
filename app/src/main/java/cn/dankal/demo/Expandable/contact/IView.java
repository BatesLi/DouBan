package cn.dankal.demo.Expandable.contact;

import cn.dankal.demo.Expandable.bean.NewsBean;

public interface IView {
  //得到请求的数据
  void getHttpJson(NewsBean newsBean);
}
