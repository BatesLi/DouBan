package cn.dankal.demo.Expandable.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.Expandable.bean.NewsBean;
import cn.dankal.demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.List;

public class ExpandableAdapter
    extends XRecyclerView.Adapter<ExpandableAdapter.ExpandableViewHolder> {

  private Context mContext;
  private List<NewsBean.StoriesBean> mData;

  public ExpandableAdapter(Context context, List<NewsBean.StoriesBean> data) {
    this.mContext = context;
    this.mData = data;
  }

  @NonNull @Override
  public ExpandableViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_expandable,
        parent, false);
    ExpandableViewHolder expandableViewHolder = new ExpandableViewHolder(view);
    return expandableViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ExpandableViewHolder holder, int position) {
    // holder.mNewsItemImg.setImageURI(mNewsBean.getStories().get(position).getImages().get(0));
    holder.mNewsItemTitle.setText(mData.get(position).getTitle());
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  public class ExpandableViewHolder extends XRecyclerView.ViewHolder {

    //@BindView(R.id.news_item_img) SimpleDraweeView mNewsItemImg;
    @BindView(R.id.news_item_title) TextView mNewsItemTitle;

    public ExpandableViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
