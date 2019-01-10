package cn.dankal.demo.ExpandableRecyclerView.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import cn.dankal.demo.ExpandableRecyclerView.contact.OnRecyclerItemClickListener;
import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

  protected LayoutInflater layoutInflater;
  protected List<T> list;
  protected OnRecyclerItemClickListener onRecyclerItemClickListener;

  public void setOnRecyclerItemClickListener(
      OnRecyclerItemClickListener onRecyclerItemClickListener) {
    this.onRecyclerItemClickListener = onRecyclerItemClickListener;
  }

  public BaseRecyclerAdapter(Context context, List<T> list) {
    layoutInflater = LayoutInflater.from(context);
    this.list = list;
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public List<T> getList() {
    return list;
  }

  @Override
  public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }
}
