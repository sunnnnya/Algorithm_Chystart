package job_interview.design_principle_plus.single_responsibility_principle.after.impl;

import job_interview.design_principle_plus.single_responsibility_principle.after.IVideoUserService;

/**
 * @BelongsPackage: job_interview.design_principle_plus.single_responsibility_principle.after.impl
 * @ClassName: OrdinaryVideoService
 * @Author: 丛虹羽
 * @Date: 2025/7/2 11:37
 * @Description: 普通用户实现逻辑
 * ordinary: 普通
 */
public class OrdinaryVideoService implements IVideoUserService {
    /**
     * 清晰度
     */
    @Override
    public void definition() {
        System.out.println("【普通用户】-> 播放720P清晰度");
    }

    /**
     * 广告
     */
    @Override
    public void advertisement() {
        System.out.println("【普通用户】-> 播放30秒广告");
    }
}
