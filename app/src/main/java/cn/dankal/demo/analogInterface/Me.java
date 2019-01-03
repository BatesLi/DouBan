package cn.dankal.demo.analogInterface;

import cn.dankal.basic_lib.util.ToastUtil;
import java.util.Timer;
import java.util.TimerTask;

public class Me {
  private static final String TAG = "Main";

  public void wantSleep() {
    ToastUtil.toToast("想睡觉");
  }
  public void startSleep() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override public void run() {
        ToastUtil.toToast("开始睡觉");
      }
    },0,2000);
  }
  public void stopSleep() {
    ToastUtil.toToast("停止睡觉");
  }
}
