package job_interview.design_pattern_plus.rule_tree.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.rule_tree.design_pattern
 * @ClassName: IStrategyHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/3 14:58
 * @Description: 规则处理器 - 具有受理方法
 */
@FunctionalInterface
public interface IStrategyHandler<T, D, R> {

    IStrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 规则结点的受理方法
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    R apply(T requestParameter, D dynamicContext) throws Exception;
}
