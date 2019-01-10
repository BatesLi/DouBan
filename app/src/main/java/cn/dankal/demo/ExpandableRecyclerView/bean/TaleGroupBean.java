package cn.dankal.demo.ExpandableRecyclerView.bean;

import java.util.List;

public class TaleGroupBean {

  private List<TaleItemBean> taleItemBeanList;
  private int group;

  public List<TaleItemBean> getTaleItemBeanList() {
    return taleItemBeanList;
  }

  public void setTaleItemBeanList(
      List<TaleItemBean> taleItemBeanList) {
    this.taleItemBeanList = taleItemBeanList;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public static class TaleItemBean {

    int item;

    public int getItem() {
      return item;
    }

    public void setItem(int item) {
      this.item = item;
    }
  }
}
