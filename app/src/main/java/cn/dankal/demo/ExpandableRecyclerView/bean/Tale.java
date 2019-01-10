package cn.dankal.demo.ExpandableRecyclerView.bean;

import java.util.List;

public class Tale {

  /**
   * date : 20190103
   * stories : [{"images":["https://pic2.zhimg.com/v2-c4aaac49261eb6a47a4b7e0196e57f05.jpg"],"type":0,"id":9704916,"ga_prefix":"010322","title":"小事 · 本命年的红内衣"},{"title":"《黑镜》的竞争对手不是游戏，而是抖音","ga_prefix":"010321","images":["https://pic4.zhimg.com/v2-948ffbfbda6dcdcfddc8aba15e9b62bf.jpg"],"multipic":true,"type":0,"id":9704846},{"title":"姜文的前半生","ga_prefix":"010318","images":["https://pic2.zhimg.com/v2-bd09bf4b1538f34bd6c2e6b6d3f49c45.jpg"],"multipic":true,"type":0,"id":9704942},{"title":"嫦娥四号成功着陆月球背面，有十大看点你需要知道","ga_prefix":"010312","images":["https://pic2.zhimg.com/v2-41cb45a5b9e53844deba93382d0c62a1.jpg"],"multipic":true,"type":0,"id":9704960},{"images":["https://pic4.zhimg.com/v2-81224f8b499c4291253ff619b3d37d2f.jpg"],"type":0,"id":9704800,"ga_prefix":"010312","title":"大误 · 如果不想狗带，劝你不要带狗"},{"title":"太阳系的天涯海角，我飞了 4730 天跨越 65 亿千米来看你","ga_prefix":"010310","images":["https://pic3.zhimg.com/v2-01b910b87abf8b1ce20e4d6644a77bfe.jpg"],"multipic":true,"type":0,"id":9704873},{"title":"中国会成为下一个科技强国吗？","ga_prefix":"010309","images":["https://pic1.zhimg.com/v2-623672e38717886c4a9138b16bbdb6c0.jpg"],"multipic":true,"type":0,"id":9704840},{"images":["https://pic2.zhimg.com/v2-e60bd312996a065de7b93b3c9bcca13d.jpg"],"type":0,"id":9704474,"ga_prefix":"010308","title":"小孩动手打爸妈，又不能还手，头疼"},{"images":["https://pic3.zhimg.com/v2-82392875b17b6796cc94d4f173364afa.jpg"],"type":0,"id":9704935,"ga_prefix":"010307","title":"摩尔庄园，永不再来"},{"title":"2018 年度盘点 · 稀奇古怪酷炫前卫的未来建筑","ga_prefix":"010307","images":["https://pic3.zhimg.com/v2-519c4803efa0af2e9d6963d366e378c6.jpg"],"multipic":true,"type":0,"id":9704912},{"images":["https://pic2.zhimg.com/v2-8dac6447653fbf3cab098f124f096eb1.jpg"],"type":0,"id":9704928,"ga_prefix":"010306","title":"瞎扯 · 如何正确地吐槽"}]
   * top_stories : [{"image":"https://pic1.zhimg.com/v2-c1416f2e4ae753f02c59c19ab0af4c40.jpg","type":0,"id":9704846,"ga_prefix":"010321","title":"《黑镜》的竞争对手不是游戏，而是抖音"},{"image":"https://pic3.zhimg.com/v2-3dc94f206bf8146d568a92fb95db3376.jpg","type":0,"id":9704942,"ga_prefix":"010318","title":"姜文的前半生"},{"image":"https://pic4.zhimg.com/v2-001b40c36f39cb6dbc0ceadce05de38b.jpg","type":0,"id":9704960,"ga_prefix":"010312","title":"嫦娥四号成功着陆月球背面，有十大看点你需要知道"},{"image":"https://pic3.zhimg.com/v2-5ccec5cdc201d0e801b797afadf99962.jpg","type":0,"id":9704912,"ga_prefix":"010307","title":"2018 年度盘点 · 稀奇古怪酷炫前卫的未来建筑"},{"image":"https://pic3.zhimg.com/v2-1659290929b2f57d31ad0906e704a1f2.jpg","type":0,"id":9704840,"ga_prefix":"010309","title":"中国会成为下一个科技强国吗？"}]
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
     * images : ["https://pic2.zhimg.com/v2-c4aaac49261eb6a47a4b7e0196e57f05.jpg"]
     * type : 0
     * id : 9704916
     * ga_prefix : 010322
     * title : 小事 · 本命年的红内衣
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
     * image : https://pic1.zhimg.com/v2-c1416f2e4ae753f02c59c19ab0af4c40.jpg
     * type : 0
     * id : 9704846
     * ga_prefix : 010321
     * title : 《黑镜》的竞争对手不是游戏，而是抖音
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
