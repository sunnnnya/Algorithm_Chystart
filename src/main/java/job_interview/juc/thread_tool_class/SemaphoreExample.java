package job_interview.juc.thread_tool_class;

import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.JUC.thread_tool_class
 * @ClassName: SemaphoreExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 21:25
 * @Description: Semaphore 工具类的基本使用
 */
public class SemaphoreExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // create four licence
        int permitCount = 4;
        // create four Semaphore
        Semaphore semaphore = new Semaphore(permitCount);
        // create ten threads
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // consume one licence
                    // has available licence -> invoke
                    // no  available licence -> block
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 获得许可！");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " 释放许可！");
                }
            }).start();
        }

        /**
         * System.out.println的输出顺序并不能反映线程的实际执行顺序
         */
    }
}
