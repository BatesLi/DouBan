package cn.dankal.demo.ZhiHuTest.adapter;

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
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;
import cn.dankal.demo.ZhiHuTest.bean.TestNewsTimeLine;
import com.bumptech.glide.Glide;

public class ZhiHuTestAdapter extends RecyclerView.Adapter<ZhiHuTestAdapter.TestViewHolder> {

  public TestNewsTimeLine mNewsData;
  public Context mContext;

  public ZhiHuTestAdapter(Context context, TestNewsTimeLine newsDat) {
    this.mContext = context;
    this.mNewsData = newsDat;
  }

  @NonNull @Override
  public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item__zhihu
        , parent, false);
    TestViewHolder testViewHolder = new TestViewHolder(view);
    return testViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
    Glide.with(mContext)
        .load(mNewsData.getStories().get(position).getImages().get(0))
        .placeholder(R.mipmap.item3)
        .into(holder.mImgZhiHuDaily);
    holder.mTxtZhiHuTitle.setText(mNewsData.getStories().get(position).getTitle());
  }

  @Override public int getItemCount() {
    return mNewsData.getStories().size();
  }

  public class TestViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_zhihu_title) TextView mTxtZhiHuTitle;
    @BindView(R.id.img_zhihu_daily) ImageView mImgZhiHuDaily;

    public TestViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
