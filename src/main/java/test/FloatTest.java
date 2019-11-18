package test;

import java.math.BigDecimal;

public class FloatTest {
    public static final int ENDNUMBER = Integer.MAX_VALUE;
    public static final int STARTNUMBER = ENDNUMBER - 3;

    public static void main(String[] args) {
        Float a = 200000.8f;
        Float b = 175000.5f;
        Float c = a-b;
        System.out.println(c);

        BigDecimal d = new BigDecimal(a.toString());
        BigDecimal e = new BigDecimal(b.toString());
        float f = d.subtract(e).floatValue();
        System.out.println(f);
        Integer o = Integer.MAX_VALUE -2;
        System.out.println(o);
        int count = 0;
        for(int i = STARTNUMBER;i < ENDNUMBER;i++){

            count++;
        }
        System.out.println(count);
    }
}
