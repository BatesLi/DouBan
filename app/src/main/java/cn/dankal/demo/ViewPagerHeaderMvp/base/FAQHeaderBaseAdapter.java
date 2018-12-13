package cn.dankal.demo.ViewPagerHeaderMvp.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.FAQHelpMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WANG on 17/12/8.
 */

public abstract class FAQHeaderBaseAdapter<T>
    extends RecyclerView.Adapter<FAQHeaderBaseAdapter.FAQBaseViewHolder>
    implements FAQHelpMethod<T> {

  protected List<T> baseData;

  public FAQHeaderBaseAdapter() {
    if (baseData == null) {
      baseData = new ArrayList<>();
    }
  }

  @Override
  public void setRefreshData(List<T> data) {
    baseData.clear();
    baseData.addAll(data);
    notifyDataSetChanged();
  }

  @Override
  public void setLoadMoveData(List<T> data) {
    baseData.addAll(data);
    notifyDataSetChanged();
  }

  @Override
  public void insertDataByPosition(int insertPosition, List<T> dataBean) {
    baseData.addAll(dataBean);
    for (int i = 0; i < dataBean.size(); i++) {
      notifyItemInserted(insertPosition + i);
    }
  }

  @Override
  public void removeDataByPosition(int insertPosition, List<T> dataBean) {
    for (int i = 0; i < dataBean.size(); i++) {
      T dataBean1 = baseData.get(insertPosition);
      if (dataBean1 != null) {
        baseData.remove(insertPosition);
        notifyItemRemoved(insertPosition);
      }
    }
  }

  abstract FAQBaseViewHolder baseOnCreateViewHolder(ViewGroup parent, int viewType);

  abstract void baseOnBindViewHolder(FAQBaseViewHolder holder, int position);

  abstract int baseGetItemCount();

  @Override
  public FAQBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return baseOnCreateViewHolder(parent, viewType);
  }

  @Override
  public void onBindViewHolder(FAQBaseViewHolder holder, int position) {
    baseOnBindViewHolder(holder, position);
  }

  @Override
  public int getItemCount() {
    return baseGetItemCount();
  }

  public static class FAQBaseViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_faq_header_parent;
    public TextView txt_faq_header_child;

    public FAQBaseViewHolder(View itemView, int ViewType) {
      super(itemView);
      if (ViewType == 1) {
        txt_faq_header_child = (TextView) itemView.findViewById(R.id.txt_faq_child);
      } else {
        txt_faq_header_parent = (TextView) itemView.findViewById(R.id.txt_faq_parent);
        txt_faq_header_parent.setText("问题分类");
        txt_faq_header_parent.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            //ToastUtil.toToast("parent布局的点击事件");点击有效
          }
        });
      }
    }
  }
}
