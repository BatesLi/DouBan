package cn.dankal.demo.LoginTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;

public class LoginTestActivity extends AppCompatActivity {

  /*@BindView(R.id.edit_UserName) EditText mEditUserName;
  @BindView(R.id.edit_PassWord) EditText mEditPassWord;*/

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_test);
    ButterKnife.bind(this);
  }
}
