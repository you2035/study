package test;

public class BooleanTest {
    public static void main(String[] args) {
        System.out.println(false ^ true);
        System.out.println(2>>>3);
        int a = 3,b = 5;
        b = 3;a = 5;
        a = a + b; a = 8;
        b = a - b; b = 3;
        a = a - b; a = 5;
        a = a ^ b;//
        b = a ^ b;//b = a ^ b ^ b = a
        a = a ^ b;//a = a ^ b ^ a = b;
    }
}
