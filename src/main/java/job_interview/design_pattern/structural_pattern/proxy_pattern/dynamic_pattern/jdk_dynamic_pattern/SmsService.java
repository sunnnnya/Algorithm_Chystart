package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.jdk_dynamic_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern
 * @ClassName: SmsService
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:35
 * @Description: 定义接口
 */
public interface SmsService {

    /**
     * 发送消息
     *
     * @param message 消息
     * @return String
     */
    String send(String message);
}