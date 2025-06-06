package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.jdk_dynamic_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern
 * @ClassName: SmsServiceImpl
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:36
 * @Description: SmsService 的实现类 —— 被代理类
 */
public class SmsServiceImpl implements SmsService{
    /**
     * 发送消息
     *
     * @param message 消息
     * @return String
     */
    @Override
    public String send(String message) {
        System.out.println("SmsService: -> send message:" + message);
        return message;
    }
}
