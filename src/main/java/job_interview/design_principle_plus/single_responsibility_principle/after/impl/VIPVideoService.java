package job_interview.design_principle_plus.single_responsibility_principle.after.impl;

import job_interview.design_principle_plus.single_responsibility_principle.after.IVideoUserService;

/**
 * @BelongsPackage: job_interview.design_principle_plus.single_responsibility_principle.after.impl
 * @ClassName: VIPVideoService
 * @Author: 丛虹羽
 * @Date: 2025/7/2 11:40
 * @Description: VIP用户实现逻辑
 * 每个类只有单一职责，只负责自己的业务逻辑
 */
public class VIPVideoService implements IVideoUserService {
    /**
     * 清晰度
     */
    @Override
    public void definition() {
        System.out.println("【VIP用户】-> 播放1080P清晰度");
    }

    /**
     * 广告
     */
    @Override
    public void advertisement() {
        System.out.println("【VIP用户】-> 不播放广告");
    }
}
