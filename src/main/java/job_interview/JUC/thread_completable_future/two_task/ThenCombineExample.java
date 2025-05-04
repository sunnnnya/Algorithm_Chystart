package job_interview.JUC.thread_completable_future.two_task;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.two_task
 * @ClassName: ThenCombine
 * @Author: 丛虹羽
 * @Date: 2025/5/4 18:08
 * @Description: 两个任务的组合
 *  thenCombine(): 将两个任务的执行结果作为所提供函数的参数，且该方法 "有返回值"。
 */
public class ThenCombineExample {
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
                return new String[]{"chystart", "Sunnnnny"};
            } catch (InterruptedException e) {
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

        // 任务结合，支持返回值
        task1.thenCombine(task2, (s, n) -> {
            String[][] ss = new String[n][s.length];
            for(int i = 0; i < n; i++) {
                ss[i] = s;
            }
            return ss;
        }).thenAccept(s -> System.out.println(Arrays.deepToString(s)))
                .join();
    }
}
