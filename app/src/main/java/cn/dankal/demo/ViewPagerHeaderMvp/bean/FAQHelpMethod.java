package cn.dankal.demo.ViewPagerHeaderMvp.bean;

import java.util.List;

public interface FAQHelpMethod<T> {
  void setListener(Object object);

  void setRefreshData(List<T> data);

  void setLoadMoveData(List<T> data);

  void insertDataByPosition(int insertPosition, List<T> dataBean);

  void removeDataByPosition(int insertPosition, List<T> dataBean);
}
