package job_interview.juc.thread_completable_future.single_task;

import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: WhenComplete
 * @Author: 丛虹羽
 * @Date: 2025/5/4 16:53
 * @Description: 不论是正常完成还是出现异常，都会调用 「whenComplete」 这个回调函数。
 *  「正常完成」：whenComplete 返回结果和上级任务一致，异常为 null；
 *  「出现异常」：whenComplete 返回结果为 null，异常为上级任务的异常；
 *       whenComplete(): 将执行结果或者执行期间抛出的异常传递给回调方法，子任务 和 父任务 使用同一个线程。
 *       whenCompleteAsync(): 将执行结果或者执行期间抛出的异常传递给回调方法，子任务 和 父任务 可能不使用同一个线程。
 */
public class WhenCompleteExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个子任务
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                sum += i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int a = 1 / 0;
            return sum;
        });

        // whenComplete(): 当父任务执行完成后调用， 可以接受到异常信息
        task.whenComplete((r, e) -> {
            System.out.println("Result: " + r);
            System.out.println("Exception: " + (e == null ? "null" : e.getMessage()));
        }).join();

        // join: 直接阻塞等待链式调用完成
    }
}
