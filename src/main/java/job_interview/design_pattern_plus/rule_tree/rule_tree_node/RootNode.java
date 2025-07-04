package job_interview.design_pattern_plus.rule_tree.rule_tree_node;

import job_interview.design_pattern_plus.rule_tree.design_pattern.AbstractMultiThreadStrategyRouter;
import job_interview.design_pattern_plus.rule_tree.design_pattern.IStrategyHandler;
import job_interview.design_pattern_plus.rule_tree.rule_tree_factory.RuleTreeStrategyFactory;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree
 * @ClassName: RootNode
 * @Author: 丛虹羽
 * @Date: 2025/7/3 15:04
 * @Description: 根节点
 */
public class RootNode extends AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> {

    private final AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> switchNode;

    public RootNode(AbstractMultiThreadStrategyRouter<String, RuleTreeStrategyFactory.DynamicContext, String> switchNode) {
        this.switchNode = switchNode;
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
        System.out.println("【RootNode】请求参数：" + requestParameter + ", 动态上下文信息：" + dynamicContext);

        if(null == requestParameter) {
            throw new RuntimeException("请求参数为 null，请填写参数！");
        }

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
    public IStrategyHandler<String, RuleTreeStrategyFactory.DynamicContext, String> get(String requestParameter, RuleTreeStrategyFactory.DynamicContext dynamicContext) {
        return switchNode;
    }
}
