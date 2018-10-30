package cn.dankal.demo.DouBanMvp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class FragmentVpAdapter extends FragmentStatePagerAdapter {

  public Context mContext;
  public List<Fragment> mFragment;
  public List<String> mTitles;

  public FragmentVpAdapter(FragmentManager fm,
      Context context, List<Fragment> fragment, List<String> titles) {
    super(fm);
    this.mContext = context;
    this.mTitles = titles;
    this.mFragment = fragment;
  }

  @Override
  public int getCount() {
    return mFragment.size();
  }

  @Override public Fragment getItem(int position) {
    return mFragment.get(position);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mTitles.get(position);
  }
}
