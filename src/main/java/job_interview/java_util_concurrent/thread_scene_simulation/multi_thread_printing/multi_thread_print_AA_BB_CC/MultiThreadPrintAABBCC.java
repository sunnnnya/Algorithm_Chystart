package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_AA_BB_CC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_AA_BB_CC
 * @ClassName: MultiThreadPrintAABBCC
 * @Author: 丛虹羽
 * @Date: 2025/7/28 21:18
 * @Description: 多线程按顺序调用，A->B->C，AA 打印 5 次，BB 打印10 次，CC 打印 15 次，重复 10 次
 */
public class MultiThreadPrintAABBCC {

    private static final int MAX_NUM = 10;

    private static final int A_NUM = 5;

    private static final int B_NUM = 10;

    private static final int C_NUM = 15;

    private static int status = 0;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new Thread(() -> {
            for(int i = 0; i < MAX_NUM; i++) {
                lock.lock();
                try {
                    while(status != 0) {
                        conditionA.await();
                    }
                    for(int j = 0; j < A_NUM; j++) {
                        System.out.print("A");
                    }
                    status = 1;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            for(int i = 0; i < MAX_NUM; i++) {
                lock.lock();
                try {
                    while(status != 1) {
                        conditionB.await();
                    }
                    for(int j = 0; j < B_NUM; j++) {
                        System.out.print("B");
                    }
                    status = 2;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-B").start();

        new Thread(() -> {
            for(int i = 0; i < MAX_NUM; i++) {
                lock.lock();
                try {
                    while(status != 2) {
                        conditionC.await();
                    }
                    for(int j = 0; j < C_NUM; j++) {
                        System.out.print("C");
                    }
                    System.out.println();
                    status = 0;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "Thread-C").start();
    }
}
