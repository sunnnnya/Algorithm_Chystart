package job_interview.design_pattern_plus.chain_of_responsibility.design_pattern;

/**
 * @BelongsPackage: job_interview.design_pattern_plus.chain_of_responsibility.design_pattern
 * @ClassName: AbstractLogicNodeMultiThreadHandler
 * @Author: 丛虹羽
 * @Date: 2025/7/4 20:50
 * @Description: 承载下载多线程异步处理方法
 */
public abstract class AbstractLogicNodeMultiThreadHandler<T, D, R> extends AbstractLogicNodeHandler<T, D, R> {

    /**
     * 让每个子节点具备多线程异步处理功能
     *
     * @param requestParameter 请求参数
     * @param dynamicContext   动态上下文
     */
    @Override
    protected void multiThread(T requestParameter, D dynamicContext) {

    }
}
