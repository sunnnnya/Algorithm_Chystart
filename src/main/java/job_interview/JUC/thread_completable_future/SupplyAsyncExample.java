package job_interview.JUC.thread_completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: SupplyAsyncExacple
 * @Author: 丛虹羽
 * @Date: 2025/5/4 11:46
 * @Description: supplyAsync: 创建带有返回值的异步任务。
 */
public class SupplyAsyncExample {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> runTask(100));
        System.out.println("Result: " + task.get());
        // Result: 5050
    }

    /**
     * 子任务
     *
     * @param num 累计到的数值
     * @return Integer
     */
    private static Integer runTask(int num) {
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
