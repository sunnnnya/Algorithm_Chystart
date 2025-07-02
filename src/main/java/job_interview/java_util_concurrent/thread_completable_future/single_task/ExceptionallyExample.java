package job_interview.java_util_concurrent.thread_completable_future.single_task;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.one_task
 * @ClassName: ExceptionallyExample
 * @Author: 丛虹羽
 * @Date: 2025/5/5 11:07
 * @Description: exceptionally: 处理异步任务执行过程中抛出的异常，在链式调用中捕获异常并提供一个备用的返回值或执行恢复逻辑。
 * thenRunAsync().exceptionally(e -> {return null}) : 使用在 thenRunAsync 后面就不需要返回值。
 * thenApplyAsync().exceptionally(e -> {return 默认值}) : 使用在 thenApplyAsync 后面可以指明返回值。
 */
public class ExceptionallyExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 异步任务1
        CompletableFuture<int[]> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                return new int[]{1, 2, 3, 4};
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.err.println(e.getMessage());
            return new int[]{-1, -1, -1, -1};
        });

        // 异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 10;
        }).exceptionally(e -> {
            System.err.println(e.getMessage());
            return -1;
        });

        task1.thenCombine(task2, (nums, num) -> {
            System.out.println("nums = " + Arrays.toString(nums));
            System.out.println("num = " + num);
            return "结合成功";
        }).whenComplete((s, e) -> {
            System.err.println(e == null ? null : e.getMessage());
            System.out.println("s = " + s);
        }).join();
    }
}
