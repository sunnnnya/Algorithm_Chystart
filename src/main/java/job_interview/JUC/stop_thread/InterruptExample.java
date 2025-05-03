package job_interview.JUC.stop_thread;

/**
 * @BelongsPackage: job_interview.JUC.stop_thread
 * @ClassName: InterruptExample
 * @Author: 丛虹羽
 * @Date: 2025/5/3 10:33
 * @Description: 使用线程中断机制
 *      线程 休眠期间 线程被中断，会抛出 InterruptedException 的异常信息，且中断状态会被自动清除。
 *      sleep()、wait()、join()
 */
public class InterruptExample implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Working...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 当阻塞时被中断，抛出异常并清除中断状态
                System.out.println("Interrupted during sleep!");
                // 需要重新设置中断状态，否则，会被清除中断状态，导致程序仍然正常执行
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread terminated by interrupt.");
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // start thread
        InterruptExample task = new InterruptExample();
        Thread thread = new Thread(task);
        thread.start();

        // interrupt thread
        Thread.sleep(2000);
        thread.interrupt();
    }
}
