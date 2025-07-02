package job_interview.java_util_concurrent.thread_completable_future.dual_task.or;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.multi_task.or
 * @ClassName: RunAfterEitherExample
 * @Author: 丛虹羽
 * @Date: 2025/5/5 11:39
 * @Description: 两个任务，只要有一个任务完成，就执行任务三
 *  runAfterEither() : 不会把执行结果当做方法入参，且没有返回值。
 */
public class RunAfterEitherExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 开启异步任务1
        CompletableFuture<Double> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "异步任务1 线程开始执行！");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "异步任务1 线程执行结束！");
            return 1542.1;
        });

        // 开启异步任务2
        CompletableFuture<Double> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "异步任务2 线程开始执行！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "异步任务2 线程执行结束！");
            return 85.4;
        });

        // 组合任务
        task1.runAfterEither(task2, () -> {
            System.out.println("其中有一个任务已经执行完成了！！！");
        }).join();
    }
}
