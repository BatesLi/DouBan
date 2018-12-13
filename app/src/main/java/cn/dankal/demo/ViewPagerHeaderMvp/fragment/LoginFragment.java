package cn.dankal.demo.ViewPagerHeaderMvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import cn.dankal.basic_lib.util.ToastUtil;
import cn.dankal.demo.R;

public class LoginFragment extends Fragment {

  @BindView(R.id.edit_mobile) EditText mEditMobile;
  @BindView(R.id.btn_login) Button mBtnLogin;
  @BindView(R.id.edit_code) EditText mEditCode;
  @BindView(R.id.btn_get_code) Button mBtnGetCode;

  @Override
  public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,
      Bundle savedInstanceState) {
    View view = layoutInflater.inflate(R.layout.fragment_blank, viewGroup, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @OnTextChanged(R.id.edit_mobile)
  void onTextMobileChanged(CharSequence charSequence, int i, int i1, int i2) {
    if (mEditMobile.getText().toString().length() == 11) {
      mBtnGetCode.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorSub));
    } else {
      mBtnGetCode.setBackground(ContextCompat.getDrawable(getContext(), R.color.colorUnClick));
    }
  }

  @OnTextChanged(R.id.edit_code)
  void onTextCodeChanged(CharSequence charSequence, int i, int i1, int i2) {
    if (!mEditCode.getText().toString().isEmpty()) {
      mBtnLogin.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorSub));
      mBtnLogin.setEnabled(true);
      mBtnLogin.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          ToastUtil.toToast("登录成功");
        }
      });
    } else {
      mBtnLogin.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorUnClick));
      mBtnLogin.setEnabled(false);
    }
  }
}
