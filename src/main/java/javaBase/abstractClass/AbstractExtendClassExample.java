package javaBase.abstractClass;

public class AbstractExtendClassExample extends AbstractClassExample {

    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        AbstractExtendClassExample a = new AbstractExtendClassExample();
        a.func1();
    }
}
