package cn.dankal.demo.ExpandableTwo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.dankal.demo.ExpandableTwo.bean.StoryBean;
import cn.dankal.demo.ExpandableTwo.viewHolder.ExpandableTwoViewHolder;
import cn.dankal.demo.R;
import java.util.List;

public class ExpandableTwoAdapter extends RecyclerView.Adapter {

  public List<StoryBean.StoriesBean> mStoriesBeanList;
  public Context mContext;

  public ExpandableTwoAdapter(List<StoryBean.StoriesBean> storiesBeanList, Context context) {
    this.mStoriesBeanList = storiesBeanList;
    this.mContext = context;
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_expandable_two, parent
        , false);
    ExpandableTwoViewHolder holder = new ExpandableTwoViewHolder(view);
    return holder;
  }

  @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ExpandableTwoViewHolder) {
      ((ExpandableTwoViewHolder) holder).mTxtTemporary.setText(
          mStoriesBeanList.get(position).getTitle());
    }
  }

  @Override public int getItemCount() {
    return mStoriesBeanList == null ? 0 : mStoriesBeanList.size();
  }
}
