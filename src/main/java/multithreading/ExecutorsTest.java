package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: liuxin
 * @Date: 2019/7/8 10:37
 * @Description:
 */
public class ExecutorsTest {

    public static void main(String[] args) {
//        FixedThreadPool();
//        CachedThreadPool();

//        ScheduledThreadPool();

        SingleThreadExecutor();
    }

    /**
     * newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
     */
    public static void FixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };
            executorService.execute(runnable);
        }
    }

    /**
     * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
     */
    public static  void CachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };

            executorService.execute(runnable);
        }
    }

    /**
     * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行
     */
    public  static  void ScheduledThreadPool(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };

            //创建并执行在给定延迟后启用的一次性操作
            executorService.schedule(runnable,5000, TimeUnit.MICROSECONDS);

            //创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，
            // 然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推
            executorService.scheduleAtFixedRate(runnable,5000,3000,TimeUnit.MICROSECONDS);

            //创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟
            executorService.scheduleWithFixedDelay(runnable, 5000, 3000, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */

    public  static  void SingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };
            executorService.execute(runnable);
        }
    }
}
