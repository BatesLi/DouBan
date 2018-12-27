package cn.dankal.demo.ExpandableTwo.contact;

import cn.dankal.basic_lib.base.BasePresenter;
import cn.dankal.basic_lib.base.BaseView;
import cn.dankal.demo.ExpandableTwo.bean.StoryBean;
import java.util.List;

public interface ExpandableTwoContact {

  interface ExpandableTwoIView extends BaseView {
    //得到请求的数据
    void Success(List<StoryBean.StoriesBean> storiesBeanList);
  }

  interface ExpandableTwoIPresenter extends BasePresenter<ExpandableTwoIView> {
    //获取数据
    void RequestData(String url, OnClick onClick);
  }

  interface OnClick {
    void Success(List<StoryBean> storyBeanList);
  }
}
