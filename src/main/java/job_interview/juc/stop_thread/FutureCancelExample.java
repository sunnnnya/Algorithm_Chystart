package job_interview.juc.stop_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @BelongsPackage: job_interview.JUC.stop_thread
 * @ClassName: FutureCancelExample
 * @Author: 丛虹羽
 * @Date: 2025/5/3 11:05
 * @Description: 通过 Future 取消任务
 */
public class FutureCancelExample {
    public static void main(String[] args) {
        // thread pool submit task
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Task running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Task interrupted.");
                    Thread.currentThread().interrupt();
                }
            }
        });

        // interrupt future thread
        try {
            Thread.sleep(3000);
            future.cancel(true); // 表示尝试中断任务线程
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
