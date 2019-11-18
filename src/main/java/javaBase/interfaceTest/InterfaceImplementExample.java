package javaBase.interfaceTest;

/**
 * 3. 比较
 *
 * 从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所有父类对象。
 * 而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具有 IS-A 关系。
 * 从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类。
 * 接口的字段只能是 static 和 final 类型的，而抽象类的字段没有这种限制。
 * 接口的成员只能是 public 的，而抽象类的成员可以有多种访问权限。
 * 4. 使用选择
 *
 * 使用接口：
 *
 * 需要让不相关的类都实现一个方法，例如不相关的类都可以实现 Compareable 接口中的 compareTo() 方法；
 * 需要使用多重继承。
 * 使用抽象类：
 *
 * 需要在几个相关的类中共享代码。
 * 需要能控制继承来的成员的访问权限，而不是都为 public。
 * 需要继承非静态和非常量字段。
 * 在很多情况下，接口优先于抽象类。因为接口没有抽象类严格的类层次结构要求，可以灵活地为一个类添加行为。
 * 并且从 Java 8 开始，接口也可以有默认的方法实现，使得修改接口的成本也变的很低。
 */
public class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }

    public static void main(String[] args) {
        InterfaceImplementExample iie = new InterfaceImplementExample();
        iie.func1();
    }
}
