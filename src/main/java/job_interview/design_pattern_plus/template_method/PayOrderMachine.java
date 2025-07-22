package job_interview.design_pattern_plus.template_method;

import job_interview.design_pattern_plus.template_method.port.ActivityPort;
import job_interview.design_pattern_plus.template_method.repositiry.ActivityRepository;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.template_method
 * @ClassName: PayOrderMachine
 * @Author: 丛虹羽
 * @Date: 2025/7/22 20:59
 * @Description: 具体的实现类 - 抽象类做承载，子类只实现不要的细节处理
 */
public class PayOrderMachine extends AbstratcMachine {

    public PayOrderMachine(ActivityRepository activityRepository, ActivityPort activityPort) {
        super(activityRepository, activityPort);
    }

    @Override
    protected void doMysql() throws Exception {
        System.out.println(activityPort.getActivity());
    }

    @Override
    protected void doRedis() throws Exception {
        System.out.println(activityRepository.getActivity());
    }
}
