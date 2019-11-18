package multithreading;

/**
 * 常规方法，不多做介绍了，interrupted方法，是来判断该线程是否被中断。
 * （终止线程不允许用stop方法，该方法不会施放占用的资源。所以我们在设计程序的时候，
 * 要按照中断线程的思维去设计，就像上面的代码一样）。
 */
public class CreatThreadDemo1 extends Thread{
    /**
     * 构造方法： 继承父类方法的Thread(String name)；方法
     * @param name
     */
    public CreatThreadDemo1(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName()+"线程执行了...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CreatThreadDemo1 d1 = new CreatThreadDemo1("first");
        CreatThreadDemo1 d2 = new CreatThreadDemo1("second");

        d1.start();
        d2.start();

//        d1.interrupt();  //中断第一个线程
    }
}
