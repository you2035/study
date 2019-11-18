package java8;

import java8.FunctionalInterface.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormulaDemo implements Formula {
    @Override
    public double calculate(int a) {
        return  sqrt(a * 100);
    }

    public static void main(String[] args) {
        FormulaDemo formulaDemo = new FormulaDemo();
        System.out.println(formulaDemo.calculate(100));;
        System.out.println(formulaDemo.sqrt(16));

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//                Collections.sort(names, new Comparator<String>() {
//                    @Override
//                    public int compare(String a, String b) {
//                        return a.compareTo(b);
//                    }
//                });

                Collections.sort(names,(a,b)-> a.compareTo(b));
        for (String name : names) {
            System.out.print(name+" ");
        }

        Lambda4 lambda4 = new Lambda4();
        lambda4.testScopes();
    }




}

class Lambda4 {
    static int outerStaticNum;
    int outerNum;
    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) ->
        {
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer, String> stringConverter2 = (from) ->
        {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
