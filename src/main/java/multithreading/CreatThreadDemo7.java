package multithreading;

import java.util.Arrays;
import java.util.List;

//利用java8新特性 stream 实现并发
public class CreatThreadDemo7 {
    public static void main(String[] args) {
//        List<Integer> values = Arrays.asList(10,20,30,40);
//        //parallel 平行的，并行的
//        int result = values.parallelStream().mapToInt(p -> p*2).sum();
//        System.out.println(result);
//        //怎么证明它是并发处理呢
//        values.parallelStream().forEach(p-> System.out.println(p));
//
//        System.out.println(Math.round(-2.6)+" "+Math.round(2.6)+" "+Math.round(-2.5));
//        System.out.println(((1<3)?"a":"b")+3+4);
//        System.out.println(((1<3)?"a":"b")+(3+4));

        // 0100 & 0101 = 0100 = 4
        System.out.println(4&5);
        // 0100 ^ 0101 = 0001 = 1
        System.out.println(4^5);
        System.out.println(10>>1);
        // 有疑问参考下面的运算符优先级
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(4&10>>1);
    }
}
