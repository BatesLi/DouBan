package cn.dankal.demo.DouBanMvp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.DouBanMvp.adapter.FragmentVpAdapter;
import cn.dankal.demo.DouBanMvp.fragment.FragmentMovie;
import cn.dankal.demo.R;
import java.util.ArrayList;
import java.util.List;

public class DouBanActivity extends AppCompatActivity {

  @BindView(R.id.tab_movie) TabLayout mTabMovie;
  @BindView(R.id.vp_movie) ViewPager mVpMovie;

  private List<String> mListTitles;//tab的页卡数据

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dou_ban);
    ButterKnife.bind(this);

    initTabVpData();
  }

  private void initTabVpData() {
    mListTitles = new ArrayList<>();
    mListTitles.add("爱情");
    mListTitles.add("喜剧");
    mListTitles.add("动画");
    mListTitles.add("科幻");
    mListTitles.add("动作");

    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    fragmentList.add(new FragmentMovie());
    fragmentList.add(new FragmentMovie());
    fragmentList.add(new FragmentMovie());
    fragmentList.add(new FragmentMovie());
    fragmentList.add(new FragmentMovie());

    FragmentVpAdapter myViewPageAdapter = new FragmentVpAdapter(getSupportFragmentManager(),
        this, fragmentList, mListTitles);
    mVpMovie.setAdapter(myViewPageAdapter);
    mTabMovie.setupWithViewPager(mVpMovie);
    mTabMovie.setTabsFromPagerAdapter(myViewPageAdapter);
  }
}
