package job_interview.java_util_concurrent.thread_tool_class;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @BelongsPackage: job_interview.JUC.thread_tool_class
 * @ClassName: CyclicBarrier
 * @Author: 丛虹羽
 * @Date: 2025/5/2 21:05
 * @Description: CyclicBarrier 工具类 (创建线程直接之后，一定要调用 start() 方法)
 *  它允许一组线程相互等待，直到所有线程都到达某个公共屏障点，再执行后续的业务逻辑
 */
public class CyclicBarrierExample {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int threadNumber = 6;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNumber, () -> {
            System.out.println("当前所有的线程都执行结束了！可以开始之后后续的业务逻辑了！");
        });

        for(int i = 0; i < threadNumber; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始执行！");
                try {
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "开始恢复执行了！");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, "TaskThread-" + i).start();
        }
    }
}
