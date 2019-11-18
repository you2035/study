package javaBase.parameterpassing;

/**
 * @Auther: liuxin
 * @Date: 2019/7/1 15:08
 * @Description:
 */
public class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}
