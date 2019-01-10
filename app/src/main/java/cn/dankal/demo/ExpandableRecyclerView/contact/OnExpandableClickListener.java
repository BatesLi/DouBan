package cn.dankal.demo.ExpandableRecyclerView.contact;

import android.view.View;
import cn.dankal.demo.ExpandableRecyclerView.base.BaseExpandableBean;

public interface OnExpandableClickListener {
  void onExpandableClick(View click, BaseExpandableBean selectBean);
}
