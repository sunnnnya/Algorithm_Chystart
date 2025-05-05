package job_interview.JUC.thread_completable_future.single_task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: ThenRunExample
 * @Author: 丛虹羽
 * @Date: 2025/5/4 15:45
 * @Description: 接着执行任务（无入参，无返回值）
 *  thenRun(): 子任务 与 父任务使用的是同一个线程
 *  thenRunAsync(): 子任务"可能" 和 父任务 使用同一个线程，或者使用指定的线程池！
 */
public class ThenRunExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 辅助工具类
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // 起一个异步任务
        CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
            for(int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " -> " + "runAsync()");
            countDownLatch.countDown();
        });

        // 再次起一个异步任务，使用同一个线程
        task.thenRun(() -> {
            // 确保 thenRunAsync() 使用其他线程
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " -> " + "thenRun()");
            countDownLatch.countDown();
        });

        // 再次起一个异步任务，可能使用其他线程
        task.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " -> " + "thenRunAsync()");
            countDownLatch.countDown();
        });

        try {
            // block
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
