package cn.dankal.demo.ExpandableTwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.ExpandableTwo.adapter.ExpandableTwoAdapter;
import cn.dankal.demo.ExpandableTwo.api.StoryService;
import cn.dankal.demo.ExpandableTwo.bean.StoryBean;
import cn.dankal.demo.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExpandableTwoActivity extends AppCompatActivity {

  @BindView(R.id.recycler_two) RecyclerView mRecyclerTwo;
  public List<StoryBean.StoriesBean> mData = new ArrayList<>();
  public ExpandableTwoAdapter mExpandableTwoAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expandable_two);
    ButterKnife.bind(this);

    requestData();
    mRecyclerTwo.setLayoutManager(new LinearLayoutManager(this));
    mExpandableTwoAdapter = new ExpandableTwoAdapter(mData, this);
    mRecyclerTwo.setAdapter(mExpandableTwoAdapter);
  }

  public void requestData() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://news-at.zhihu.com/")
        //通过addConverterFactory()方法设置一个数据转换器，可以将http请求的响应数据转换成JavaBean
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    StoryService storyService = retrofit.create(StoryService.class);
    rx.Observable<StoryBean> wxStory = storyService.getStoryData();

    wxStory.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<StoryBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(StoryBean storyBean) {
            //List.addAll（) 与 = 的区别?
            //list的add与addAll方法区别?
            //需要把多个List 实例放到一起的时候，必须使用List.addAll()方法。
            // mData = storyBean.getStories();//mData为null
            mData.addAll(storyBean.getStories());//有数据
            mExpandableTwoAdapter.notifyDataSetChanged();
          }
        });
  }
}
