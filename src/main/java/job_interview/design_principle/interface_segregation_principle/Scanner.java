package job_interview.design_principle.interface_segregation_principle;

/**
 * @BelongsPackage: job_interview.design_principle.interface_segregation_principle
 * @ClassName: Scanner
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:46
 * @Description: 扫描功能
 */
public interface Scanner {
    /**
     * 简单的扫描功能
     *
     * @param msg 消息
     */
    void scan(String msg);
}
