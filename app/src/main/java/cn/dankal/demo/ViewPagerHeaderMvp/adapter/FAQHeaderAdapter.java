package cn.dankal.demo.ViewPagerHeaderMvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder.FAQHeaderChildViewHolder;
import cn.dankal.demo.ViewPagerHeaderMvp.ViewHolder.FAQHeaderParentViewHolder;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.FAQData;
import java.util.List;

public class FAQHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  public Context mContext;
  public List<FAQData> mFaqData;
  public LayoutInflater mLayoutInflater;
  public int mFAQHeaderView = 0;
  public int mFAQHeaderChildView = 1;

  private static final int ITEM_TYPE_FAQ_HEADER_PARENT = 0;
  private static final int ITEM_TYPE_FAQ_HEADER_CHILD = 1;

  public FAQHeaderAdapter(Context context, List<FAQData> faqData) {
    this.mContext = context;
    this.mFaqData = faqData;
    mLayoutInflater = LayoutInflater.from(context);
  }

  @Override
  public int getItemViewType(int position) {
    /*return mFaqData.size() != 0 &&
        mFaqData.get(position).getAge() % 2 == 0 ? ITEM_TYPE_FAQ_HEADER_PARENT : ITEM_TYPE_FAQ_HEADER_CHILD;*/
    FAQData faqData = getItem(position);
    return mFaqData.size() != 0 &&
        faqData.getAge() % 2 == 0 ? ITEM_TYPE_FAQ_HEADER_PARENT : ITEM_TYPE_FAQ_HEADER_CHILD;
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    if (viewType == ITEM_TYPE_FAQ_HEADER_PARENT) {
      return new FAQHeaderParentViewHolder(mLayoutInflater.inflate(R.layout.item_faq_header_parent
          , parent, false));
    } else if (viewType == ITEM_TYPE_FAQ_HEADER_CHILD) {
      return new FAQHeaderChildViewHolder(mLayoutInflater.inflate(R.layout.item_faq_header_child
          , parent, false));
    }
    return null;
  }

  @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof FAQHeaderParentViewHolder) {
      ((FAQHeaderParentViewHolder) holder).txt_faq_parent.setText(
          mFaqData.get(position).getTitle());
    }
  }

  @Override public int getItemCount() {
    return mFaqData == null ? 0 : mFaqData.size();
  }

  public FAQData getItem(int position) {
    return position >= 0 && position < getItemCount() ? mFaqData.get(position) : null;
  }
}
