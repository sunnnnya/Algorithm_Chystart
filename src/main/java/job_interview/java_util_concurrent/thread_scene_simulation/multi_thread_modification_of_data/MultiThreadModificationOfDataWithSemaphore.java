package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data
 * @ClassName: MultiThreadModificationOfDataWithSemaphore
 * @Author: 丛虹羽
 * @Date: 2025/8/1 18:14
 * @Description: 多线程修改变量值，使用 java.util.concurrent 包中的 Semaphore 进行操作
 */
public class MultiThreadModificationOfDataWithSemaphore {

    private static int count = 0;

    /**
     * 使用 java.util.concurrent 包中的 Semaphore 进行操作
     *
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);

        new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                try {
                    semaphoreA.acquire();
                    count++;
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            countDownLatch.countDown();
        }, "Thread-A").start();

        new Thread(() -> {
            for(int i = 0; i < 10000; i++) {
                try {
                    semaphoreB.acquire();
                    count++;
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            countDownLatch.countDown();
        }, "Thread-B").start();

        countDownLatch.await();
        System.out.println("count: " + count);
        // count: 20000
    }
}
