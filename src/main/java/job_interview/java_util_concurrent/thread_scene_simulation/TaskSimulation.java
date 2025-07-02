package job_interview.java_util_concurrent.thread_scene_simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsPackage: job_interview.JUC.thread_scene_simulation
 * @ClassName: TaskSimulation
 * @Author: 丛虹羽
 * @Date: 2025/5/4 10:59
 * @Description: 多任务模拟
 *  任务 T 由 N 个子任务构成，每个子任务完成的时长不同。
 *  若其中有一个子任务失败，所有任务立即结束，整个任务 T 标记为失败。
 *      请编写程序模拟这一过程。
 *
 *  分析过程：因为子任务要返回给主任务状态，所以继承 Thread 类 和 实现 Runnable 接口的方式不可取，使用 Callable 接口
 */
public class TaskSimulation {
    private static final Random RANDOM = new Random();

    private static final int SUB_TASK_COUNT = 5;

    private static final List<CompletableFuture<Boolean>> subTasks = new ArrayList<>();

    public static void main(String[] args) {
        // 创建并启动所有子任务
        for(int i = 0; i < SUB_TASK_COUNT; i++) {
            int taskId = i;
            CompletableFuture<Boolean> task = CompletableFuture.supplyAsync(() -> runTask(taskId));
            subTasks.add(task);
        }

        // 组合所有子任务（allOf 等待所有完成）
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(subTasks.toArray(new CompletableFuture[0]));

        // 处理最终结果
        allTasks = allTasks.exceptionally(ex -> {
            System.out.println("任务 T 因子任务异常终止: " + ex.getCause().getMessage());
            cancelOtherTasks(Thread.currentThread().getId()); // 取消其他任务
            return null;
        });

        try {
            allTasks.get(5, TimeUnit.SECONDS); // 最多等待5秒（防止无限阻塞）
            // 检查是否有子任务失败（通过异常或结果判断）
            if (subTasks.stream().anyMatch(CompletableFuture::isCompletedExceptionally)) {
                System.out.println("任务 T 失败");
            } else {
                System.out.println("任务 T 成功");
            }
        } catch (Exception e) {
            System.out.println("任务 T 超时或异常: " + e.getMessage());
        }
    }

    /**
     * 启动子任务
     *
     * @param taskId 任务 id
     * @return Boolean
     */
    private static Boolean runTask(int taskId) {
        int duration = RANDOM.nextInt(2000) + 1000;
        long endTime = System.currentTimeMillis() + duration;
        System.out.println("子任务 " + taskId + " 启动，预计执行 " + duration + "ms");
        try {
            while (System.currentTimeMillis() < endTime) {
                Thread.sleep(100); // 每100ms检查一次状态
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("子任务 " + taskId + " 被中断，终止执行");
                    return false;
                }
            }
            boolean isSuccess = RANDOM.nextDouble() > 0.2;
            if (!isSuccess) {
                throw new RuntimeException("子任务 " + taskId + " 执行失败（模拟异常）");
            }
            System.out.println("子任务 " + taskId + " 成功完成");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
            System.out.println("子任务 " + taskId + " 执行过程中被中断");
            return false;
        } catch (Exception e) {
            // 捕获自定义异常并传播
            CompletableFuture<Boolean> failedTask = subTasks.get(taskId);
            failedTask.completeExceptionally(e); // 触发 allOf 的异常处理
            cancelOtherTasks(taskId); // 取消其他任务
            return false;
        }
    }

    /**
     * 取消其他未完成的子任务
     *
     * @param failedTaskId 失败任务 id
     */
    private static void cancelOtherTasks(long failedTaskId) {
        subTasks.forEach(task -> {
            if (!task.isDone()) {
                task.cancel(true); // 传递中断信号
            }
        });
        System.out.println("子任务 " + failedTaskId + " 失败，已取消其他子任务");
    }
}
