package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParaTest {
    public static void main(String[] args) {
        Integer total = 0;
        paramCheck(0);
        System.out.println(total);

        String array[] = new String[]{"张三","李思","王五"};
        List<String> strings = Arrays.asList(array);
        strings.add("liu");
        strings.remove(0);
        System.out.println(strings.size());
//解决办法
//        String array[] = new String[]{"张三","李思思","王五"};
//        List<String> strings = Arrays.asList(array);
//        List arrList = new ArrayList(strings);
//        arrList.add("liu");
//        System.out.println(arrList.size());



    }

    public static  void paramCheck(Integer total){
        if (total < 1){
            total +=1;
        }
        System.out.println(total );
    }
}
