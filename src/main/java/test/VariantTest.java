package test;

public class VariantTest {
    public static int staticVar = 0;

    public int instanceVar = 0;

    public VariantTest(){

        staticVar++;

        instanceVar++;

        System.out.println(staticVar +" 11 "+instanceVar);

    }

    public static void main(String[] args) {
//        VariantTest variantTest = new VariantTest();
        staticVar++;
        System.out.println(staticVar);
    }
}
