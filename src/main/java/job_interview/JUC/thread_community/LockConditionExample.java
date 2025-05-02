package job_interview.JUC.thread_community;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsPackage: job_interview.JUC.classify_thread_community
 * @ClassName: LockConditionExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 17:28
 * @Description: 通过await()、signal()、signalAll()进行通信
 */
public class LockConditionExample {

    // 可重入锁
    private static final Lock lock = new ReentrantLock();

    // 通过 Lock 接口获取 condition
    private static final Condition condition = lock.newCondition();

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        // 生产者线程
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Producer1: Producing...");
                Thread.sleep(2000);
                condition.signal();
                System.out.println("producer2: Production finished. Notifying consumer thread, right now");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Consumer1: Waiting for production to finish.");
                condition.await();
                System.out.println("Consumer2: Production finished. Consuming...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        consumer.start();
        producer.start();
        /**
         * 理想执行过程：
         *  1：先执行 consumer 线程，打印完 Consumer1 后，执行 condition.await() 进入阻塞状态(释放锁)，等待被唤起！
         *  2：后执行 producer 线程(获取锁)，打印完 Producer1 后，睡了两秒，接着唤起阻塞进程，执行完成！
         *      Consumer1: Waiting for production to finish.
         *      Producer1: Producing...
         *      producer2: Production finished. Notifying consumer thread, right now
         *      Consumer2: Production finished. Consuming...
         * 特殊情况：
         *  1：先执行 producer 线程，打印完 Producer1 后，睡了两秒，接着阻塞进程，但此时没有线程在阻塞！
         *  2：接着执行 consumer 线程，打印完 Consumer1 后，执行 condition.await() 进入阻塞状态(释放同步锁)，等待被唤起，但此时 producer 已经执行完成，Consumer 线程会被永久阻塞。
         *      Producer1: Producing...
         *      producer2: Production finished. Notifying consumer thread, right now
         *      Consumer1: Waiting for production to finish.
         *      永远阻塞...
         */
    }
}
