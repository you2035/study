package mysql;

import java.util.Arrays;
import java.util.List;

public class MysqlTest {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}