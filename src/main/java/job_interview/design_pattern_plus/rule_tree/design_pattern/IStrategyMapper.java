package job_interview.design_pattern_plus.rule_tree.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.design_pattern
 * @ClassName: IStrategyHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/3 14:58
 * @Description: 规则映射器 - 具有受理方法
 */
@FunctionalInterface
public interface IStrategyMapper<T, D, R> {

    /**
     * 根据 请求参数 和 动态上下文信息 获取到对应的规则处理器
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return IStrategyHandler<T, D, R>
     */
    IStrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;
}
