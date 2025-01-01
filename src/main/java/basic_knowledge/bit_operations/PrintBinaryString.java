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
     * 固定位数的打印十进制对应的二进制信息
     *
     * @param number 十进制数
     */
    public static void printBinaryString(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for(; number > 0; number >>= 1) {
            stringBuilder.insert(0, number & 1);
        }
        if(stringBuilder.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(stringBuilder.toString());
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-------------------Testing printBinStr:-------------------");
        System.out.print("Number: 0 -> ");
        printBinStr(0); // 输出: 00000000000000000000000000000000

        System.out.print("Number: 1 -> ");
        printBinStr(1); // 输出: 00000000000000000000000000000001

        System.out.print("Number: 2 -> ");
        printBinStr(2); // 输出: 00000000000000000000000000000010

        System.out.print("Number: 10 -> ");
        printBinStr(10); // 输出: 00000000000000000000000000001010

        System.out.print("Number: 31 -> ");
        printBinStr(31); // 输出: 00000000000000000000000000011111

        System.out.print("Number: 255 -> ");
        printBinStr(255); // 输出: 00000000000000000000000011111111

        System.out.print("Number: 256 -> ");
        printBinStr(256); // 输出: 00000000000000000000000100000000

        System.out.print("Number: -1 -> ");
        printBinStr(-1); // 输出: 11111111111111111111111111111111

        System.out.print("Number: -10 -> ");
        printBinStr(-10); // 输出: 11111111111111111111111111110110

        System.out.print("Number: Integer.MAX_VALUE -> ");
        printBinStr(Integer.MAX_VALUE); // 输出: 01111111111111111111111111111111

        System.out.print("Number: Integer.MIN_VALUE -> ");
        printBinStr(Integer.MIN_VALUE); // 输出: 10000000000000000000000000000000

        System.out.println("--------------Testing printBinaryString:--------------");
        System.out.print("Number: 0 -> ");
        printBinaryString(0); // 输出: 0

        System.out.print("Number: 1 -> ");
        printBinaryString(1); // 输出: 1

        System.out.print("Number: 2 -> ");
        printBinaryString(2); // 输出: 10

        System.out.print("Number: 10 -> ");
        printBinaryString(10); // 输出: 1010

        System.out.print("Number: 31 -> ");
        printBinaryString(31); // 输出: 11111

        System.out.print("Number: 255 -> ");
        printBinaryString(255); // 输出: 11111111

        System.out.print("Number: 256 -> ");
        printBinaryString(256); // 输出: 100000000

        System.out.print("Number: -1 -> ");
        printBinaryString(-1); // 输出: (打印逻辑可能不明确)

        System.out.print("Number: -10 -> ");
        printBinaryString(-10); // 输出: (打印逻辑可能不明确)

        System.out.print("Number: Integer.MAX_VALUE -> ");
        printBinaryString(Integer.MAX_VALUE); // 输出: 1111111111111111111111111111111

        System.out.print("Number: Integer.MIN_VALUE -> ");
        printBinaryString(Integer.MIN_VALUE); // 输出: (打印逻辑可能不明确)
    }
}