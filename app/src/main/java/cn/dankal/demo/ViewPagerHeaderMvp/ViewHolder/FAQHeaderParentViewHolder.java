package cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.dankal.demo.R;

public class FAQHeaderParentViewHolder extends RecyclerView.ViewHolder {

  public TextView txt_faq_parent;
  public ImageView img_arrow_down;

  public FAQHeaderParentViewHolder(View itemView) {
    super(itemView);
    txt_faq_parent = (TextView) itemView.findViewById(R.id.txt_faq_parent);
    img_arrow_down = (ImageView) itemView.findViewById(R.id.img_arrow_down);
  }
}
