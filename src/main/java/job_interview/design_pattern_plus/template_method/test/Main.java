package job_interview.design_pattern_plus.template_method.test;

import job_interview.design_pattern_plus.template_method.PayOrderMachine;
import job_interview.design_pattern_plus.template_method.port.ActivityPort;
import job_interview.design_pattern_plus.template_method.repositiry.ActivityRepository;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.template_method
 * @ClassName: Main
 * @Author: 丛虹羽
 * @Date: 2025/7/22 21:00
 * @Description: 主测试类
 */
public class Main {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) throws Exception {
        ActivityRepository activityRepository = new ActivityRepository();
        ActivityPort activityPort = new ActivityPort();

        PayOrderMachine payOrderMachine = new PayOrderMachine(activityRepository, activityPort);
        payOrderMachine.exec();
        // 使用模板方法
    }
}
