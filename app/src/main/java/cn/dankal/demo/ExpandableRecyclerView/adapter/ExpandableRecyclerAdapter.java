package cn.dankal.demo.ExpandableRecyclerView.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.ExpandableRecyclerView.base.BaseExpandableBean;
import cn.dankal.demo.ExpandableRecyclerView.base.BaseExpandableRecyclerAdapter;
import cn.dankal.demo.ExpandableRecyclerView.bean.TaleGroupBean;
import cn.dankal.demo.R;
import java.util.List;

public class ExpandableRecyclerAdapter extends BaseExpandableRecyclerAdapter<TaleGroupBean> {

  public ExpandableRecyclerAdapter(Context context, List<TaleGroupBean> list) {
    super(context, list);
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    if (viewType == BaseExpandableBean.GROUP) {
      return new ExpandableRecyclerParentViewHolder(
          layoutInflater.inflate(R.layout.item_parent_tale,
              parent, false));
    } else {
      return new ExpandableRecyclerChildViewHolder(layoutInflater.inflate(R.layout.item_child_tale
          , parent, false));
    }
  }

  @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (getItemViewType(position) == BaseExpandableBean.GROUP) {
      ExpandableRecyclerParentViewHolder parentViewHolder =
          (ExpandableRecyclerParentViewHolder) holder;
      parentViewHolder.setData(list, position);
    } else {
      ExpandableRecyclerChildViewHolder childViewHolder =
          (ExpandableRecyclerChildViewHolder) holder;
      childViewHolder.setData(list, position);
    }
  }

  //group的ViewHolder
  public class ExpandableRecyclerParentViewHolder extends BaseExpandableViewHolder<TaleGroupBean> {

    @BindView(R.id.card_tale) CardView mCardTale;
    @BindView(R.id.txt_tale_top_title) TextView mTxtTaleTopTitle;

    public ExpandableRecyclerParentViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      /*mTxtTaleTopTitle.setOnClickListener(this);
      setGroupSelectView(mTxtTaleTopTitle);*/
    }

    @Override
    public void showGroupAndItemBean(TaleGroupBean groupBean,
        BaseExpandableBean baseExpandableBean) {
      mTxtTaleTopTitle.setText("组别:" + groupBean.getGroup());
    }

    @Override public void onClick(View v) {

    }
  }

  //child的list的ViewHolder
  public class ExpandableRecyclerChildViewHolder extends BaseExpandableViewHolder<TaleGroupBean> {

    @BindView(R.id.card_tale_child) CardView mCardTaleChild;
    @BindView(R.id.txt_tale_child_title) TextView mTxtTaleChildTitle;

    public ExpandableRecyclerChildViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override
    public void showGroupAndItemBean(TaleGroupBean groupBean,
        BaseExpandableBean baseExpandableBean) {
      mTxtTaleChildTitle.setText(
          "组别" + groupBean.getGroup() + "成员" + groupBean.getTaleItemBeanList()
              .get(baseExpandableBean.getItemNumber()).getItem());
    }

    @Override public void onClick(View v) {

    }
  }
}
