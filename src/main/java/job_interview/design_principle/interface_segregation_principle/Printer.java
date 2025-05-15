package job_interview.design_principle.interface_segregation_principle;

/**
 * @BelongsPackage: job_interview.design_principle.interface_segregation_principle
 * @ClassName: Printer
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:45
 * @Description: 打印机功能
 */
public interface Printer {
    /**
     * 打印机具有的功能
     *
     * @param content 要打印的内容
     * @return String
     */
    String print(String content);
}
