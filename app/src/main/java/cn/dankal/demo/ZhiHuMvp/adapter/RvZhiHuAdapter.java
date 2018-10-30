package cn.dankal.demo.ZhiHuMvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;
import cn.dankal.demo.ZhiHuMvp.bean.NewsTimeLine;
import com.bumptech.glide.Glide;
import java.util.List;

public class RvZhiHuAdapter extends RecyclerView.Adapter<RvZhiHuAdapter.MovieHolder> {

  public NewsTimeLine mNewsTimeLine;
  public Context mContext;

  public RvZhiHuAdapter(Context context, NewsTimeLine newsTimeLine) {
    this.mContext = context;
    this.mNewsTimeLine = newsTimeLine;
  }

  @NonNull @Override
  public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item__zhihu
        , parent, false);
    MovieHolder movieHolder = new MovieHolder(view);
    return movieHolder;
  }

  @Override public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

    Glide.with(mContext)
        .load(mNewsTimeLine.getStories().get(position).getImages().get(0))
        .placeholder(R.mipmap.item3)
        .into(holder.mImgZhiHuDaily);
    holder.mTxtZhiHuTitle.setText(mNewsTimeLine.getStories().get(position).getTitle());
  }

  @Override public int getItemCount() {
    return mNewsTimeLine.getStories().size();
  }

  public class MovieHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_zhihu_title) TextView mTxtZhiHuTitle;
    @BindView(R.id.img_zhihu_daily) ImageView mImgZhiHuDaily;

    public MovieHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

