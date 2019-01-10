package cn.dankal.demo.ExpandableRecyclerView.api;

import cn.dankal.demo.ExpandableRecyclerView.bean.Tale;
import retrofit2.http.GET;
import rx.Observable;

public interface ExpandableRecyclerService {
  // http://news-at.zhihu.com/api/4/news/latest
  @GET("api/4/news/latest") Observable<Tale> getTaleData();
}
