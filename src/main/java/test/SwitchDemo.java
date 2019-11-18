package test;

public class SwitchDemo {

    public static void main(String[] args) {
        stringTest();
//        breakTest();
//        defautTest();
    }

    /*
     * default不是必须的，也可以不写
     * 输出：case two
     */
    private static void defautTest() {
        char ch = 'A';
        switch (ch) {
            case 'B':
                System.out.println("case one");
                break;
            case 'A':
                System.out.println("case two");
                break;
            case 'C':
                System.out.println("case three");
                break;
        }
    }

    /*
     * case语句中少写了break，编译不会报错
     *     但是会一直执行之后所有case条件下的语句，并不再进行判断，直到default语句
     *     下面的代码输出： case two
     *                   case three
     */
    private static void breakTest() {
        char ch = 'A';
        switch (ch) {
            case 'B':
                System.out.println("case one");

            case 'A':
                System.out.println("case two");

            case 'C':
                System.out.println("case three");
            default:
                break;
        }
    }

    /*
     * switch用于判断String类型
     *     输出：It's OK!
     */
    private static void stringTest() {
        String string = new String("hello");
        switch (string) {
            case "hello":
                System.out.println("It's OK!");
                break;

            default:
                System.out.println("ERROR!");
                break;
        }
    }
}