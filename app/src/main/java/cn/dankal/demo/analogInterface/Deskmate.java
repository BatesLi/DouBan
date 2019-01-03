package cn.dankal.demo.analogInterface;

public class Deskmate{
  TestIView testIView;
  //老师来
  public void doTeacherCome(String teacher) {
    testIView.informTeacher(teacher);
  }
  public void setTestIView(TestIView testIView) {
    this.testIView = testIView;
  }
}
