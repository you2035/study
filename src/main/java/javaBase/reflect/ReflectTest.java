package javaBase.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = methodClass.class;
        Object object = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        //获取methodClass类的add方法
        Method method = c.getMethod("add", int.class, int.class,int.class);
        System.out.println(method.getGenericParameterTypes()[0]);
        //getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法：");
        for(Method m:methods)
            System.out.println(m);
        //getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declaredMethods)
            System.out.println(m);
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class methodClass {
    public final int fuck = 3;
    public int add(int a,int b,int c) {
        return a+b+c;
    }
    public int sub(int a,int b) {
        return a+b;
    }
}
