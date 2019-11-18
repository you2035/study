package javaBase.Serializable;

import java.io.*;

public class SerializableDemo implements Serializable {
    private int x;
    private String y;

    SerializableDemo(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + "  " + "y = " + y;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializableDemo a1 = new SerializableDemo(123, "abc");
        String objectFile = "D:\\复制\\桌面\\桌面\\java初级.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        SerializableDemo a2 = (SerializableDemo) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }
}
