package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatTest {
	public static final int ENDNUMBER = Integer.MAX_VALUE;
	public static final int STARTNUMBER = ENDNUMBER - 3;

	public static void main(String[] args) {
//        Float a = 200000.8f;
//        Float b = 175000.5f;
//        Float c = a-b;
//        System.out.println(c);
//
//        BigDecimal d = new BigDecimal(a.toString());
//        BigDecimal e = new BigDecimal(b.toString());
//        float f = d.subtract(e).floatValue();
//        System.out.println(f);
//        Integer o = Integer.MAX_VALUE -2;
//        System.out.println(o);
//        int count = 0;
//        for(int i = STARTNUMBER;i < ENDNUMBER;i++){
//
//            count++;
//        }
//        System.out.println(count);

//        BigDecimal bigDecimal = new BigDecimal(2);
//        BigDecimal bDouble = new BigDecimal(2.3);
//        BigDecimal bString = new BigDecimal("2.3");
//        System.out.println("bigDecimal=" + bigDecimal);
//        System.out.println("bDouble=" + bDouble);
//        System.out.println("bString=" + bString);
//
//        BigDecimal bDouble1 = BigDecimal.valueOf(2.3);
//        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.3));
//
//        System.out.println("bDouble1=" + bDouble1);
//        System.out.println("bDouble2=" + bDouble2);

//        BigDecimal a = new BigDecimal("4.5");
//        BigDecimal b = new BigDecimal("1.3");
//
//        System.out.println("a + b =" + a.add(b));
//        System.out.println("a - b =" + a.subtract(b));
//        System.out.println("a * b =" + a.multiply(b));
//        System.out.println("a / b =" + a.divide(b,2,BigDecimal.ROUND_HALF_UP));

//        BigDecimal a = new BigDecimal("4.5635");
//
//        a = a.setScale(3, RoundingMode.HALF_UP);    //保留3位小数，且四舍五入
//        System.out.println(a);

		BigDecimal a = new BigDecimal(101);
		BigDecimal b = new BigDecimal(111);

		//使用compareTo方法比较
		//注意：a、b均不能为null，否则会报空指针
		if (a.compareTo(b) == -1) {
			System.out.println("a小于b");
		}

		if (a.compareTo(b) == 0) {
			System.out.println("a等于b");
		}

		if (a.compareTo(b) == 1) {
			System.out.println("a大于b");
		}

		if (a.compareTo(b) > -1) {
			System.out.println("a大于等于b");
		}

		if (a.compareTo(b) < 1) {
			System.out.println("a小于等于b");
		}

		// 浮点数的打印
		System.out.println(new BigDecimal("10000000000").toString());

		// 普通的数字字符串
		System.out.println(new BigDecimal("100.000").toString());

		// 去除末尾多余的0
		System.out.println(new BigDecimal("100.000").stripTrailingZeros().toString());

		// 避免输出科学计数法
		System.out.println(new BigDecimal("100.000").stripTrailingZeros().toPlainString());

	}
}
