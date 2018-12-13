package cn.dankal.demo.Expandable.contact;

import cn.dankal.basic_lib.base.BasePresenter;
import cn.dankal.basic_lib.base.BaseView;

public interface ExpandableContact {

  interface ExpandableIView extends BaseView {
    //得到请求的数据
  }

  interface ExpandableIPresenter extends BasePresenter<ExpandableIView> {
    //获取请求的数据
  }
}
