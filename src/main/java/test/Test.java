package test;

import java.io.UnsupportedEncodingException;
import java.nio.channels.SelectionKey;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        String s = "123我是谁";
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println(Character.isDigit(aChar));
//            System.out.println(aChar);
//        }
        System.out.println(getRandomChar());
        System.out.println(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
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
