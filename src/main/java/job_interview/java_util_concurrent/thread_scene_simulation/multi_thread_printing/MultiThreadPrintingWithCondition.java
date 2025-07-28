package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing
 * @ClassName: MultiThreadPrintingWithCondition
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:50
 * @Description: 使用 condition 进行交替打印
 */
public class MultiThreadPrintingWithCondition {

    private static int count = 1;

    private static int MAX_NUM = 16;

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                reentrantLock.lock();
                while(count <= MAX_NUM) {
                    if((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                        condition.signal();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                while(count <= MAX_NUM) {
                    if((count & 1) != 1) {
                        System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                        condition.signal();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }, "Thread-B").start();
    }
}
