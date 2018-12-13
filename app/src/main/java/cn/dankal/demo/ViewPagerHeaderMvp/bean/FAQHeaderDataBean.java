package cn.dankal.demo.ViewPagerHeaderMvp.bean;

import java.util.List;

public class FAQHeaderDataBean {

  private String title;
  private boolean isExpandable;
  private boolean haveInsertChild;
  private boolean haveChild;
  private ChildBean childBean;
  private List<FAQHeaderDataBean> headerDataBeans;

  public FAQHeaderDataBean(String title, boolean isExpandable, boolean haveChild,
      boolean haveInsertChild) {
    this.title = title;
    this.isExpandable = isExpandable;
    this.haveChild = haveChild;
    this.haveInsertChild = haveInsertChild;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isExpandable() {
    return isExpandable;
  }

  public void setExpandable(boolean expandable) {
    isExpandable = expandable;
  }

  public boolean isHaveInsertChild() {
    return haveInsertChild;
  }

  public void setHaveInsertChild(boolean haveInsertChild) {
    this.haveInsertChild = haveInsertChild;
  }

  public boolean isHaveChild() {
    return haveChild;
  }

  public void setHaveChild(boolean haveChild) {
    this.haveChild = haveChild;
  }

  public ChildBean getChildBean() {
    return childBean;
  }

  public void setChildBean(ChildBean childBean) {
    this.childBean = childBean;
  }

  public List<FAQHeaderDataBean> getHeaderDataBeans() {
    return headerDataBeans;
  }

  public void setHeaderDataBeans(
      List<FAQHeaderDataBean> headerDataBeans) {
    this.headerDataBeans = headerDataBeans;
  }

  public static class ChildBean {

    private String title;
    private int position;

    public ChildBean(String title, int position) {
      this.title = title;
      this.position = position;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public int getPosition() {
      return position;
    }

    public void setPosition(int position) {
      this.position = position;
    }
  }
}
