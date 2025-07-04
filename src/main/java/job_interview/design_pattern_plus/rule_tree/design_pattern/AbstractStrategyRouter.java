package job_interview.design_pattern_plus.rule_tree.design_pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.design_pattern
 * @ClassName: AbstractStrategyRouter
 * @Author: 丛虹羽
 * @Date: 2025/7/3 15:02
 * @Description: 抽象策略路由
 */
public abstract class AbstractStrategyRouter<T, D, R> implements IStrategyHandler<T, D, R>, IStrategyMapper<T, D, R>{

    @Getter
    @Setter
    protected IStrategyHandler<T, D, R> defaultStrategyHandler = IStrategyHandler.DEFAULT;

    /**
     * 路由方法找到下一个要执行的节点
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    public R router(T requestParameter, D dynamicContext) throws Exception {
        IStrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if(null != strategyHandler) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        }
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

    /**
     * 规则结点的受理方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        multiThread(requestParameter, dynamicContext);
        return doApply(requestParameter, dynamicContext);
    }

    /**
     * 具体执行业务逻辑的方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;

    /**
     * 多线程异步执行获取数据方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     */
    protected abstract void multiThread(T requestParameter, D dynamicContext);
}
