package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.SelectionKey;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
//        String s = "123我是谁";
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println(Character.isDigit(aChar));
//            System.out.println(aChar);
//        }
//        System.out.println(getRandomChar());
//        System.out.println(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
//        System.out.println(42 == 42.0);
//        Test test = new Test();
//        Test test1 = new Test();
//        System.out.println(test == test1);
        System.out.println("请输入数字：");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        System.out.println("你输入的数字是 ："+s);

    }

    private static char getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        return str.charAt(0);
    }
}
