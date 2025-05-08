package job_interview.juc.create_thread;

/**
 * @BelongsPackage: job_interview.JUC.create_thread
 * @ClassName: MyThread
 * @Author: 丛虹羽
 * @Date: 2025/5/2 18:39
 * @Description: 继承 Thread 类创建线程
 */
public class MyThreadExample extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("SubThread create thread by extending thread class!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // SubThread
        MyThreadExample thread = new MyThreadExample();
        thread.start();

        // MainThread
        for(int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.err.println("Main thread invoke!");
        }
    }
}
