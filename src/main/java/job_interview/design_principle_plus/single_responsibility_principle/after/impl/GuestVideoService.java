package job_interview.design_principle_plus.single_responsibility_principle.after.impl;

import job_interview.design_principle_plus.single_responsibility_principle.after.IVideoUserService;

/**
 * @BelongsPackage: job_interview.design_principle_plus.single_responsibility_principle.after.impl
 * @ClassName: Guest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 11:36
 * @Description: 普通访客实现逻辑
 * guest: 访客
 */
public class GuestVideoService implements IVideoUserService {
    /**
     * 清晰度
     */
    @Override
    public void definition() {
        System.out.println("【访客用户】-> 播放480P清晰度");
    }

    /**
     * 广告
     */
    @Override
    public void advertisement() {
        System.out.println("【访客用户】-> 播放100秒广告");
    }
}
