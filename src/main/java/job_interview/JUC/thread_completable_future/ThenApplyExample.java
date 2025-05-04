package job_interview.JUC.thread_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: ThenApplyExample
 * @Author: 丛虹羽
 * @Date: 2025/5/4 14:40
 * @Description: 应用父任务的返回结果（有入参，有返回值）
 *  thenApply(): 子任务与父任务使用的是同一个线程
 *  thenApplyAsync(): 子任务“可能”是另起一个线程执行任务
 */
public class ThenApplyExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 创建带返回值的异步任务
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " -> " + "supplyAsync()");
            countDownLatch.countDown();
            return sum;
        });

        // 不会阻塞：thenApply() 与 task 使用一个线程
        task.thenApply((result) -> {
            result += 20;
            System.out.println(Thread.currentThread().getName() + " -> " + "thenApply()");
            countDownLatch.countDown();
            return result;
        }).thenAccept(System.out::println);

        // 不会阻塞: thenApplyAsync() 不与 task 使用一个线程
        task.thenApplyAsync(result -> {
            result += 40;
            System.out.println(Thread.currentThread().getName() + " -> " + "thenApply()");
            countDownLatch.countDown();
            return result;
        }).thenAccept(System.out::println);

        System.out.println(Thread.currentThread().getName() + " is running ~ ");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
