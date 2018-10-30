package cn.dankal.demo.ZhiHuMvp.bean;

import java.util.List;

public class NewsTimeLine {

  /**
   * date : 20181015
   * stories : [{"images":["https://pic3.zhimg.com/v2-65a4001869e5d91bfac990c6df3b2e5a.jpg"],"type":0,"id":9698592,"ga_prefix":"101522","title":"小事 · 生而为人"},{"title":"别再和《甄嬛传》比了，《如懿传》大结局是碾压级的","ga_prefix":"101521","images":["https://pic3.zhimg.com/v2-b7b3457feb31402889f2f2691f5d42c6.jpg"],"multipic":true,"type":0,"id":9698625},{"title":"想象一下，食欲和性欲通过虚拟感觉满足，家只是个空白的盒子","ga_prefix":"101519","images":["https://pic2.zhimg.com/v2-3311edae9653d6e3bcf99d95599db885.jpg"],"multipic":true,"type":0,"id":9698505},{"images":["https://pic3.zhimg.com/v2-eed5430d8f06f2b3162ce8da8aa1c71a.jpg"],"type":0,"id":9698496,"ga_prefix":"101517","title":"我是帝王蟹，不，我不算螃蟹"},{"images":["https://pic4.zhimg.com/v2-b4c94661a02f3ab9cb5372e7606ad6f3.jpg"],"type":0,"id":9698419,"ga_prefix":"101515","title":"腾讯音乐即将 IPO，估值全靠用户多"},{"images":["https://pic1.zhimg.com/v2-ca4be4bcbfb54a9cd5f72806b1b79bb4.jpg"],"type":0,"id":9698205,"ga_prefix":"101513","title":"想去日企工作，就少看点动漫吧"},{"images":["https://pic4.zhimg.com/v2-892d813b3a7fda20a9244d62933018f3.jpg"],"type":0,"id":9698474,"ga_prefix":"101512","title":"大误 · 酒店里的奇怪暗号"},{"images":["https://pic3.zhimg.com/v2-bb06facccc023aed18cce7b99b641156.jpg"],"type":0,"id":9698461,"ga_prefix":"101510","title":"感觉自己部门的离职率好高，似乎说明\u2026\u2026"},{"images":["https://pic1.zhimg.com/v2-4abeef9dd97bb0b628d8cc41d59345f0.jpg"],"type":0,"id":9698453,"ga_prefix":"101509","title":"唉，你们这些巨星，真是爱挑战我 NBA 的底线"},{"images":["https://pic3.zhimg.com/v2-75adb80ad9aaa11ae93b9eafbe6e19ce.jpg"],"type":0,"id":9698301,"ga_prefix":"101508","title":"现在不好好读书，长大后就对不起你的孩子"},{"images":["https://pic2.zhimg.com/v2-d4d14cbea360131056a7ac2f978ce09d.jpg"],"type":0,"id":9698323,"ga_prefix":"101507","title":"地球上最强大的两个种族间的战争，最后人类还是输了"},{"images":["https://pic4.zhimg.com/v2-6cd13b2e003613801f227215883b009b.jpg"],"type":0,"id":9698485,"ga_prefix":"101507","title":"你有权利要求剖腹产，但作为医生，我也有权利负责任地拒绝你"},{"images":["https://pic2.zhimg.com/v2-c21c3cdb5ebd138ce64508da1e1b415d.jpg"],"type":0,"id":9698468,"ga_prefix":"101506","title":"瞎扯 · 如何正确地吐槽"}]
   * top_stories : [{"image":"https://pic4.zhimg.com/v2-d10222731bc5c952aae6f97b8410007f.jpg","type":0,"id":9698625,"ga_prefix":"101521","title":"别再和《甄嬛传》比了，《如懿传》大结局是碾压级的"},{"image":"https://pic4.zhimg.com/v2-19ac578c9a4de05c602f506ab048f627.jpg","type":0,"id":9698461,"ga_prefix":"101510","title":"感觉自己部门的离职率好高，似乎说明\u2026\u2026"},{"image":"https://pic3.zhimg.com/v2-e6b2ab7d71e7c1043a863232c9da9f6e.jpg","type":0,"id":9698485,"ga_prefix":"101507","title":"你有权利要求剖腹产，但作为医生，我也有权利负责任地拒绝你"},{"image":"https://pic1.zhimg.com/v2-804bed172a36b724467f21ae419e19c4.jpg","type":0,"id":9698233,"ga_prefix":"101419","title":"这帮响当当的「蜀二代」，一个能打的都没有"},{"image":"https://pic4.zhimg.com/v2-5a94176964f452c4f491bfb44e3b66e7.jpg","type":0,"id":9697852,"ga_prefix":"101418","title":"- 连钱都解决不了的问题\u2026\u2026\r\n- 用蝙蝠侠解决"}]
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
     * images : ["https://pic3.zhimg.com/v2-65a4001869e5d91bfac990c6df3b2e5a.jpg"]
     * type : 0
     * id : 9698592
     * ga_prefix : 101522
     * title : 小事 · 生而为人
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
     * image : https://pic4.zhimg.com/v2-d10222731bc5c952aae6f97b8410007f.jpg
     * type : 0
     * id : 9698625
     * ga_prefix : 101521
     * title : 别再和《甄嬛传》比了，《如懿传》大结局是碾压级的
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
