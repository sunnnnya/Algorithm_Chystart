package job_interview.juc.stop_thread;

/**
 * @BelongsPackage: job_interview.JUC.stop_thread
 * @ClassName: SafeStopWithFlagExample
 * @Author: 丛虹羽
 * @Date: 2025/5/3 10:24
 * @Description: 通过共享标志位主动终止
 */
public class SafeStopWithFlagExample implements Runnable{

    private volatile boolean flag = true;

    @Override
    public void run() {
        while(flag) {
            System.out.println(Thread.currentThread().getName() + " is running ~");
        }
        System.out.println(Thread.currentThread().getName() + " has been finished right way!");
    }

    // change flag variable
    public void stop() {
        this.flag = false;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // start sub thread
        SafeStopWithFlagExample task = new SafeStopWithFlagExample();
        Thread thread = new Thread(task, "thread-A");
        thread.start();

        // start main thread
        Thread.sleep(5000);
        task.stop();
        System.out.println(Thread.currentThread().getName() + " has been finished!");
    }
}
