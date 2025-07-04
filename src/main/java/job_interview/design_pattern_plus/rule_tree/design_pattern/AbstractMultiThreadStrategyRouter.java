package job_interview.design_pattern_plus.rule_tree.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.design_pattern
 * @ClassName: AbstractMultiThreadStrategyRouter
 * @Author: 丛虹羽
 * @Date: 2025/7/3 15:13
 * @Description: 并非所有子节点都要承载 多线程方法
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> extends AbstractStrategyRouter<T, D, R> {

    /**
     * 多线程异步执行获取数据方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     */
    @Override
    protected void multiThread(T requestParameter, D dynamicContext) {

    }
}
