package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data
 * @ClassName: MultiThreadModificationOfDataCommon
 * @Author: 丛虹羽
 * @Date: 2025/7/28 15:46
 * @Description: 多线程修改变量值，使用 java.util.concurrent 包中的原子类进行操作
 */
public class MultiThreadModificationOfDataWithAtomic {

    /**
     * 使用 java.util.concurrent 包中的原子类进行操作
     *
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        AtomicInteger count = new AtomicInteger(0);

        new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                count.getAndIncrement();
            }
            countDownLatch.countDown();
        },"TaskA").start();

        new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                count.getAndIncrement();
            }
            countDownLatch.countDown();
        }, "TaskB").start();

        countDownLatch.await();
        System.out.println("count: " + count);
        // count: 200000
    }
}
