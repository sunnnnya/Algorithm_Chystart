package job_interview.java_util_concurrent.thread_completable_future.multi_task;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.multi_task
 * @ClassName: AnyOfExample
 * @Author: 丛虹羽
 * @Date: 2025/5/5 12:43
 * @Description: 多个任务只要有一个任务执行完成，
 *
 */
public class AnyOfExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 1;
            return result;
        });

        // 开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 2;
            return result;
        });

        // 开启异步任务3
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            int result = 1 + 3;
            return result;
        });

        // 任务组合
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(task, task2, task3);

        // 只要有一个有任务完成
        Object o = anyOf.get();
        System.out.println("完成的任务的结果：" + o);
    }
}
