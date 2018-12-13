package cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import cn.dankal.demo.R;

public class FAQViewHolder extends RecyclerView.ViewHolder {
  //节省资源提高运行效率，一般自定义类 ViewHolder
  // 来减少 findViewById() 的使用以及避免过多地 inflate view，从而实现目标。
  public RecyclerView mRecyclerFaq;

  public FAQViewHolder(View itemView) {
    super(itemView);
    mRecyclerFaq = (RecyclerView) itemView.findViewById(R.id.recycler_faq);
    //以为recycler的Manager只能在 view层面来进行初始化
    // 在这里进行初始化会导致 LinearLayoutManager为空
    /*LinearLayoutManager gridManager = new LinearLayoutManager(itemView.getContext());
    gridManager.setOrientation(LinearLayoutManager.VERTICAL);
    gridManager.setAutoMeasureEnabled(true);*/
  }
}
