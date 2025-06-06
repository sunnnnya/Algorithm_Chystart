package job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern.structural_pattern.proxy_pattern.dynamic_pattern.cglib_dynamic_pattern
 * @ClassName: AliService
 * @Author: 丛虹羽
 * @Date: 2025/6/6 10:49
 * @Description: cglib 动态代理不需要接口
 */
public class AliSmsService {

    /**
     * 阿里云发送消息服务
     *
     * @param message 消息
     * @return String
     */
    public String sendMessage(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
