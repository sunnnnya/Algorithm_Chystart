package job_interview.juc.create_thread.task;

import job_interview.juc.create_thread.po.User;

import java.util.concurrent.Callable;

/**
 * @BelongsPackage: job_interview.juc.create_thread.task
 * @ClassName: PrintUserInfoTask
 * @Author: 丛虹羽
 * @Date: 2025/6/28 16:02
 * @Description: 打印用户信息任务
 */
public class PrintUserInfoTask implements Callable<User> {
    /**
     * 任务实现
     *
     * @return User
     * @throws Exception 异常信息
     */
    @Override
    public User call() throws Exception {
        return User.builder()
                .age(21)
                .userName("chystart")
                .build();
    }
}
