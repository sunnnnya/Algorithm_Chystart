package job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node;

import job_interview.design_pattern_plus.chain_of_responsibility.design_pattern.AbstractLogicNodeHandler;
import job_interview.design_pattern_plus.chain_of_responsibility.design_pattern.AbstractLogicNodeMultiThreadHandler;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_factory.LogicChainFactory;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node
 * @ClassName: LogicNodeOne
 * @Author: 丛虹羽
 * @Date: 2025/7/2 09:56
 * @Description: 责任链中逻辑结点2
 */
public class LogicNodeTwo extends AbstractLogicNodeMultiThreadHandler<String, LogicChainFactory.DynamicContext, String> {

    /**
     * 让每个子节点具备多线程异步处理功能
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     */
    @Override
    protected void multiThread(String requestParameter, LogicChainFactory.DynamicContext dynamicContext) {
        System.out.println("我是 LogicNodeTwo 节点，我具备了异步处理的能力");
    }

    /**
     * 责任链中逻辑结点处理逻辑
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    public String doApply(String requestParameter, LogicChainFactory.DynamicContext dynamicContext) {
        System.out.println("【LogicNodeTwo】请求参数: " + requestParameter + ", 动态上下文: " + dynamicContext.getContent());

        dynamicContext.setContent("我是 LogicNodeTwo 设置进来的内容");

        return next(requestParameter, dynamicContext);
    }
}
