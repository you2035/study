package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterterTest {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("张三");
        name.add("李四");
        name.add("王五");
        Iterator<String> iterator = name.iterator();
        while (iterator.hasNext()){
            String s =iterator.next();
            if (s.equals("张三")){
                iterator.remove();
            }
        }

        for (String s : name) {
            System.out.println(s);
        }
    }
}
