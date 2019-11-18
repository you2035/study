package javaBase.clone;

public class CloneExample implements Cloneable{
    private int a;
    private int b;

    public CloneExample(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    public static void main(String[] args) {
        CloneExample e1 = new CloneExample(12,3);
        try {
            CloneExample e2 = e1.clone();
            System.out.println(e2.a);
            System.out.println(e2.b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
