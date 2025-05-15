package job_interview.design_principle.interface_segregation_principle;

/**
 * @BelongsPackage: job_interview.design_principle.interface_segregation_principle
 * @ClassName: MultiFunctionPrinter
 * @Author: 丛虹羽
 * @Date: 2025/5/15 21:51
 * @Description: 复杂功能的打印机
 */
public class MultiFunctionPrinter implements Printer, Scanner {

    /**
     * 打印机具有的功能
     *
     * @param content 要打印的内容
     * @return String
     */
    @Override
    public String print(String content) {
        return "我既实现了打印功能！";
    }

    /**
     * 简单的扫描功能
     *
     * @param msg 消息
     */
    @Override
    public void scan(String msg) {
        // TODO: 我也实现了扫描的功能
    }
}
