package basic_knowledge.bit_operations.easy;

/**
 * @BelongsPackage: basic_knowledge.bit_operations.easy
 * @ClassName: PrintBinaryString
 * @Author: 丛虹羽
 * @Date: 2024/8/11 下午10:26
 * @Description: 打印一个十进制数对应的二进制字符串信息
 */
public class PrintBinaryString {

    /**
     * 打印字符串信息
     * 重点信息：n & 1来获取最后一位的进制位信息
     *
     * @param number
     * @return
     */
    public static String printBinaryString(int number) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; number > 0; number >>= 1, i++) {
            stringBuffer.append((number & 1) == 0 ? "0" : "1");
        }
        return stringBuffer.reverse().toString();
    }

    /**
     * 打印十进制的数对应的二进制字符串
     *
     * @param number
     */
    public static void printBinStr(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((number & (1 << i))) > 0 ? "1" : "0");
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int number = 21;
        System.out.println(printBinaryString(number));
        // 10101

        printBinStr(920);
        // 00000000000000000000001110011000
    }
}
