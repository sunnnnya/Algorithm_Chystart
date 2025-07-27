package job_interview.java_util_concurrent.thread_community;

/**
 * @BelongsPackage: job_interview.JUC.classify_wait_notify
 * @ClassName: WaitNotifyExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 16:54
 * @Description: 通过wait()、notify()、notifyAll()进行线程间的通信
 */
public class WaitNotifyExample {

    private static Object lock = new Object();

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 生产者线程
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Producer1: Producing...");
                    Thread.sleep(2000);
                    lock.notify();
                    System.out.println("producer2: Production finished. Notifying consumer thread, right now");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Consumer1: Waiting for production to finish.");
                    // 进入等待状态
                    lock.wait();
                    System.out.println("Consumer2: Production finished. Consuming...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        /**
         * 理想执行过程：
         *  1：先执行 consumer 线程，打印完 Consumer1 后，执行 lock.wait() 进入阻塞状态(释放同步锁)，等待被唤起！
         *  2：后执行 producer 线程(获取锁)，打印完 Producer1 后，睡了两秒，接着唤起使用 lock 对象的阻塞进程，执行完成！
         *      Consumer1: Waiting for production to finish.
         *      Producer1: Producing...
         *      producer2: Production finished. Notifying consumer thread, right now
         *      Consumer2: Production finished. Consuming...
         * 特殊情况：
         *  1：先执行 producer 线程，打印完 Producer1 后，睡了两秒，接着唤起 lock 对象的阻塞进程，但此时没有对象在阻塞！
         *  2：接着执行 consumer 线程，打印完 Consumer1 后，执行 lock.wait() 进入阻塞状态(释放同步锁)，等待被唤起，但此时 producer 已经执行完成，Consumer 线程会被永久阻塞。
         *      Producer1: Producing...
         *      producer2: Production finished. Notifying consumer thread, right now
         *      Consumer1: Waiting for production to finish.
         *      永远阻塞...
         */
    }
}
