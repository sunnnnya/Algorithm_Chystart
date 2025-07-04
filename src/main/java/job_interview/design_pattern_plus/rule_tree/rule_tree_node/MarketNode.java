package job_interview.design_pattern_plus.rule_tree.rule_tree_node;

import job_interview.design_pattern_plus.rule_tree.design_pattern.AbstractMultiThreadStrategyRouter;
import job_interview.design_pattern_plus.rule_tree.design_pattern.IStrategyHandler;
import job_interview.design_pattern_plus.rule_tree.rule_tree_factory.RuleTreeStrategyFactory;

import java.math.BigDecimal;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.rule_tree_node
 * @ClassName: MarketNode
 * @Author: 丛虹羽
 * @Date: 2025/7/3 15:43
 * @Description: 营销节点
 */
public class MarketNode extends AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> {

    private final AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> endNode;

    public MarketNode(AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> endNode) {
        this.endNode = endNode;
    }

    /**
     * 具体执行业务逻辑的方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    protected String doApply(String requestParameter, RuleTreeStrategyFactory.DynamicContext dynamicContext) throws Exception {
        System.out.println("【MarkNode】请求参数：" + requestParameter + ", 动态上下文信息：" + dynamicContext);

        dynamicContext.setResult(new BigDecimal("12.0"));

        return router(requestParameter, dynamicContext);
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
        return endNode;
    }
}
