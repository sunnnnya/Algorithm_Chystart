package job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_test;

import job_interview.design_pattern_plus.chain_of_responsibility.design_pattern.ILogicNodeHandler;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_factory.LogicChainFactory;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node.LogicNodeOne;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node.LogicNodeThree;
import job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_node.LogicNodeTwo;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.logic_chain_test
 * @ClassName: LogicChainTest
 * @Author: 丛虹羽
 * @Date: 2025/7/2 10:05
 * @Description: 逻辑测试
 */
public class LogicChainTest {

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        LogicNodeOne logicNodeOne = new LogicNodeOne();
        LogicNodeTwo logicNodeTwo = new LogicNodeTwo();
        LogicNodeThree logicNodeThree = new LogicNodeThree();
        LogicChainFactory logicChainFactory = new LogicChainFactory(logicNodeOne, logicNodeTwo, logicNodeThree);

        ILogicNodeHandler<String, LogicChainFactory.DynamicContext, String> headLogicNode = logicChainFactory.getHeadLogicNode();

        String requestParameter = "Hello,";
        String response = headLogicNode.apply(requestParameter, new LogicChainFactory.DynamicContext());
        System.out.println("response = " + response);
    }
}
