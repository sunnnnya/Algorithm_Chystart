package job_interview.JUC.thread_completable_future;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: RunAsyncExample
 * @Author: 丛虹羽
 * @Date: 2025/5/4 11:52
 * @Description: runAsync：创建没有返回值的异步任务
 */
public class RunAsyncExample {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> task = CompletableFuture.runAsync(() -> System.out.println("Use runAsync method start an async task!"));
        System.out.println("Result: " + task.get());
        // Result: null
    }
}
