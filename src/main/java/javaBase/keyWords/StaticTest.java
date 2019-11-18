package javaBase.keyWords;

/**
 * 1. 静态变量
 *
 * 静态变量：又称为类变量，也就是说这个变量属于类的，类所有的实例都共享静态变量，
 * 可以直接通过类名来访问它。静态变量在内存中只存在一份。
 * 实例变量：每创建一个实例就会产生一个实例变量，它与该实例同生共死。
 *
 * 静态方法在类加载的时候就存在了，它不依赖于任何实例。
 * 所以静态方法必须有实现，也就是说它不能是抽象方法。
 *
 *  静态语句块
 *
 * 静态语句块在类初始化时运行一次。
 */
public  class StaticTest {
    private int x;         // 实例变量
    private static int y;  // 静态变量

    static {
        System.out.println("123");
    }

    public static void main(String[] args) {
        // int x = A.x;  // Non-static field 'x' cannot be referenced from a static context
        StaticTest a = new StaticTest();
        int x = a.x;
        int y = StaticTest.y;
    }

//    public abstract static void func2();

    public static void func1(){
        int a = y;
        // int b = y;  // Non-static field 'y' cannot be referenced from a static context
        // int b = this.y;     // 'A.this' cannot be referenced from a static context
    }
}
