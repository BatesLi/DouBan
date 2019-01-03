package cn.dankal.demo.ViewPagerHeaderMvp.bean;

import java.util.List;

public class NewsBean {

  /**
   * date : 20181229
   * stories : [{"images":["https://pic3.zhimg.com/v2-1f7d2a1b323dc6fd1196174c8bf0a33a.jpg"],"type":0,"id":9668115,"ga_prefix":"122912","title":"大误 · 狼人杀玩得好，拿到 offer 比别人早"},{"title":"想在这条路飙车？你得先和一万多人拼手气","ga_prefix":"122910","images":["https://pic3.zhimg.com/v2-3e27b118e0d396510c9146d04ddfad7e.jpg"],"multipic":true,"type":0,"id":9684480},{"title":"在战场上，刀真的比剑厉害吗？","ga_prefix":"122909","images":["https://pic3.zhimg.com/v2-1e6e1e1a98f7a639d4728665e63fafce.jpg"],"multipic":true,"type":0,"id":9704507},{"images":["https://pic2.zhimg.com/v2-d964d9676370ff3e774960cebac0cff9.jpg"],"type":0,"id":9704187,"ga_prefix":"122908","title":"你那么好看，一定是个渣渣吧"},{"images":["https://pic2.zhimg.com/v2-59bfd7704319da9d317d1b9dd1827c65.jpg"],"type":0,"id":9704675,"ga_prefix":"122907","title":"逼着孩子学这个学那个，不如先逼一下自己"},{"title":"2018 年度盘点 · 今年有哪些值得推荐的 iPad 应用？","ga_prefix":"122907","images":["https://pic2.zhimg.com/v2-8125bb440d1bd2edae1d8ede5130c085.jpg"],"multipic":true,"type":0,"id":9704690},{"images":["https://pic2.zhimg.com/v2-1aecea97693f809a211e3c371f93def9.jpg"],"type":0,"id":9704627,"ga_prefix":"122906","title":"瞎扯 · 如何正确地吐槽"}]
   * top_stories : [{"image":"https://pic4.zhimg.com/v2-0728963ac161cb2c6f4fec97f655a28f.jpg","type":0,"id":9704507,"ga_prefix":"122909","title":"在战场上，刀真的比剑厉害吗？"},{"image":"https://pic1.zhimg.com/v2-2c89f5ee228df531c5efa7c7c9d44654.jpg","type":0,"id":9673169,"ga_prefix":"122818","title":"有哪些长期被忽视，但也很厉害的「世界第二」？"},{"image":"https://pic2.zhimg.com/v2-264ee13ff5e8f9e52aff2f8870432b89.jpg","type":0,"id":9704624,"ga_prefix":"122807","title":"日本退出了国际捕鲸委员会，但开放商业捕鲸的理由根本站不住脚"},{"image":"https://pic1.zhimg.com/v2-f0fb1698c6abd8b2c5acf4352a46bd80.jpg","type":0,"id":9704532,"ga_prefix":"122809","title":"男方有车有房给彩礼才能结婚，可不要说「都怪女人太贪婪」"},{"image":"https://pic1.zhimg.com/v2-f2886c1453f77e8bd7981c22115c03b4.jpg","type":0,"id":9704541,"ga_prefix":"122810","title":"9 个月亏损 8.6 亿，瑞幸咖啡的钱都花到哪去了？"}]
   */

  private String date;
  private List<StoriesBean> stories;
  private List<TopStoriesBean> top_stories;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<StoriesBean> getStories() {
    return stories;
  }

  public void setStories(List<StoriesBean> stories) {
    this.stories = stories;
  }

  public List<TopStoriesBean> getTop_stories() {
    return top_stories;
  }

  public void setTop_stories(List<TopStoriesBean> top_stories) {
    this.top_stories = top_stories;
  }

  public static class StoriesBean {
    /**
     * images : ["https://pic3.zhimg.com/v2-1f7d2a1b323dc6fd1196174c8bf0a33a.jpg"]
     * type : 0
     * id : 9668115
     * ga_prefix : 122912
     * title : 大误 · 狼人杀玩得好，拿到 offer 比别人早
     * multipic : true
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multipic;
    private List<String> images;

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getGa_prefix() {
      return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
      this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public boolean isMultipic() {
      return multipic;
    }

    public void setMultipic(boolean multipic) {
      this.multipic = multipic;
    }

    public List<String> getImages() {
      return images;
    }

    public void setImages(List<String> images) {
      this.images = images;
    }
  }

  public static class TopStoriesBean {
    /**
     * image : https://pic4.zhimg.com/v2-0728963ac161cb2c6f4fec97f655a28f.jpg
     * type : 0
     * id : 9704507
     * ga_prefix : 122909
     * title : 在战场上，刀真的比剑厉害吗？
     */

    private String image;
    private int type;
    private int id;
    private String ga_prefix;
    private String title;

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getGa_prefix() {
      return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
      this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}