package job_interview.java_util_concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_pool
 * @ClassName: ExecutorsThreadPool
 * @Author: 丛虹羽
 * @Date: 2025/8/1 17:41
 * @Description: TODO
 */
public class ExecutorsThreadPool {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        // 1: newCachedThreadPool 适合用来处理大量短期任务
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
