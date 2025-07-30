package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing_order;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing_order
 * @ClassName: MultiThreadPrintingOrderWithCondition
 * @Author: 丛虹羽
 * @Date: 2025/7/30 21:00
 * @Description: 控制多线程打印顺序 - 使用状态变量 & condition
 */
public class MultiThreadPrintingOrderWithCondition {

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
            try {
                lock.lock();
                while(status != 0) {
                    conditionA.await();
                }
                System.out.println(Thread.currentThread().getName() + " Invoked!");
                status = 1;
                conditionB.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                lock.lock();
                while(status != 1) {
                    conditionB.await();
                }
                System.out.println(Thread.currentThread().getName() + " Invoked!");
                status = 2;
                conditionC.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "Thread-B").start();

        new Thread(() -> {
            try {
                lock.lock();
                while(status != 2) {
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName() + " Invoked!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "Thread-C").start();
    }
}
