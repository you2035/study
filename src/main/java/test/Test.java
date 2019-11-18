package test;

import java.nio.channels.SelectionKey;

public class Test {
    public static void main(String[] args) {
        System.out.println(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }
}
