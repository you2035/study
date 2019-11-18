package javaBase;

import java.util.HashSet;

/**
 * @Auther: liuxin
 * @Date: 2019/7/2 10:57
 * @Description:
 */
public class EqualExample {
    /**
     * 检查是否为同一个对象的引用，如果是直接返回 true；
     * 检查是否是同一个类型，如果不是，直接返回 false；
     * 将 Object 对象进行转型；
     * 判断每个关键域是否相等。
     */
    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public static void main(String[] args) {
        EqualExample ee = new EqualExample(1,2,3);
        EqualExample ee2 = new EqualExample(1,2,3);
        Object o = new Object();
//        System.out.println(ee.equals(ee2));

        EqualExample e1 = new EqualExample(1, 1, 1);
        EqualExample e2 = new EqualExample(1, 1, 1);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e1.equals(e2)); // true
        HashSet<EqualExample> set = new HashSet<>();
        set.add(e1);
        set.add(e2);

        System.out.println(set.size());   // 2
    }
}
