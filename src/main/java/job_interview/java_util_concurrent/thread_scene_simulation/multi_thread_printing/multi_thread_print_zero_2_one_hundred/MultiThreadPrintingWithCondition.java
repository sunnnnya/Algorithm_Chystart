package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_zero_2_one_hundred;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing
 * @ClassName: MultiThreadPrintingWithCondition
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:50
 * @Description: 两个线程交替打印 0~100 的奇偶数，使用 condition 进行交替打印
 */
public class MultiThreadPrintingWithCondition {

    private static int count = 0;
    private static int status = 0;
    private static int MAX_NUM = 100;

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                while(count <= MAX_NUM) {
                    reentrantLock.lock();
                    while(status != 0) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                    status = 1;
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                while(count <= MAX_NUM) {
                    reentrantLock.lock();
                    while(status != 1) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                    status = 0;
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                reentrantLock.unlock();
            }
        }, "Thread-B").start();
    }
}
