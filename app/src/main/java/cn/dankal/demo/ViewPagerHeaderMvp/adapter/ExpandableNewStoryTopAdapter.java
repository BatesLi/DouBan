package cn.dankal.demo.ViewPagerHeaderMvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder.FAQHeaderChildViewHolder;
import cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder.FAQHeaderParentViewHolder;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.DataListTree;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.ItemStatus;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.NewsBean;
import java.util.ArrayList;
import java.util.List;

public class ExpandableNewStoryTopAdapter extends RecyclerView.Adapter{

  private Context mContext;
  private List<DataListTree<String,NewsBean.TopStoriesBean>> mDataListTree;
  private List<Boolean> mGroupItemStatus;//保存一级标题的开关状态
 // public int isExpandable = 0;
  public boolean isExpandable = true;

  public ExpandableNewStoryTopAdapter(Context context
      ,List<DataListTree<String,NewsBean.TopStoriesBean>> dataListTree) {
    this.mContext = context;
    this.mDataListTree = dataListTree;
  }

  //设置显示的数据
  public void setData(List<DataListTree<String, NewsBean.TopStoriesBean>> dataListTrees) {
    this.mDataListTree = dataListTrees;
    initGroupItemStatus();
    notifyDataSetChanged();
  }
  //初始化一级列表开关状态
  //如果List集合对象由于调用add方法而发生更改,则返回 true;否则返回false。
  private void initGroupItemStatus() {
    mGroupItemStatus = new ArrayList<>();
    for (int i = 0; i < mDataListTree.size(); i++) {
      mGroupItemStatus.add(false);
    }
  }
  /*
  * 思路：根据方法参数position指定的列表项，分别获取列表项所对应的组索引、子项索引（如果是二级标题的话）以及列表项类型，
  * 即返回一个之前定义的ItemStatus类型实例
  *
  * 解释：根据item的位置，获取当前Item的状态
          position 当前item的位置（此position的计数包含groupItem和subItem合计）
          当前Item的状态（此Item可能是groupItem，也可能是SubItem）
  *
  * */
  private ItemStatus getItemStatusByPosition(int position) {
    ItemStatus itemStatus = new ItemStatus();
    int itemCount = 0;
    int i ;

    //轮询 groupItem 的开关状态
    /*break用于完全结束一个循环，跳出循环体执行循环后面的语句。
    continue只是终止本次循环，接着还执行后面的循环，break则完全终止循环。*/
    for (i = 0;i < mGroupItemStatus.size(); i++) {
      if (itemCount == position) { //当position等于计数的时候，item为GroupItem.
        itemStatus.setmViewType(ItemStatus.VIEW_TYPE_GROUP_ITEM);
        itemStatus.setmGroupItemIndex(i);
        break;
      }else if (itemCount > position) {
        itemStatus.setmViewType(ItemStatus.VIEW_TYPE_SUB_ITEM);
        itemStatus.setmGroupItemIndex(i - 1);// 指定的position组索引
        //计算指定的position前，统计的列表项和
        int temp = (itemCount - mDataListTree.get(i - 1).getmSubItem().size());
        itemStatus.setmSubItemIndex(position - temp);
        break;
      }

      itemCount++;
      if (mGroupItemStatus.get(i)) {
        itemCount += mDataListTree.get(i).getmSubItem().size();
      }
      // 轮询到最后一组时，未找到对应位置
      if (i >= mGroupItemStatus.size()) {
        itemStatus.setmViewType(ItemStatus.VIEW_TYPE_SUB_ITEM); //设置为二级标签
        itemStatus.setmGroupItemIndex(i - 1);// 设置一级标签为最后一组
        itemStatus.setmSubItemIndex(position - (itemCount -
            mDataListTree.get(i - 1).getmSubItem().size()));
      }
    }
    return itemStatus;
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view;
    RecyclerView.ViewHolder viewHolder = null;
    if (viewType == ItemStatus.VIEW_TYPE_GROUP_ITEM) {
      //parent需要传入对应的位置，否则触动不了点击事件
        view = LayoutInflater.from(mContext).inflate(R.layout.item_faq_header_parent
            ,parent,false);
        viewHolder = new FAQHeaderParentViewHolder(view);
    }else if (viewType == ItemStatus.VIEW_TYPE_SUB_ITEM) {
      view = LayoutInflater.from(mContext).inflate(R.layout.item_faq_header_child
          ,parent,false);
      viewHolder = new FAQHeaderChildViewHolder(view);
    }
    return viewHolder;
  }
  /*
  *  onBindViewHolder绑定ViewHolder，显示列表项内容
方法中需要分别处理组以及子项列表，对于组列表还需要判断是打开还是关闭组列表。
另外对于组的处理方式中，代码中做了两种处理：1. 可打开多组一级列表的功能； 2. 只保证有一组列表处于打开的状态。
  * */
  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    //String 继承于CharSequence，也就是说String也是CharSequence类型。
    ItemStatus itemStatus = getItemStatusByPosition(position);//获取列表项状态
    final DataListTree data = mDataListTree.get(itemStatus.getmGroupItemIndex());

