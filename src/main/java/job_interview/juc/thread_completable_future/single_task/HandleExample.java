package job_interview.juc.thread_completable_future.single_task;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @BelongsPackage: job_interview.JUC.thread_completable_future
 * @ClassName: HandleExample
 * @Author: 丛虹羽
 * @Date: 2025/5/4 17:19
 * @Description:
 *  handle(): 当任务处理完成后执行的代码，子任务 和 父任务 使用同一个线程。
 *  handleAsync(): 当任务处理完成后执行的代码，子任务 和 父任务 可能使用同一个线程，也可能不是同一个线程。
 */
public class HandleExample {

    static class CustomException extends Exception {
        public CustomException() {
            super();
        }

        public CustomException(String message) {
            super(message);
        }
    }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        CompletableFuture<String[]> task = CompletableFuture.supplyAsync(() -> {
            // TODO: DO SOMETHING ASYNC
            try {
                Thread.sleep(4000);
                Random random = new Random();
                int randomNumber = random.nextInt(10) + 1;
                // 一般的概率出现异常！
                if(randomNumber >= 5) {
                    throw new CustomException("程序出现了异常！");
                }
                return new String[]{"abc", "edf", "heg"};
            } catch (InterruptedException | CustomException e) {
                throw new RuntimeException(e);
            }
        });

        // handle(): 支持处理异常，同时支持返回值，whenComplete 不支持返回值。
        task.handleAsync((s, e) -> {
            if (e != null) {
                System.out.println("exception: " + e.getMessage());
                return null;
            } else {
                return Arrays.stream(s)
                        .map(String::toUpperCase)
                        .toArray(String[]::new);
            }
        }).thenAccept(r -> {
            System.out.println("处理后的结果：" + Arrays.toString(r));
        }).join();
    }
}
