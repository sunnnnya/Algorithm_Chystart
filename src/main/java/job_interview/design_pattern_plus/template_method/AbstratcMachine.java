package job_interview.design_pattern_plus.template_method;

import job_interview.design_pattern_plus.template_method.port.ActivityPort;
import job_interview.design_pattern_plus.template_method.repositiry.ActivityRepository;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.template_method
 * @ClassName: BridgeMachine
 * @Author: 丛虹羽
 * @Date: 2025/7/22 20:53
 * @Description:
 */
public abstract class AbstratcMachine implements Machine {

    protected final ActivityRepository activityRepository;

    protected final ActivityPort activityPort;

    public AbstratcMachine(ActivityRepository activityRepository, ActivityPort activityPort) {
        this.activityRepository = activityRepository;
        this.activityPort = activityPort;
    }

    /**
     * 指定方法
     *
     * @throws Exception 异常
     */
    @Override
    public void exec() throws Exception {
        System.out.println("do something with repository!");
        doMysql();
        doRedis();
    }

    protected abstract void doMysql() throws Exception;

    protected abstract void doRedis() throws Exception;
}
