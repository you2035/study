package test;

public class MathTest {
    public static void main(String[] args) {
        double a = 12.86;
        int b = (int) a;    //强制类型转换
        System.out.println("强制类型转换：" + b);
        long c = Math.round(a);    //四舍五入
        System.out.println("四舍五入：" + c);
        double d = Math.floor(a);    //返回小于参数a的最大整数
        System.out.println("小于a的最大整数：" + d);
        double e = Math.ceil(a);    //返回大于参数a的最小整数
        System.out.println("大于a的最小整数：" + e);
        double x = Math.random();    //产生[0,1)区间内的随机浮点数
        System.out.println("默认随机数：" + x);
        int y = (int) (Math.random()*99);    //产生[0,99)区间内的随机整数
        System.out.println("0-99之间的随机整数(不包括99)：" + y);
        System.out.println();
        //Integer i = new Integer(6);
        Integer.valueOf(6);
        Integer i  = -129;
        Integer j = -129;
        System.out.println(i==j);
    }
}
