package job_interview.design_pattern_plus.chain_of_responsibility.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.pattern
 * @ClassName: ILogicNodeHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/1 22:56
 * @Description: 责任链中结点处理逻辑
 */
public interface ILogicNodeHandler<T, D, R> extends ILogicLinkOperation<T, D, R> {

    /**
     * 责任链中逻辑结点处理逻辑
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     * @return R
     */
    R apply(T requestParameter, D dynamicContext);
}
