package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_zero_2_one_hundred;

import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_zero_2_one_hundred
 * @ClassName: MultiThreadPrintingWithSamphore
 * @Author: 丛虹羽
 * @Date: 2025/7/30 11:51
 * @Description: 两个线程交替打印 0~100 的奇偶数，使用 Semaphore 进行交替打印
 */
public class MultiThreadPrintingWithSemaphore {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        new Thread(() -> {
            for(int i = 0; i <= 100; i += 2) {
                try {
                    semaphore1.acquire();
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            for(int i = 1; i <= 100; i += 2) {
                try {
                    semaphore2.acquire();
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    semaphore1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-B").start();
    }
}
