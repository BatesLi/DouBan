package cn.dankal.demo.ExpandableTwo.api;

import cn.dankal.demo.ExpandableTwo.bean.NewsBean;
import retrofit2.http.GET;
import rx.Observable;

public interface StoryService {
  @GET("api/4/news/latest") Observable<NewsBean> getStoryData();
}
