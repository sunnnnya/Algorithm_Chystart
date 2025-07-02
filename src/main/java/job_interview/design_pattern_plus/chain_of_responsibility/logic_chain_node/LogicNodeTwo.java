package job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node;

import job_interview.design_pattern_plus.chain_of_responsibility.design_pattern.AbstractLogicNodeHandler;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_factory.LogicChainFactory;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node
 * @ClassName: LogicNodeOne
 * @Author: 丛虹羽
 * @Date: 2025/7/2 09:56
 * @Description: 责任链中逻辑结点2
 */
public class LogicNodeTwo extends AbstractLogicNodeHandler<String, LogicChainFactory.DynamicContext, String> {

    /**
     * 责任链中逻辑结点处理逻辑
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    public String apply(String requestParameter, LogicChainFactory.DynamicContext dynamicContext) {
        System.err.println("【LogicNodeTwo】请求参数: " + requestParameter + ", 动态上下文: " + dynamicContext.getContent());

        dynamicContext.setContent("我是 LogicNodeTwo 设置进来的内容");

        return next(requestParameter, dynamicContext);
    }
}
