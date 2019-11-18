package javaBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Auther: liuxin
 * @Date: 2019/7/1 09:13
 * @Description:
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer j = new Integer(123);
        Integer i = new Integer(123);
        System.out.println(i==j);

        int i1 =  Integer.valueOf(11222);
        int j1 = Integer.valueOf(11222);
        System.out.println(i1==j1);

        Integer m = 12334;
        Integer n = 12334;
        System.out.println(m == n);


//        float f= 1.1;
        float f = 1.1f;
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;

//        等价与相等
//
//        对于基本类型，== 判断两个值是否相等，基本类型没有 equals() 方法。
//        对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x.equals(y)); // true
        System.out.println(x == y);      // false
        String []strings = {"a","b","c","d"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strings));
        Iterator<String> iterator =  list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if(s.equals("b")){
                iterator.remove();
            }
        }
//        for (int k = 0; k < list.size(); k++) {
//            list.remove(list.get(k));
//        }

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println(2^4);
    }
}
