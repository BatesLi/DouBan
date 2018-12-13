package cn.dankal.demo.TestMvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;

public class TestActivity extends AppCompatActivity implements LinkmanContact.LinkmanIView {

  @BindView(R.id.txt_data) TextView mTxtData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    ButterKnife.bind(this);

    LinkmanPresenter linkmanPresenter = new LinkmanPresenter();
    linkmanPresenter.getData(mTxtData);
    linkmanPresenter.attachView(this);
  }

  @Override public void UpdatePages() {

  }

  @Override public void Test() {
    ToastUtil.toToast("测试");
  }
}
