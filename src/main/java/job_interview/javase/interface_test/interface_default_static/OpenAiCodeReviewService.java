package job_interview.javase.interface_test.interface_default_static;

/**
 * @BelongsPackage: job_interview.javase.interface_test.interface_default_static
 * @ClassName: OpenAiCodeReviewService
 * @Author: 丛虹羽
 * @Date: 2025/6/23 21:43
 * @Description: 可以不用实现 默认方法 只需要实现 抽象方法
 */
public class OpenAiCodeReviewService implements IOpenAiCodeReview {

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 直接就可以调用 默认方法, 如果 一个类实现了多个接口的话，如果多个接口有相同的 默认方法，就需要 重写
        OpenAiCodeReviewService openAiCodeReviewService = new OpenAiCodeReviewService();
        System.out.println("random temperature is -> " + openAiCodeReviewService.getRandomTemperature());

        System.out.println("openai model name is -> " + IOpenAiCodeReview.getOpenAiModelName());
    }
}
