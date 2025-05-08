package job_interview.juc.thread_completable_future.single_task;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: ThenAccept
 * @Author: 丛虹羽
 * @Date: 2025/5/4 15:18
 * @Description: 消费父任务的返回结果（有入参，无返回值）
 *  仅在任务成功完成时触发（无异常）
 *      thenAccept() : 获取异步任务的执行结果，使用的线程 和 父任务 线程一样。
 *      thenAcceptAsync() : 获取异步任务的执行结果，使用的线程 和 父任务 线程可能一样。
 */
public class ThenAcceptExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 复制工具类
        CountDownLatch countDownLatch = new CountDownLatch(3);

        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                sum += i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " -> " + "supplyAsync()");
            countDownLatch.countDown();
            return sum;
        });

        task.thenAccept(result -> {
            result += 1;
            System.out.println(Thread.currentThread().getName() + " -> " + "thenAccept()");
            System.out.println("result = " + result);
            countDownLatch.countDown();
        });

        task.thenAcceptAsync(result -> {
            result += 2;
            System.out.println(Thread.currentThread().getName() + " -> " + "thenAcceptAsync()");
            System.out.println("result = " + result);
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
