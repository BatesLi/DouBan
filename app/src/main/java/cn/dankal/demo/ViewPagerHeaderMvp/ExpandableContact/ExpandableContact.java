package cn.dankal.demo.ViewPagerHeaderMvp.ExpandableContact;

import cn.dankal.basic_lib.base.BasePresenter;
import cn.dankal.basic_lib.base.BaseView;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.NewsBean;
import java.util.List;

public interface ExpandableContact {

  interface ExpandableIView extends BaseView{
    void getExpandableData(List<NewsBean.StoriesBean> storiesBeanList);
  }
  interface ExpandableIPresenter extends BasePresenter<ExpandableIView> {
    void requestExpandableJso();
  }
}
