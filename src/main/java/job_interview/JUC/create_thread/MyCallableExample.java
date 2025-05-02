package job_interview.JUC.create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @BelongsPackage: job_interview.JUC.create_thread
 * @ClassName: MyCallableExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 20:47
 * @Description: 实现 Callable 接口创建线程
 */
public class MyCallableExample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            sum += i;
            System.out.println("Callable thread run right way!");
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // create thread class
        MyCallableExample myCallable = new MyCallableExample();
        // create future task
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        // start thread
        new Thread(task).start();

        // 会阻塞线程的执行！FutureTask
        System.out.println(task.get());

        // MainThread
        for(int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.err.println("Main thread invoke!");
        }
    }
}
