package job_interview.JUC.thread_completable_future.dual_task.and;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.two_task
 * @ClassName: RunAfterBoth
 * @Author: 丛虹羽
 * @Date: 2025/5/4 20:39
 * @Description: 两个任务的组合
 *  runAfterBoth(): 不会把执行结果当做方法入参，且没有返回值
 *      注意点：当 task1 和 task2 均完成（无论正常或异常）时，执行 Runnable 动作。
 */
public class RunAfterBothExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (randomNumber >= 1) {
                throw new RuntimeException("程序运行出错了！");
            }
            return randomNumber;
        });

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            return random.nextInt(10) + 1;
        });

        // 当 task1 和 task2 均完成（无论正常或异常）时，执行 Runnable 动作。
        task2.runAfterBoth(task1, () -> {
            System.out.println("运行完成");
        }).join();
    }
}
