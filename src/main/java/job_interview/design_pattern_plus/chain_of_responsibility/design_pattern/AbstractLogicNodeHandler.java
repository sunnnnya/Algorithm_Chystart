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

    /**
     * 责任链中逻辑结点处理逻辑
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    public R apply(T requestParameter, D dynamicContext) {
        multiThread(requestParameter, dynamicContext);
        return doApply(requestParameter, dynamicContext);
    }

    /**
     * 真正的受理方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext 动态上下文
     * @return R
     */
    protected abstract R doApply(T requestParameter, D dynamicContext);

    /**
     * 让每个子节点具备多线程异步处理功能
     *
     * @param requestParameter 请求参数
     * @param dynamicContext 动态上下文
     */
    protected abstract void multiThread(T requestParameter, D dynamicContext);
}
