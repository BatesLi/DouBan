package cn.dankal.demo.analogInterface;

import cn.dankal.basic_lib.util.ToastUtil;

public class Test{
//模拟接口回调的过程与思路
  /*我想要睡觉
  * 我和同桌商量，老师来了就通知我 (接口回调一种通知机制)
  * 我准备睡觉
  * 停止睡觉
  * */
  public void Main() {
     Me me = new Me();
     me.wantSleep();
     Deskmate deskmate = new Deskmate();
     deskmate.setTestIView(new TestIView() {
       @Override public void informTeacher(String teacher) {
         if ("李老师".equals(teacher)) {
            ToastUtil.toToast("继续睡觉");
         }else if ("班主任".equals(teacher)) {
            me.stopSleep();
         }
       }
     });
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    me.startSleep();
    deskmate.doTeacherCome("李老师");
  }
}
