package job_interview.JUC.thread_tool_class;

import java.util.concurrent.CyclicBarrier;

/**
 * @BelongsPackage: job_interview.JUC.thread_tool_class
 * @ClassName: CyclicBarrier
 * @Author: 丛虹羽
 * @Date: 2025/5/2 21:05
 * @Description:
 */
public class CyclicBarrierExample {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // set thread number
        int threadNum = 6;

        // create cyclic barrier instance
        // when cyclic barrier await time is six, after lambda expression will invoke!
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum, () -> {
            System.out.println("所有的线程执行完成咯！");
        });

        // create six thread
        for(int i = 0; i < threadNum; i++) {
            int idx = i;
            new Thread(() -> {
                for(int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(1000);
                        if((idx & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + " invoke!");
                        } else {
                            System.err.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + " invoke!");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Main Thread
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.err.println("Main: " + Thread.currentThread().getName() + " invoke!");
            }).start();
        }
    }
}
