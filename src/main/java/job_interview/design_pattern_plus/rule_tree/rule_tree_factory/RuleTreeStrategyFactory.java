package job_interview.design_pattern_plus.rule_tree.rule_tree_factory;

import job_interview.design_pattern_plus.rule_tree.design_pattern.IStrategyHandler;import job_interview.design_pattern_plus.rule_tree.rule_tree_node.EndNode;
import job_interview.design_pattern_plus.rule_tree.rule_tree_node.MarketNode;
import job_interview.design_pattern_plus.rule_tree.rule_tree_node.RootNode;
import job_interview.design_pattern_plus.rule_tree.rule_tree_node.SwitchNode;
import lombok.*;

import java.math.BigDecimal;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.rule_tree_factory
 * @ClassName: RuleTreeStrategyFactory
 * @Author: 丛虹羽
 * @Date: 2025/7/3 15:15
 * @Description: 规则树策略工厂
 */
@Getter
public class RuleTreeStrategyFactory {

    private final RootNode rootNode;

    public RuleTreeStrategyFactory() {
        EndNode endNode = new EndNode();
        MarketNode marketNode = new MarketNode(endNode);
        SwitchNode switchNode = new SwitchNode(marketNode);
        rootNode = new RootNode(switchNode);
    }

    public RootNode getRootNode() {
        return rootNode;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DynamicContext {
        /** 内容信息 */
        private String content;
        /** 返回的结果 */
        private BigDecimal result;
    }
}
