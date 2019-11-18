package javaBase;

public class ToStringExample {
    private int number;

    public ToStringExample(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }

    public static void main(String[] args) {
        ToStringExample te  =new ToStringExample(123);
        System.out.println(te.toString());
    }
}
