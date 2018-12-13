package cn.dankal.demo.ViewPagerHeaderMvp.adapter;

import android.support.v7.widget.RecyclerView;

public abstract class ErrorFAQHeaderBaseAdapter<T>
    extends RecyclerView.Adapter {

  /*protected List<T> baseData;

  public FAQHeaderBaseAdapter() {
    if (baseData == null) {
        baseData = new ArrayList<>();
    }
  }
 *//* @Override
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
  public void insertDataByPosition(int insertPosition,List<T> dataBean) {
    baseData.addAll(insertPosition,dataBean);
    for (int i = 0;i < dataBean.size();i++) {
        notifyItemInserted(insertPosition + i);
    }
  }
  @Override
  public void removeDataByPosition(int insertPosition,List<T> dataBean) {
    for (int i = 0;i < dataBean.size();i++) {
      T dataBean1 = baseData.get(insertPosition);
      if (dataBean1 != null) {
          baseData.remove(insertPosition);
          notifyItemInserted(insertPosition);
          }
      }
    }*//*

  public abstract FAQBaseViewHolder baseOnCreateViewHolder(ViewGroup parent,int type);
  public abstract void  baseOnBindViewHolder(FAQBaseViewHolder holder,int position);
  public abstract int baseGetItemCount();

  @Override
  public FAQBaseViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
    return baseOnCreateViewHolder(parent,viewType);
  }
  @Override
  public void onBindViewHolder(@NonNull FAQBaseViewHolder holder,
      int position) {
      baseOnBindViewHolder(holder,position);
  }

  @Override
  public int getItemCount() {
    return baseGetItemCount();
  }

  public class FAQBaseViewHolder extends RecyclerView.ViewHolder{

    public TextView txt_faq_header_parent;
    public TextView txt_faq_header_child;

    public FAQBaseViewHolder(View itemView,int ViewType) {
      super(itemView);
      if (ViewType == 1) {
          txt_faq_header_child = (TextView)itemView.findViewById(R.id.txt_faq_child);
      }else {
          txt_faq_header_parent = (TextView)itemView.findViewById(R.id.txt_faq_parent);
          }
      }
    }*/
}
