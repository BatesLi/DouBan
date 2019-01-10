package cn.dankal.demo.ExpandableRecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.ExpandableRecyclerView.adapter.ExpandableRecyclerAdapter;
import cn.dankal.demo.ExpandableRecyclerView.base.BaseExpandableBean;
import cn.dankal.demo.ExpandableRecyclerView.bean.TaleGroupBean;
import cn.dankal.demo.ExpandableRecyclerView.contact.OnExpandableClickListener;
import cn.dankal.demo.R;
import java.util.ArrayList;
import java.util.List;

public class ExpandableRecyclerActivity extends AppCompatActivity {

  @BindView(R.id.toolbar_expandable_recycler) Toolbar mToolbarExpandableRecycler;
  @BindView(R.id.recycler_expandable_tale) RecyclerView mRecyclerExpandableTale;

  ExpandableRecyclerAdapter mExpandableRecyclerAdapter;
  public List<TaleGroupBean> mTaleGroupBeanList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandable_recycler);
    ButterKnife.bind(this);

    initData();
    mRecyclerExpandableTale.setLayoutManager(new LinearLayoutManager(this));
  }

  private void initData() {
    mTaleGroupBeanList = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      TaleGroupBean taleGroupBean = new TaleGroupBean();
      List<TaleGroupBean.TaleItemBean> taleItemBeanList = new ArrayList<>();
      taleGroupBean.setGroup(i);
      for (int j = 0; j < 5; j++) {
        TaleGroupBean.TaleItemBean taleItemBean = new TaleGroupBean.TaleItemBean();
        taleItemBean.setItem(i);
        taleItemBeanList.add(taleItemBean);
      }
      taleGroupBean.setTaleItemBeanList(taleItemBeanList); //内循环的赋值
      mTaleGroupBeanList.add(taleGroupBean);
    }

    mExpandableRecyclerAdapter = new ExpandableRecyclerAdapter(this, mTaleGroupBeanList);
    mRecyclerExpandableTale.setAdapter(mExpandableRecyclerAdapter);

    for (int i = 0; i < mTaleGroupBeanList.size(); i++) {
      mExpandableRecyclerAdapter.addGroupAndItem(
          mTaleGroupBeanList.get(i).getTaleItemBeanList().size());
    }
    mExpandableRecyclerAdapter.setOnExpandableClickListener(new OnExpandableClickListener() {
      @Override public void onExpandableClick(View click, BaseExpandableBean selectBean) {

      }
    });
  }
}
