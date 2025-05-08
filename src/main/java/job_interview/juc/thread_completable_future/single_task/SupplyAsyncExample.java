package job_interview.juc.thread_completable_future.single_task;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: SupplyAsyncExacple
 * @Author: 丛虹羽
 * @Date: 2025/5/4 11:46
 * @Description:
 *  supplyAsync(): 创建带有返回值的异步任务。
 *  -- 获取异步任务的执行结果。
 *      get(): 只有当前任务执行完成后才会返回结果，会阻塞进程的执行。
 *      thenAccept(): 不会阻塞其他线程，任务执行完成后会自动执行该方法。
 */
public class SupplyAsyncExample {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        // supplyAsync() + get()
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> runTask(5, countDownLatch));
        // task.get() 会阻塞线程执行，只有任务执行完成后才会获取到值
        System.out.println("调用 get() 前的时间: " + new Date());
        System.out.println("Result[get]: " + task.get()); // Result[get]: 5050
        System.out.println("调用 get() 后的时间: " + new Date());

        // supplyAsync() + thenAccept()
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
            return sum;
        });
        // thenAccept() 不会阻塞，任务执行完成后，自动执行该方法
        System.out.println("调用 thenAccept() 前的时间：" + new Date());
        task1.thenAccept(result -> System.out.println("Result[thenAccept]: " + result));
        System.out.println("调用 thenAccept() 后的时间：" + new Date());

        countDownLatch.await();
    }

    /**
     * 子任务
     *
     * @param num 累计到的数值
     * @return Integer
     */
    private static Integer runTask(int num, CountDownLatch countDownLatch) {
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum += i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
        return sum;
    }
}
