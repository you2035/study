package javaBase;

/**
 * @Auther: liuxin
 * @Date: 2019/7/1 09:29
 * @Description:
 */
public class StringTest {


    public static void main(String[] args) {
        String s= "abcd";
        String s2 = "abcd";
        String s3 = "a"+"b"+"c"+"d";
        System.out.println(s == s3);
        System.out.println(Math.round(-2.5));
//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//
//        System.out.println(s == s2);//false
//
//        String s3 = new String("1") + new String("1");
//
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);//true
//        String st2 = "a"+"b"+"c";
//        String st1 = "ab";
//        String st2 = "abc";
//        String st3 = st1 + "c";
//        System.out.println(st2 == st3);
//        System.out.println(st2.equals(st3));
        System.out.println("---------------");
            String []a = {"11","22","33"};
            String []b = a;
            b[1]="44";

        for (String s1 : b) {
            System.out.print(s1+" ");
        }

        System.out.println();

        for (String s1 : a) {
            System.out.print(s1+" ");
        }

        System.out.println("-----------");
        System.out.println(null instanceof Object);

    }
}
