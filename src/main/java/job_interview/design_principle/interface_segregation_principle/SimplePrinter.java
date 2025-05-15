package job_interview.design_principle.interface_segregation_principle;

/**
 * @BelongsPackage: job_interview.design_principle.interface_segregation_principle
 * @ClassName: SimplePrinter
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:50
 * @Description: 简单的只能实现打印功能
 */
public class SimplePrinter implements Printer {

    /**
     * 打印机具有的功能
     *
     * @param content 要打印的内容
     * @return String
     */
    @Override
    public String print(String content) {
        return "实现打印功能";
    }
}
