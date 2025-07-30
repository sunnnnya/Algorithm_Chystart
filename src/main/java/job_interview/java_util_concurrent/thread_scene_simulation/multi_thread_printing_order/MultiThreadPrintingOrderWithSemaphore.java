package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing_order;

import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing_order
 * @ClassName: MultiThreadPrintingOrderWithSemaphore
 * @Author: 丛虹羽
 * @Date: 2025/7/30 21:06
 * @Description: 控制多线程打印顺序 - 使用状态变量 & condition
 */
public class MultiThreadPrintingOrderWithSemaphore {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        new Thread(() -> {
            try {
                semaphoreA.acquire();
                System.out.println(Thread.currentThread().getName() + " Invoked!!");
                semaphoreB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName() + " Invoked!!");
                semaphoreC.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-B").start();

        new Thread(() -> {
            try {
                semaphoreC.acquire();
                System.out.println(Thread.currentThread().getName() + " Invoked!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread-C").start();
    }
}
