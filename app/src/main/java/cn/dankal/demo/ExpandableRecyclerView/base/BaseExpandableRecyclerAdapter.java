package cn.dankal.demo.ExpandableRecyclerView.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import cn.dankal.demo.ExpandableRecyclerView.contact.OnExpandableClickListener;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseExpandableRecyclerAdapter<A> extends BaseRecyclerAdapter {
  //对调接口
  public OnExpandableClickListener onExpandableClickListener;

  public void setOnExpandableClickListener(
      OnExpandableClickListener onExpandableClickListener) {
    this.onExpandableClickListener = onExpandableClickListener;
  }

  //对应所有的item都保存在该类中，保存所有数据
  protected List<BaseExpandableBean> saveListBean;
  //显示的数据，点击后增删改都在这个list处理
  protected List<BaseExpandableBean> changeListBean;

  public List<BaseExpandableBean> getChangeListBean() {
    return changeListBean;
  }

  /*是类就有构造方法，如果自己没有定义，
  那么系统会给一个无参的构造方法，要是定义了会把参数传给 继承子类的构造方法.*/
  public BaseExpandableRecyclerAdapter(Context context, List<A> list) {
    super(context, list);
    saveListBean = new LinkedList<>();
    changeListBean = new LinkedList<>();
  }

  //封装一个ViewHolder
  public abstract class BaseExpandableViewHolder<T> extends RecyclerView.ViewHolder
      implements View.OnClickListener {

    protected List<T> data;
    protected int position;
    protected BaseExpandableBean expandableBean;
    //protected List<BaseExpandableBean> changeListBean;

    public BaseExpandableViewHolder(View itemView) {
      super(itemView);
    }

    public void setData(List<T> data, int position) {
      this.data = data;
      this.position = position;
      expandableBean = changeListBean.get(position);
    }

    //这个方法里面执行数据操作
    public abstract void showGroupAndItemBean(T groupBean, BaseExpandableBean baseExpandableBean);

    //需要改变group的View，可能是箭头符号
    private View groupSelectView;

    //设置该View
    public void setGroupSelectView(View groupSelectView) {
      this.groupSelectView = groupSelectView;
    }
    /*
    点击事件调用，这是增删的关键
    * */
  }

  @Override
  public int getItemCount() {
    return changeListBean.size();
  }

  @Override
  public int getItemViewType(int position) {
    if (changeListBean.get(position).getType() == BaseExpandableBean.GROUP) {
      return BaseExpandableBean.GROUP;
    } else {
      return BaseExpandableBean.FIRST_ITEM;
    }
  }

  private void changeData(boolean check, int groupPosition) {
    if (check) {
      for (BaseExpandableBean score : saveListBean) {
        if (score.getGroupPosition() == groupPosition &&
            score.getType() == BaseExpandableBean.FIRST_ITEM) {
          changeListBean.remove(score);
        }
      }
    } else {
      for (int i = 0; i < changeListBean.size(); i++) {
        BaseExpandableBean score = changeListBean.get(i);
        if (score.getGroupPosition() == groupPosition) {
          for (BaseExpandableBean scoreTemp : saveListBean) {
            if (scoreTemp.getGroupPosition() == groupPosition &&
                scoreTemp.getType() == BaseExpandableBean.FIRST_ITEM) {
              i++;
              changeListBean.add(i, scoreTemp);
            }
          }
          break;
        }
      }
    }
    this.notifyDataSetChanged();
  }

  /*
   * 添加分组和各分组的item显示
   * */
  private int groupPosition = 0;

  public void addGroupAndItem(int itemSize) {
    BaseExpandableBean group = new BaseExpandableBean();
    group.setType(BaseExpandableBean.GROUP);
    group.setGroupPosition(groupPosition);
    changeListBean.add(group);
    saveListBean.add(group);

    for (int j = 0; j < itemSize; j++) {
      BaseExpandableBean item = new BaseExpandableBean();
      item.setType(BaseExpandableBean.FIRST_ITEM);
      item.setGroupPosition(groupPosition);
      item.setItemNumber(j);//点击位置的item在改组中的位置
      changeListBean.add(item);
      saveListBean.add(item);
    }
    groupPosition++;
  }
}
