package job_interview.design_pattern_plus.rule_tree.rule_tree_test;

import job_interview.design_pattern_plus.rule_tree.design_pattern.IStrategyHandler;import job_interview.design_pattern_plus.rule_tree.rule_tree_factory.RuleTreeStrategyFactory;
import job_interview.design_pattern_plus.rule_tree.rule_tree_node.RootNode;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.rule_tree_test
 * @ClassName: ApiTest
 * @Author: 丛虹羽
 * @Date: 2025/7/4 19:44
 * @Description: 测试类
 */
public class ApiTest {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        RuleTreeStrategyFactory ruleTreeStrategyFactory = new RuleTreeStrategyFactory();
        RootNode rootNode = ruleTreeStrategyFactory.getRootNode();

        String str = "1111";

        try {
            String answer = rootNode.apply(str, new RuleTreeStrategyFactory.DynamicContext());
            System.out.println("answer = " + answer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
