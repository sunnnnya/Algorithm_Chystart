package job_interview.design_pattern_plus.chain_of_responsibility.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.pattern
 * @ClassName: AbstractLogicNodeHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/2 09:50
 * @Description: 抽象类完成遍历拼装逻辑，选择抽象方法进行实现，过滤子类实现逻辑
 */
public abstract class AbstractLogicNodeHandler<T, D, R> implements ILogicNodeHandler<T, D, R> {

    private ILogicNodeHandler<T, D, R> next;

    /**
     * 给当前逻辑节点添加下一个逻辑结点
     *
     * @param next 下一个逻辑结点
     * @return ILogicNodeHandler<T, D, R>
     */
    @Override
    public ILogicNodeHandler<T, D, R> appendNext(ILogicNodeHandler<T, D, R> next) {
        this.next = next;
        return next;
    }

    /**
     * 获取当前逻辑结点的下一个结点
     *
     * @return ILogicNodeHandler<T, D, R>
     */
    @Override
    public ILogicNodeHandler<T, D, R> next() {
        return this.next;
    }

    /**
     * 路由规则
     *
     * @param requestParameter 请求参数
     * @param dynamicContext 动态上下文
     * @return R
     */
    protected R next(T requestParameter, D dynamicContext) {
        return next.apply(requestParameter, dynamicContext);
    }
}
