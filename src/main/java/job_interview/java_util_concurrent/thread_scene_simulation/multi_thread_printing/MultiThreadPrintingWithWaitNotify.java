package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing
 * @ClassName: MultiThreadPrintingWithWaitNotify
 * @Author: 丛虹羽
 * @Date: 2025/7/28 16:47
 * @Description: 使用 wait() 、 notify 进行交替打印
 */
public class MultiThreadPrintingWithWaitNotify {

    private static volatile int count = 1;

    private static int MAX_NUM = 20;

    private static Object lock = new Object();

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while(count <= MAX_NUM) {
                    if((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            synchronized (lock) {
                while(count <= MAX_NUM) {
                    if((count & 1) != 1) {
                        System.out.println(Thread.currentThread().getName() + " print number -> " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "Thread-B").start();
    }
}
