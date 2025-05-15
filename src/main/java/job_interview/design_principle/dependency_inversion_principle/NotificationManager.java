package job_interview.design_principle.dependency_inversion_principle;

/**
 * @BelongsPackage: job_interview.design_principle.dependency_inversion_principle
 * @ClassName: NotificationManager
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:58
 * @Description: 发送消息方
 */
public class NotificationManager {

    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public String sendMessage() {
        return notificationService.sendNotification("chystart", "好好学习，天天向上！！");
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        NotificationManager manager1 = new NotificationManager(new EmailService());
        System.out.println(manager1.sendMessage());
        // 【邮箱发送】发送人：chystart, 通知消息：好好学习，天天向上！！

        NotificationManager manager2 = new NotificationManager(new WeixinService());
        System.out.println(manager2.sendMessage());
        // 【微信发送】发送人：chystart, 通知消息：好好学习，天天向上！！
    }
}
