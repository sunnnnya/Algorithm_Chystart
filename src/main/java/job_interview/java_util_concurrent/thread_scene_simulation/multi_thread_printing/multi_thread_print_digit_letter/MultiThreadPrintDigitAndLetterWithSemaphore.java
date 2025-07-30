package job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_digit_letter;

import java.util.concurrent.Semaphore;

/**
 * @BelongsPackage: job_interview.java_util_concurrent.thread_scene_simulation.multi_thread_printing.multi_thread_print_digit_letter
 * @ClassName: MultiThreadPrintDigitAndLetterWithSemaphore
 * @Author: 丛虹羽
 * @Date: 2025/7/30 12:00
 * @Description: 使用 Semaphore 信号量的方式实现，两个线程交替打印 1A2B3C...
 */
public class MultiThreadPrintDigitAndLetterWithSemaphore {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        new Thread(() -> {
            for(int i = 1; i <= 26; i++) {
                try {
                    semaphore1.acquire();
                    System.out.print(i);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-digit").start();

        new Thread(() -> {
            for(int i = 0; i < 26; i++) {
                try {
                    semaphore2.acquire();
                    System.out.print((char)('A' + i));
                    semaphore1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Thread-letter").start();
    }
}
