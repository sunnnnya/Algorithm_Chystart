package job_interview.design_principle_plus.single_responsibility_principle.before;

/**
 * @BelongsPackage: job_interview.design_principle_plus.single_responsibility_principle.before
 * @ClassName: VideoUserService
 * @Author: 丛虹羽
 * @Date: 2025/7/2 11:27
 * @Description: 视频用户服务
 */
public class VideoUserService {

    /**
     * 通过 userType 进行判断
     *
     * @param userType 用户类型
     */
    public void serveGrade(String userType) {
        if("访客用户".equals(userType)) {
            System.out.println("【访客用户】视频480P高清");
        } else if("普通用户".equals(userType)) {
            System.out.println("【普通用户】视频720P高清");
        } else if("VIP用户".equals(userType)) {
            System.out.println("【VIP用户】视频1080P高清");
        }
    }
}
