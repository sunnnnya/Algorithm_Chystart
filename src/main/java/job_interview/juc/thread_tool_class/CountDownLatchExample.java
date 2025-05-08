package job_interview.juc.thread_tool_class;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.common_tool_class
 * @ClassName: countDownLatchExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 17:50
 * @Description: CountDownLatch 工具类
 *      让 一个 或者 多个 线程等待其他线程执行完成后再继续执行后续的业务逻辑。
 */
public class CountDownLatchExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 线程的数量
        int threadCount = 3;

        // CountDownLatch 工具类
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务！");
                try {
                    Thread.sleep(2000);
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " 结束执行任务！");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "SubThread-" + i).start();
        }

        // 一个线程等待其他线程执行完成
        // countDownLatch.await();
        // System.out.println("All task have been finished!");

        // 多个线程等待其他线程执行完成
        for(int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务！");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " 结束执行任务！");
            }, "MainThread-" + i).start();
        }
    }
}
