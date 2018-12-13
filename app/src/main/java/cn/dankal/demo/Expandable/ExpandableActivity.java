package cn.dankal.demo.Expandable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.Expandable.adapter.ExpandableAdapter;
import cn.dankal.demo.Expandable.api.Api;
import cn.dankal.demo.Expandable.bean.NewsBean;
import cn.dankal.demo.Expandable.contact.IView;
import cn.dankal.demo.Expandable.presenter.ExpandablePresenter;
import cn.dankal.demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class ExpandableActivity extends AppCompatActivity implements IView {

  @BindView(R.id.toolbar_faq) Toolbar mToolbarFaq;
  @BindView(R.id.x_recycler_expandable) XRecyclerView mXRecyclerExpandable;

  public ExpandableAdapter expandableAdapter;
  public ExpandablePresenter expandablePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandable);
    ButterKnife.bind(this);

    mToolbarFaq.setNavigationIcon(R.drawable.arrow_left);
    mToolbarFaq.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ToastUtil.toToast("回退按钮");
      }
    });

    mXRecyclerExpandable.setLayoutManager(new LinearLayoutManager(this));
    expandablePresenter = new ExpandablePresenter(this);
    expandablePresenter.setNews(Api.API_URL);
  }

  @Override
  public void getHttpJson(NewsBean newsBean) {
    expandableAdapter = new ExpandableAdapter(this, newsBean.getStories());
    mXRecyclerExpandable.setAdapter(expandableAdapter);
  }
}
