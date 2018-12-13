package cn.dankal.demo.ZhiHuMvp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;
import cn.dankal.demo.ViewPagerHeaderMvp.fragment.LoginFragment;
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
    baseFragmentList.add(new LoginFragment());
    baseFragmentList.add(new LoginFragment());
    mVpZhiHu.setOffscreenPageLimit(3);
    mVpZhiHu.setAdapter(
        new ViewPagerAdapterZhiHu(getSupportFragmentManager(), this, baseFragmentList));
    mTabZhiHu.setupWithViewPager(mVpZhiHu);
  }
}
