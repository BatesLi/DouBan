package cn.dankal.demo.ZhiHuMvp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class ViewPagerAdapterZhiHu extends FragmentPagerAdapter {

  public Context mCntext;
  private List<Fragment> mFragmentList;

  public ViewPagerAdapterZhiHu(FragmentManager fm, Context context, List<Fragment> fragmentList) {
    super(fm);
    this.mCntext = context;
    this.mFragmentList = fragmentList;
  }

  @Override public Fragment getItem(int position) {
    return mFragmentList.get(position);
  }

  @Override public int getCount() {
    return mFragmentList.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "知乎";
      case 1:
        return "干货";
      case 2:
        return "满足你的好奇心";
    }
    return null;
  }
}
