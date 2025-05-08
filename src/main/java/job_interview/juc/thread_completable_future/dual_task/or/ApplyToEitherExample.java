package job_interview.juc.thread_completable_future.dual_task.or;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.two_task
 * @ClassName: ApplyToEither
 * @Author: 丛虹羽
 * @Date: 2025/5/4 20:51
 * @Description: 两个任务，只要有一个任务完成，就执行任务三
 *  applyToEither() : 会将已经执行完成的任务，作为方法入参，传递到指定方法中，且有返回值，要求方法兼容
 */
public class ApplyToEitherExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 开启异步任务1
        CompletableFuture<Number> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行！");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1542;
        });

        // 开启异步任务2
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 111;
        });

        // 任务组合
        task1.applyToEither(task2, (e) -> {
            System.out.println("e = " + e);
            if(e instanceof Integer) {
                return (Integer)e + 1;
            } else {
                return e;
            }
        }).join();
    }
}
