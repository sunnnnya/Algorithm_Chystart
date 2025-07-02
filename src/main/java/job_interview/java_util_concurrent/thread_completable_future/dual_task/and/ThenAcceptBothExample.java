package job_interview.java_util_concurrent.thread_completable_future.dual_task.and;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.two_task
 * @ClassName: ThenAcceptBoth
 * @Author: 丛虹羽
 * @Date: 2025/5/4 18:21
 * @Description: 两个任务的组合
 *  thenAcceptBoth(): 同样将两个任务的执行结果作为方法入参，但是无返回值。
 *      注意点：若 task1 异常完成，则组合后的 CompletableFuture 会立即异常结束，BiConsumer 不会执行。
 *             但 task2 仍可能继续执行（取决于任务是否已启动），且其完成状态不受 task1 异常影响。
 */
public class ThenAcceptBothExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // task1
        CompletableFuture<String[]> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                Random random = new Random();
                int randomNumber = random.nextInt(10) + 1;
                if (randomNumber >= 2) {
                    throw new RuntimeException("task1 出现异常了！");
                }
                return new String[]{"chystart", "Sunnnnny"};
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // task2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return 3;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 任务结合，不支持返回值
        // 即使 task1 抛出异常，task2 依然会正常执行完成。
        task1.thenAcceptBoth(task2, (s, n) -> {
            System.out.println("String[]: " + Arrays.toString(s));
            System.out.println("n: " + n);
        }).join();
    }
}
