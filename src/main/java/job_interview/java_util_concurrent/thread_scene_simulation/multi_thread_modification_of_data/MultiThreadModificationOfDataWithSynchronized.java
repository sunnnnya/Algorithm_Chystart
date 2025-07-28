package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data
 * @ClassName: MultiThreadModificationOfDataWithSynchronized
 * @Author: 丛虹羽
 * @Date: 2025/7/28 15:56
 * @Description: 多线程修改变量值，使用 Synchronized 关键字进行处理
 */
public class MultiThreadModificationOfDataWithSynchronized {

    private static int count = 0;

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Object object = new Object();

        new Thread(() -> {
            synchronized (object) {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }
            }
            countDownLatch.countDown();
        }, "ThreadA").start();

        new Thread(() -> {
            synchronized (object) {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }
            }
            countDownLatch.countDown();
        }, "ThreadB").start();

        countDownLatch.await();
        System.out.println("count: " + count);
        // count: 200000
    }
}
