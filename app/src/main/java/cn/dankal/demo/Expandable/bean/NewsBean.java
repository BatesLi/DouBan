package cn.dankal.demo.Expandable.bean;

import java.util.List;

public class NewsBean {

  /**
   * date : 20181211
   * stories : [{"images":["https://pic1.zhimg.com/v2-da230f0a7e24d57689c78db8a3f6029c.jpg"],"type":0,"id":9703380,"ga_prefix":"121116","title":"学霸也有苦，学霸也有无奈，学霸的委屈没有人明白"},{"images":["https://pic2.zhimg.com/v2-7e7581011dae17d9004af68d1da44bc1.jpg"],"type":0,"id":9703394,"ga_prefix":"121112","title":"大误 · 小孩子还是不要看《西游记》了"},{"images":["https://pic3.zhimg.com/v2-8c8072040da91d7da88e623bcab397ce.jpg"],"type":0,"id":9663858,"ga_prefix":"121110","title":"有哪些换个角度就能解决的问题？"},{"images":["https://pic1.zhimg.com/v2-19000b5db8040ba70122a24f23072448.jpg"],"type":0,"id":9664541,"ga_prefix":"121109","title":"一片被全班男生传阅的卫生巾"},{"images":["https://pic3.zhimg.com/v2-8843477413c40f77ed9d656219abd69e.jpg"],"type":0,"id":9703527,"ga_prefix":"121108","title":"维密依然性感，但这个世界已经变了"},{"images":["https://pic2.zhimg.com/v2-7db6a470134e0c08da9b3b801e890909.jpg"],"type":0,"id":9703429,"ga_prefix":"121107","title":"上海互联网人的 2018：留下与离开，都不是意外"},{"images":["https://pic1.zhimg.com/v2-409000da2d59ab9ded320d04bd52373c.jpg"],"type":0,"id":9703501,"ga_prefix":"121107","title":"输给蒙牛和伊利的光明，结局在一开始就已写好"},{"images":["https://pic4.zhimg.com/v2-0d847e9b7dd6f730a96bc56981721533.jpg"],"type":0,"id":9703467,"ga_prefix":"121106","title":"瞎扯 · 如何正确地吐槽"}]
   * top_stories : [{"image":"https://pic1.zhimg.com/v2-caa4da374249cef3bdf84d4d6e102074.jpg","type":0,"id":9703429,"ga_prefix":"121107","title":"上海互联网人的 2018：留下与离开，都不是意外"},{"image":"https://pic3.zhimg.com/v2-f8b03e8b5e4218379ba1f93a35be719a.jpg","type":0,"id":9664541,"ga_prefix":"121109","title":"一片被全班男生传阅的卫生巾"},{"image":"https://pic4.zhimg.com/v2-b58560c1d06d23920459a7e98075aa63.jpg","type":0,"id":9703501,"ga_prefix":"121107","title":"输给蒙牛和伊利的光明，结局在一开始就已写好"},{"image":"https://pic4.zhimg.com/v2-25eef910ba4d45697b584e68aed1b45b.jpg","type":0,"id":9664205,"ga_prefix":"121019","title":"收紧你的核心，停，你别吸肚子啊"},{"image":"https://pic4.zhimg.com/v2-a09cf98db051503ed13a1065ff6bd54b.jpg","type":0,"id":9703422,"ga_prefix":"121008","title":"我是个年轻人，我觉得我的工作没有意义"}]
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
     * images : ["https://pic1.zhimg.com/v2-da230f0a7e24d57689c78db8a3f6029c.jpg"]
     * type : 0
     * id : 9703380
     * ga_prefix : 121116
     * title : 学霸也有苦，学霸也有无奈，学霸的委屈没有人明白
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
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

    public List<String> getImages() {
      return images;
    }

    public void setImages(List<String> images) {
      this.images = images;
    }
  }

  public static class TopStoriesBean {
    /**
     * image : https://pic1.zhimg.com/v2-caa4da374249cef3bdf84d4d6e102074.jpg
     * type : 0
     * id : 9703429
     * ga_prefix : 121107
     * title : 上海互联网人的 2018：留下与离开，都不是意外
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
