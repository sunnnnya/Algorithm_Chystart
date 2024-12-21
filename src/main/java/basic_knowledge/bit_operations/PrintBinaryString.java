package basic_knowledge.bit_operations;

/**
 * @BelongsPackage: basic_knowledge.bit_operations.easy
 * @ClassName: PrintBinaryString
 * @Author: 丛虹羽
 * @Date: 2024/8/11 下午10:26
 * @Description: 打印一个十进制数对应的二进制字符串信息
 */
public class PrintBinaryString {

    /**
     * 打印十进制的数对应的二进制字符串
     * int 类型 4 个字节，32 bit， 0 ~ 31，右移 31 位就到了最高位了
     *
     * @param number
     */
    public static void printBinStr(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((number & (1 << i))) > 0 ? "1" : "0");
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // Test Case 1
        System.out.print("Test Case 1 (Input: 0): ");
        printBinStr(0); // Expected: 00000000000000000000000000000000

        // Test Case 2
        System.out.print("Test Case 2 (Input: 2147483647): ");
        printBinStr(2147483647); // Expected: 01111111111111111111111111111111

        // Test Case 3
        System.out.print("Test Case 3 (Input: -1): ");
        printBinStr(-1); // Expected: 11111111111111111111111111111111

        // Test Case 4
        System.out.print("Test Case 4 (Input: -920): ");
        printBinStr(-920); // Expected: 11111111111111111111110010011000

        // Test Case 5
        System.out.print("Test Case 5 (Input: -2147483648): ");
        printBinStr(-2147483648); // Expected: 10000000000000000000000000000000
    }
}