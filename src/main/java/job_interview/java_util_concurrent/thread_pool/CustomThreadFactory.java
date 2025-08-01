package job_interview.java_util_concurrent.thread_pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_pool
 * @ClassName: CustomThreadFactory
 * @Author: 丛虹羽
 * @Date: 2025/8/1 17:21
 * @Description: 实现自定义线程工厂
 */
public class CustomThreadFactory implements ThreadFactory {

    // 线程池名称前缀，用于区分不同的线程工厂
    private final String poolName;

    // 线程计数器，用于生成唯一线程名
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    // 是否为守护线程
    private final boolean isDaemon;

    // 线程优先级
    private final int priority;

    // 线程组
    private final ThreadGroup threadGroup;

    // 构造方法，提供基本配置
    public CustomThreadFactory(String poolName) {
        this(poolName, false, Thread.NORM_PRIORITY);
    }

    public CustomThreadFactory(String poolName, boolean isDaemon, int priority) {
        this.poolName = poolName;
        this.isDaemon = isDaemon;

        // 校验优先级范围（1-10）
        if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
            throw new IllegalArgumentException("线程优先级必须在1-10之间: " + priority);
        }
        this.priority = priority;

        // 获取当前线程组
        SecurityManager s = System.getSecurityManager();
        this.threadGroup = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        // 生成线程名称：前缀 + 序号
        String threadName = poolName + "-thread-" + threadNumber.getAndIncrement();

        // 创建线程
        Thread thread = new Thread(threadGroup, r, threadName) {
            // 可以重写run方法添加额外逻辑，如日志记录
            @Override
            public void run() {
                try {
                    super.run();
                } catch (Throwable t) {
                    // 处理线程中未捕获的异常
                    System.err.println("线程 " + getName() + " 发生未捕获异常: " + t.getMessage());
                    t.printStackTrace();
                }
            }
        };

        // 设置守护线程属性
        thread.setDaemon(isDaemon);

        // 设置线程优先级
        thread.setPriority(priority);

        // 设置未捕获异常处理器（可选）
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.err.println("线程 " + t.getName() + " 发生未捕获异常: " + e.getMessage());
            e.printStackTrace();
        });

        return thread;
    }
}
