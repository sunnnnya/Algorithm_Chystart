package job_interview.java_util_concurrent.thread_tool_class;

import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.JUC.thread_tool_class
 * @ClassName: SemaphoreExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 21:25
 * @Description: Semaphore 工具类的基本使用
 *  可以控制同时访问特定资源的线程数量
 */
public class SemaphoreExample {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int permitCount = 4;

        Semaphore semaphore = new Semaphore(permitCount);

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 获得许可！");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " 释放许可！");
                }
            }, String.format("Thread-[%d]", i)).start();
        }
    }
}
