package cn.dankal.demo.ExpandableTwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.ExpandableTwo.adapter.ExpandableTwoAdapter;
import cn.dankal.demo.ExpandableTwo.bean.NewsBean;
import cn.dankal.demo.ExpandableTwo.contact.ExpandableTwoContact;
import cn.dankal.demo.ExpandableTwo.presenter.ExpandableTwoPresenter;
import cn.dankal.demo.R;
import io.reactivex.disposables.Disposable;
import java.util.List;

public class ExpandableTwoActivity extends AppCompatActivity
implements ExpandableTwoContact.ExpandableTwoIView{

  @BindView(R.id.recycler_two) RecyclerView mRecyclerTwo;
  public ExpandableTwoAdapter mExpandableTwoAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandable_two);
    ButterKnife.bind(this);
    ExpandableTwoPresenter presenter = new ExpandableTwoPresenter();
    presenter.attachView(this);
    presenter.RequestData();

    mRecyclerTwo.setLayoutManager(new LinearLayoutManager(this));
  }

  @Override public void Success(List<NewsBean.StoriesBean> storiesBeanList) {
    mExpandableTwoAdapter = new ExpandableTwoAdapter(storiesBeanList,this);
    mRecyclerTwo.setAdapter(mExpandableTwoAdapter);
  }

  @Override public void showLoadingDialog() {

  }

  @Override public void dismissLoadingDialog() {

  }

  @Override public void showToast(String message) {

  }

  @Override public void tokenInvalid() {

  }

  @Override public void addNetworkRequest(Disposable d) {

  }
}
