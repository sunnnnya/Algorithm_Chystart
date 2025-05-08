package job_interview.juc.thread_completable_future.multi_task;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future.multi_task
 * @ClassName: AllOfExample
 * @Author: 丛虹羽
 * @Date: 2025/5/5 12:38
 * @Description: 多个任务都执行完成后才会执行
 *  只要有一个任务执行异常，则返回的 CompletableFuture 执行 get 方法时会抛出异常，如果都是正常执行，则 get 返回 null。
 */
public class AllOfExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 开启异步任务1
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务1，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 1;
            System.out.println("异步任务1结束");
            return result;
        });

        // 开启异步任务2
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

        // 开启异步任务3
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务3，当前线程是：" + Thread.currentThread().getId());
            int result = 1 + 3;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步任务3结束");
            return result;
        });

        // 多个任务组合
        CompletableFuture<Void> allOf = CompletableFuture.allOf(task, task2, task3);

        // 等待所有任务完成
        allOf.get();

        // 获取任务的返回结果
        System.out.println("task结果为：" + task.get());
        System.out.println("task2结果为：" + task2.get());
        System.out.println("task3结果为：" + task3.get());
    }
}