    if (itemStatus.getmViewType() == ItemStatus.VIEW_TYPE_GROUP_ITEM) {
        FAQHeaderParentViewHolder faqHeaderParentViewHolder = (FAQHeaderParentViewHolder)holder;
        ((FAQHeaderParentViewHolder) holder).txt_faq_parent.setText((CharSequence)data.getmGroupItem());
        int groupIndex = itemStatus.getmGroupItemIndex(); // 组索引
      ((FAQHeaderParentViewHolder) holder).img_arrow_down
          .setBackground(mContext.getResources().getDrawable(R.drawable.arrow_down));

      initGroupItemStatus();//默认展开一个组的功能
      mGroupItemStatus.set(groupIndex,true);

        faqHeaderParentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            if (mGroupItemStatus.get(groupIndex)) { //一级标题关闭状态
                mGroupItemStatus.set(groupIndex,false);
                notifyItemRangeRemoved(faqHeaderParentViewHolder
                    .getAdapterPosition() + 1,data.getmSubItem().size());
            }else { //一级标题打开状态
                initGroupItemStatus();//展开一个组的功能
                mGroupItemStatus.set(groupIndex,true);
                notifyDataSetChanged();
            }

          }
        });
    } else if (itemStatus.getmViewType() == ItemStatus.VIEW_TYPE_SUB_ITEM) {
      FAQHeaderChildViewHolder faqHeaderChildViewHolder = (FAQHeaderChildViewHolder) holder;
      faqHeaderChildViewHolder.txt_faq_child.setText((CharSequence)data.getmSubItem()
          .get(itemStatus.getmSubItemIndex()));
      //faqHeaderChildViewHolder.txt_faq_child.setText();
    }
  }
  public boolean setIsExpandable(boolean isExpandable) {
    return isExpandable;
  }
  /*
  * getItemCount获取当前显示的列表项数目
  * 返回的结果中，包含当前已经展开的的二级列表数目
  * */
  @Override
  public int getItemCount() {
   //return mDataListTree.size();
    int itemCount = 0;
    if (0 == mGroupItemStatus.size()) {
        return itemCount;
    }
    for (int i = 0;i < mDataListTree.size();i++) {
         itemCount++;
         if (mGroupItemStatus.get(i)) { // 二级标题展开时，再加上二级标题的数量
           itemCount += mDataListTree.get(i).getmSubItem().size();
         }
    }
    return itemCount;
  }
  /*
  * getItemViewType获取指定position的列表项类型
由于之前定义的方法getItemStatusByPosition与当前方法的参数相同，
且返回了一个标识列表项状态的对象实例，所以getItemViewType这个方法就可以这样实现
  * */
  @Override
  public int getItemViewType(int position) {
    return getItemStatusByPosition(position).getmViewType();
  }
}
