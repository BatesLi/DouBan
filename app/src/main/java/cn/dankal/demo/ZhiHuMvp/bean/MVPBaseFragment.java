package cn.dankal.demo.ZhiHuMvp.bean;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import cn.dankal.demo.R;
import cn.dankal.demo.ZhiHuMvp.presenter.BasePresenter;

public abstract class MVPBaseFragment<V, T extends BasePresenter<V>>
    extends Fragment {

  protected T mPresenter;
  protected SwipeRefreshLayout mRefreshLayout;

  @Override
  public void onCreate(Bundle saveInstanceSate) {
    super.onCreate(saveInstanceSate);
    mPresenter = createPresenter();
    mPresenter.attachView((V) this);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup,
      Bundle saveInstanceState) {

    View rootView = inflater.inflate(createViewLayout(), viewGroup, false);
    ButterKnife.bind(this, rootView);
    initView(rootView);
    if (isSetRefresh()) {

    }
    return rootView;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }

  private void setupSwipeRefresh(View view) {
    mRefreshLayout = view.findViewById(R.id.refresh_zhihu);
    if (mRefreshLayout != null) {
      mRefreshLayout.setColorSchemeResources(R.color.refresh_progress_1,
          R.color.refresh_progress_2, R.color.refresh_progress_3);
      mRefreshLayout.setProgressViewOffset(true, 0,
          (int) TypedValue
              .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24
                  , getResources().getDisplayMetrics()));
      mRefreshLayout.setOnRefreshListener(this::requestDataRefresh);
    }
  }

  public void setRefresh(boolean requestDataRefresh) {
    if (mRefreshLayout == null) {
      return;
    }
    if (!requestDataRefresh) {
      mRefreshLayout.postDelayed(() -> {
        mRefreshLayout.setRefreshing(false);
      }, 1000);
    } else {
      mRefreshLayout.setRefreshing(true);
    }
  }

  protected abstract T createPresenter();

  protected abstract int createViewLayout();

  protected void initView(View rootView) {
  }

  public Boolean isSetRefresh() {
    return true;
  }

  public void requestDataRefresh() {
  }
}
