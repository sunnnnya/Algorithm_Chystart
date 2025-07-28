package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data
 * @ClassName: MultiThreadModificationOfDataWithReentrantLock
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:19
 * @Description: 多线程修改变量值，使用 ReentrantReadWriteLock 关键字进行处理
 */
public class MultiThreadModificationOfDataWithReentrantReadWriteLock {

    private static int count = 0;

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock writeLock = rwLock.writeLock();
        Lock readLock = rwLock.readLock();

        new Thread(() -> {
            writeLock.lock();
            try {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }
                countDownLatch.countDown();
            } finally {
                writeLock.unlock();
            }
        }, "ThreadA").start();

        new Thread(() -> {
            writeLock.lock();
            try {
                for(int i = 0; i < 100000; i++) {
                    count++;
                }
                countDownLatch.countDown();
            } finally {
                writeLock.unlock();
            }
        }, "ThreadB").start();

        countDownLatch.await();
        System.out.println("count: " + count);
        // count: 200000
    }
}
