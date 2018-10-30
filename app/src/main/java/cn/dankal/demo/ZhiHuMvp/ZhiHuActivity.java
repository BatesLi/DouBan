package cn.dankal.demo.ZhiHuMvp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.adapter.ViewPagerFgAdapter;
import cn.dankal.demo.ViewPagerHeaderMvp.fragment.BlankFragment;
import cn.dankal.demo.ViewPagerHeaderMvp.fragment.InquisitiveFragment;
import cn.dankal.demo.ZhiHuMvp.adapter.ViewPagerAdapterZhiHu;
import cn.dankal.demo.ZhiHuMvp.fragment.ZhiHuFragment;
import java.util.ArrayList;
import java.util.List;

public class ZhiHuActivity extends AppCompatActivity {

  @BindView(R.id.tab_zhihu) TabLayout mTabZhiHu;
  @BindView(R.id.vp_zhihu) ViewPager mVpZhiHu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zhi_hu);
    ButterKnife.bind(this);
    initTabView();
  }

  private void initTabView() {
    List<Fragment> baseFragmentList = new ArrayList<>();
    baseFragmentList.add(new ZhiHuFragment());
    baseFragmentList.add(new BlankFragment());
    baseFragmentList.add(new BlankFragment());
    mVpZhiHu.setOffscreenPageLimit(3);
    mVpZhiHu.setAdapter(
        new ViewPagerAdapterZhiHu(getSupportFragmentManager(), this, baseFragmentList));
    mTabZhiHu.setupWithViewPager(mVpZhiHu);
  }
}
