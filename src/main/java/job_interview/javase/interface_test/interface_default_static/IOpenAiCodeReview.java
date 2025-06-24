package job_interview.javase.interface_test.interface_default_static;

/**
 * @BelongsPackage: job_interview.javase.interface_test.interface_default_static
 * @ClassName: IOpenAiCodeReview
 * @Author: 丛虹羽
 * @Date: 2025/6/23 21:40
 * @Description: 测试 Java8 静态方法 + 默认方法
 */
public interface IOpenAiCodeReview {

    static String getOpenAiModelName() {
        return "Qwen3";
    }

    /**
     * 获取 随机温度
     *
     * @return Double
     */
    default Double getRandomTemperature() {
        return 0.6;
    }
}
