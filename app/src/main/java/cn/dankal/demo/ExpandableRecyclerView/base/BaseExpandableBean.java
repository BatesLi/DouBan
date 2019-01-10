package cn.dankal.demo.ExpandableRecyclerView.base;

public class BaseExpandableBean {
  //组别
  public static final int GROUP = 1;
  //组内成员
  public static final int FIRST_ITEM = 2;
  //是组还是成员
  private int type;
  //属于什么组
  private int groupPosition;
  //点击位置的item在改组中的位置
  private int itemNumber;
  //判断expandable是展开还是关闭
  private boolean status;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getGroupPosition() {
    return groupPosition;
  }

  public void setGroupPosition(int groupPosition) {
    this.groupPosition = groupPosition;
  }

  public int getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(int itemNumber) {
    this.itemNumber = itemNumber;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
