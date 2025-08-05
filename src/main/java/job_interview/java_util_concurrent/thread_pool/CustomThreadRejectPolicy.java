package job_interview.java_util_concurrent.thread_pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_pool
 * @ClassName: CustomThreadRejectPolicy
 * @Author: 丛虹羽
 * @Date: 2025/8/1 17:46
 * @Description: TODO
 */
public class CustomThreadRejectPolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}
