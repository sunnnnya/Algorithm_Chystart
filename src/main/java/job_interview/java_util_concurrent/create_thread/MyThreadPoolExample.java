package job_interview.java_util_concurrent.create_thread;

import job_interview.java_util_concurrent.create_thread.po.User;
import job_interview.java_util_concurrent.create_thread.task.PrintUserInfoTask;

import java.util.concurrent.*;

/**
 * @BelongsPackage: job_interview.JUC.create_thread
 * @ClassName: MyThreadPoolExample
 * @Author: 丛虹羽
 * @Date: 2025/5/2 21:01
 * @Description: 使用线程池启动多线程
 */
public class MyThreadPoolExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        FutureTask<User> futureTask = new FutureTask<>(new PrintUserInfoTask());

        threadPool.execute(futureTask);

        User user = futureTask.get();
        System.out.println("user = " + user);
        // user = User(userName=chystart, age=21)
    }
}
