package job_interview.java_util_concurrent.thread_completable_future.dual_task.or;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.multi_task.or
 * @ClassName: AcceptEitherExample
 * @Author: 丛虹羽
 * @Date: 2025/5/5 11:39
 * @Description: 两个任务，只要有一个任务完成，就执行任务三
 *  acceptEither() : 会将已经执行完成的任务，作为方法入参，传递到指定方法中，且无返回值。
 */
public class AcceptEitherExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 1;
            System.out.println("异步任务1结束");
            return result;
        });

        //开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务2，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 2;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步任务2结束");
            return result;
        });

        // 任务组合
        task.acceptEitherAsync(task2, (res) -> {
            System.out.println("执行任务3，当前线程是：" + Thread.currentThread().getId());
            System.out.println("上一个任务的结果为：" + res);
        }).join();
    }
}
