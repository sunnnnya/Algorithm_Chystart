package job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_factory;

import job_interview.design_pattern_plus.chain_of_responsibility.design_pattern.ILogicNodeHandler;
import lombok.*;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_factory
 * @ClassName: LogicChainFactory
 * @Author: 丛虹羽
 * @Date: 2025/7/2 09:58
 * @Description: 责任链工厂
 */
public class LogicChainFactory {

    private final ILogicNodeHandler<String, LogicChainFactory.DynamicContext, String> node1;

    private final ILogicNodeHandler<String, LogicChainFactory.DynamicContext, String> node2;

    private final ILogicNodeHandler<String, LogicChainFactory.DynamicContext, String> node3;

    public LogicChainFactory(ILogicNodeHandler<String, DynamicContext, String> node1, ILogicNodeHandler<String, DynamicContext, String> node2, ILogicNodeHandler<String, DynamicContext, String> node3) {
        this.node1 = node1;
        this.node2 = node2;
        this.node3 = node3;
    }

    public ILogicNodeHandler<String, LogicChainFactory.DynamicContext, String> getHeadLogicNode() {
        node1.appendNext(node2).appendNext(node3);
        return node1;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DynamicContext {
        private String content;
    }
}
