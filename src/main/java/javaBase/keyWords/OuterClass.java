package javaBase.keyWords;

/**
 *  静态内部类
 *
 * 非静态内部类依赖于外部类的实例，而静态内部类不需要。
 *
 * 静态内部类不能访问外部类的非静态的变量和方法。
 *
 * 初始化顺序
 *
 * 静态变量和静态语句块优先于实例变量和普通语句块，
 * 静态变量和静态语句块的初始化顺序取决于它们在代码中的顺序。
 *
 * public static String staticField = "静态变量";
 * static {
 *     System.out.println("静态语句块");
 * }
 * public String field = "实例变量";
 * {
 *     System.out.println("普通语句块");
 * }
 * 最后才是构造函数的初始化。
 *
 * public InitialOrderTest() {
 *     System.out.println("构造函数");
 * }
 * 存在继承的情况下，初始化顺序为：
 *
 * 父类（静态变量、静态语句块）
 * 子类（静态变量、静态语句块）
 * 父类（实例变量、普通语句块）
 * 父类（构造函数）
 * 子类（实例变量、普通语句块）
 * 子类（构造函数）
 */
public class OuterClass {
    class InnerClass {
    }

    static class StaticInnerClass {
    }

    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
