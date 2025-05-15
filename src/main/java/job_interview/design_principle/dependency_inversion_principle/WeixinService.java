package job_interview.design_principle.dependency_inversion_principle;

/**
 * @BelongsPackage: job_interview.design_principle.dependency_inversion_principle
 * @ClassName: WeixinServicce
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:57
 * @Description: 微信发送消息
 */
public class WeixinService implements NotificationService{
    /**
     * 通知消息
     *
     * @param recipient 接收人
     * @param message   发送的消息
     * @return void
     */
    @Override
    public String sendNotification(String recipient, String message) {
        return "【微信发送】发送人：" + recipient + ", 通知消息：" + message;
    }
}
