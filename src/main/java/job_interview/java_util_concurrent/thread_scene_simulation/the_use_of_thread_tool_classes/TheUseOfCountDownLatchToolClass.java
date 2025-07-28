package job_interview.java_util_concurrent.thread_scene_simulation.the_use_of_thread_tool_classes;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.the_use_of_thread_tool_classes
 * @ClassName: TheUseOfCountDownLatchToolClass
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:29
 * @Description: 如何模拟 3个线程并发执行，1个线程等待这三个线程全部执行完在执行，怎么实现？
 */
public class TheUseOfCountDownLatchToolClass {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int threadCount = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行！");
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "结束执行！");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thead-" + (i + 1)).start();
        }

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行！");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "结束执行！");
        }, "MainThread").start();
    }
}
