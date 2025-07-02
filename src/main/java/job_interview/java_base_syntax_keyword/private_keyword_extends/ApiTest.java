package job_interview.java_base_syntax_keyword.private_keyword_extends;

/**
 * @BelongsPackage: job_interview.java_base_syntax_keyword.private_keyword_extends
 * @ClassName: ApiTest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 14:33
 * @Description: 测试类
 */
public class ApiTest {

    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        SpecificationStrategyHandler specificationStrategyHandler = new SpecificationStrategyHandler();
        specificationStrategyHandler.setValue("123");
        System.out.println(specificationStrategyHandler.getValue());
    }
}
