package job_interview.design_pattern_plus.chain_of_responsibility.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.pattern
 * @ClassName: ILogicOperation
 * @Author: 丛虹羽
 * @Date: 2025/7/1 22:55
 * @Description: 责任链的装配者
 */
public interface ILogicLinkOperation<T, D, R> {

    /**
     * 获取当前逻辑结点的下一个结点
     *
     * @return ILogicNodeHandler<T, D, R>
     */
    ILogicNodeHandler<T, D, R> next();

    /**
     * 给当前逻辑节点添加下一个逻辑结点
     *
     * @param next 下一个逻辑结点
     * @return ILogicNodeHandler<T, D, R>
     */
    ILogicNodeHandler<T, D, R> appendNext(ILogicNodeHandler<T, D, R> next);
}
