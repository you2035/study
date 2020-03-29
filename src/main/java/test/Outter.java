package test;

public class Outter {
  static class inner{
    static int paramOne = 5;
    static final int paramTwo = 5;
    static final int paramThree = new Integer(5);
  }

  public static void main(String[] args) {
    System.out.println(Outter.inner.paramOne);
    System.out.println(Outter.inner.paramTwo);
    System.out.println(Outter.inner.paramThree);
  }
}
