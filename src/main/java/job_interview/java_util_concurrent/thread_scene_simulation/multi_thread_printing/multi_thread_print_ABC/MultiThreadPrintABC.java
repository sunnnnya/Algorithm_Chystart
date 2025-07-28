package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_ABC
 * @ClassName: MultiThreadPrintABD
 * @Author: 丛虹羽
 * @Date: 2025/7/28 17:17
 * @Description: 三个线程交替打印 ABC、多线程中为了避免虚假唤醒，推荐使用 while 而不是 if
 */
public class MultiThreadPrintABC {

    private static int status = 0;
    private static final int MAX_COUNT = 10;

    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition conditionA = reentrantLock.newCondition();
    private static final Condition conditionB = reentrantLock.newCondition();
    private static final Condition conditionC = reentrantLock.newCondition();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new Thread(() -> {
            for(int i = 0; i < MAX_COUNT; i++) {
                reentrantLock.lock();
                try {
                    while(status != 0) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    status = 1;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            for(int i = 0; i < MAX_COUNT; i++) {
                reentrantLock.lock();
                try {
                    while(status != 1) {
                        conditionB.await();
                    }
                    System.out.print("B");
                    status = 2;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "Thread-B").start();

        new Thread(() -> {
            for(int i = 0; i < MAX_COUNT; i++) {
                reentrantLock.lock();
                try {
                    while(status != 2) {
                        conditionC.await();
                    }
                    System.out.print("C ");
                    status = 0;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "Thread-C").start();
    }
}
