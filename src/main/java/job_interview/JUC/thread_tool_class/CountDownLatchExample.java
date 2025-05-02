package job_interview.JUC.thread_tool_class;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.common_tool_class
 * @ClassName: countDownLatchExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 17:50
 * @Description: CountDownLatch 工具类
 * （1）允许一个或多个线程等待其他线程完成操作
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
                System.out.println(Thread.currentThread().getName() + "完成任务！");
                try {
                    Thread.sleep(2000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        // 阻塞
        countDownLatch.await();

        System.out.println("All task have been finished!");
    }
}
