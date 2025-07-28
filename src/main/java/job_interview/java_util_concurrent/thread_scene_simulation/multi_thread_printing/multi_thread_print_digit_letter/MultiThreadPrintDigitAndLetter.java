package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_digit_letter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_digit_letter
 * @ClassName: MultiThreadPrintDigitAndLetter
 * @Author: 丛虹羽
 * @Date: 2025/7/28 21:07
 * @Description: 两个线程交替打印 1A2B3D...
 */
public class MultiThreadPrintDigitAndLetter {

    private static final int MAX_NUMBER = 26;

    private static volatile int status = 0;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 打印1 2 3 4 5...
        new Thread(() -> {
            for(int i = 1; i <= MAX_NUMBER; i++) {
                lock.lock();
                try {
                    while(status != 0) {
                        conditionA.await();
                    }
                    System.out.print(i);
                    status = 1;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-A").start();

        // 打印A B C D E...
        new Thread(() -> {
            for(int i = 0; i < MAX_NUMBER; i++) {
                lock.lock();
                try {
                    while(status != 1) {
                        conditionB.await();
                    }
                    System.out.print((char) ('A' + i));
                    status = 0;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-B").start();
    }
}
