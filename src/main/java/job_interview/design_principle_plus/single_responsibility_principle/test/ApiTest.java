package job_interview.design_principle_plus.single_responsibility_principle.test;

import job_interview.design_principle_plus.single_responsibility_principle.after.IVideoUserService;
import job_interview.design_principle_plus.single_responsibility_principle.after.impl.GuestVideoService;
import job_interview.design_principle_plus.single_responsibility_principle.after.impl.OrdinaryVideoService;
import job_interview.design_principle_plus.single_responsibility_principle.after.impl.VIPVideoService;
import job_interview.design_principle_plus.single_responsibility_principle.before.VideoUserService;

/**
 * @BelongsPackage: job_interview.design_principle_plus.single_responsibility_principle.test
 * @ClassName: ApiTest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 11:44
 * @Description: 测试类
 */
public class ApiTest {

    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        // 不使用单一职责原则
        VideoUserService videoUserService = new VideoUserService();
        videoUserService.serveGrade("访客用户");
        videoUserService.serveGrade("普通用户");
        videoUserService.serveGrade("VIP用户");

        // 使用单一职责原则
        IVideoUserService guestVideoService = new GuestVideoService();
        guestVideoService.definition();
        guestVideoService.advertisement();

        IVideoUserService ordinaryVideoService = new OrdinaryVideoService();
        ordinaryVideoService.definition();
        ordinaryVideoService.advertisement();

        IVideoUserService vipVideoService = new VIPVideoService();
        vipVideoService.definition();
        vipVideoService.advertisement();
    }
}
