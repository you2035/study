package javaBase.container;

import java.util.Arrays;

/**
 * @Auther: liuxin
 * @Date: 2019/7/5 09:49
 * @Description:
 */
public class ListTest {


    public static void main(String[] args) {
        Integer arr1[] = {1,2,3,2,2,23,23};
        Integer arr2[] = {1,2,3};
       int index =  Arrays.binarySearch(arr1,2);
        System.out.println(index);
    }

}
