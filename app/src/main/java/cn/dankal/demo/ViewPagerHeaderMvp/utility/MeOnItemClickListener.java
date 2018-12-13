package cn.dankal.demo.ViewPagerHeaderMvp.utility;

import android.view.View;
import cn.dankal.demo.ViewPagerHeaderMvp.bean.FAQHeaderDataBean;

/**
 * Created by WANG on 17/12/5.
 */

public interface MeOnItemClickListener {
  /**
   *
   * @param v
   * @param position
   * @param dataBean
   */
  void onParentItemClick(View v, int position, FAQHeaderDataBean dataBean);

  /**
   *
   * @param v
   * @param position
   * @param dataBean
   */
  void onChildItemClick(View v, int position, FAQHeaderDataBean dataBean);
}
