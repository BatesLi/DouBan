package cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import cn.dankal.demo.R;

public class FAQHeaderChildViewHolder extends RecyclerView.ViewHolder {

  public TextView txt_faq_child;

  public FAQHeaderChildViewHolder(View itemView) {
    super(itemView);

    txt_faq_child = (TextView) itemView.findViewById(R.id.txt_faq_child);
  }
}
