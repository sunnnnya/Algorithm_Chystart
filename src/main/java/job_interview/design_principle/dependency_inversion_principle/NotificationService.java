package job_interview.design_principle.dependency_inversion_principle;

/**
 * @BelongsPackage: job_interview.design_principle.dependency_inversion_principle
 * @ClassName: NotificationService
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:53
 * @Description: 通知服务：定义了行为：定义了 发送人 和 发送的消息 内容！！
 */
public interface NotificationService {
    /**
     * 通知消息
     *
     * @param recipient 接收人
     * @param message 发送的消息
     * @return void
     */
    String sendNotification(String recipient, String message);
}