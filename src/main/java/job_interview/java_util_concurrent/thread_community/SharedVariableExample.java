package job_interview.java_util_concurrent.thread_community;

/**
 * @BelongsPackage: job_interview.JUC.classify_wait_notify
 * @ClassName: SharedVariableExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 16:43
 * @Description: 使用共享变量进行通信
 */
public class SharedVariableExample {

    // 共享变量
    // volatile: 保持线程之间的可见性、禁止指令重排序！！
    private static volatile boolean flag = false;

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer start change variable flag:【false -> true】");
            flag = true;
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            while (!flag) {
                System.out.println("consumer thread is running!");
            }
            System.out.println("consumer thread has finished all right!");
        });

        producer.start();
        consumer.start();
    }
}
