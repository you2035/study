package java8.FunctionalInterface;

import java.io.UnsupportedEncodingException;

public class ConverterDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Converter<String,Integer> converter = Integer::valueOf;
        Integer i = converter.convert("123");
        System.out.println(i);

        SomeThing someThing = new SomeThing();
        Converter<String,String> converter1 = someThing::doSomeThing;
        String s = converter1.convert("java");
        System.out.println(s);

        String str1 = "中文";
        byte[] bytes = str1.getBytes();
        String str2 = new String(bytes, "UTF-8");
        System.out.println(str2);

    }

    static class SomeThing{
        String doSomeThing(String s){
            return String.valueOf(s.charAt(0));
        }
    }


}
