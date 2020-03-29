package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Test2 {
  public static void main(String[] args) {
    int [] test = new int[]{1,2,3,4};
    List list = Arrays.asList(test);
    System.out.println(list.size());

    ArrayList<String> list1 = new ArrayList<>();
    list1.add("111");
    Vector<String> list2 = new Vector<>();
    list2.add("111");
    System.out.println(list1.equals(list2));
  }
}
