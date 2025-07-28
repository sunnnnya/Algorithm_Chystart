package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_modification_of_data
 * @ClassName: MultiThreadModificationOfDataWithCommon
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:00
 * @Description: 使用错误的多线程修改变量的方式，会出现并发修改的错误信息！
 */
public class MultiThreadModificationOfDataWithCommon {

    private static int count = 0;

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                count++;
            }
            countDownLatch.countDown();
        }, "TheadA").start();

        new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                count++;
            }
            countDownLatch.countDown();
        }, "ThreadB").start();

        countDownLatch.await();
        System.out.println("count: " + count);
        // count: 166751
    }
}
