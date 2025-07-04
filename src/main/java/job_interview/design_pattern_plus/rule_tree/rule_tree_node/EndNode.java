package job_interview.design_pattern_plus.rule_tree.rule_tree_node;

import job_interview.design_pattern_plus.rule_tree.design_pattern.AbstractMultiThreadStrategyRouter;
import job_interview.design_pattern_plus.rule_tree.design_pattern.IStrategyHandler;
import job_interview.design_pattern_plus.rule_tree.rule_tree_factory.RuleTreeStrategyFactory;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.rule_tree_node
 * @ClassName: EndNode
 * @Author: 丛虹羽
 * @Date: 2025/7/4 19:39
 * @Description: 终止节点
 */
public class EndNode extends AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> {

    /**
     * 具体执行业务逻辑的方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    protected String doApply(String requestParameter, RuleTreeStrategyFactory.DynamicContext dynamicContext) throws Exception {
        System.out.println("【EndNode】请求参数：" + requestParameter + ", 动态上下文信息：" + dynamicContext);

        return "Hello, Bug!";
    }

    /**
     * 根据 请求参数 和 动态上下文信息 获取到对应的规则处理器
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return IStrategyHandler<T, D, R>
     */
    @Override
    public IStrategyHandler<String, RuleTreeStrategyFactory.DynamicContext, String> get(String requestParameter, RuleTreeStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }
}
