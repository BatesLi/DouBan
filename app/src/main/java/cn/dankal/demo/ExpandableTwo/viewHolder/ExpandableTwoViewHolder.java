package cn.dankal.demo.ExpandableTwo.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;

public class ExpandableTwoViewHolder extends RecyclerView.ViewHolder {

  public @BindView(R.id.txt_temporary) TextView mTxtTemporary;

  public ExpandableTwoViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
