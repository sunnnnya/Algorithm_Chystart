package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: MinBitFlips
 * @Author: 丛虹羽
 * @Date: 2024/8/9 上午9:37
 * @Description: 转换数字的最少位翻转次数
 *
 * 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0。
 * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
 *
 * leetcode： https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/description/
 */
public class MinBitFlips {

    /**
     * 异或操作，获取 bit 位数
     *
     * @param start
     * @param goal
     * @return
     */
    public static int minBitFlips(int start, int goal) {
        int N = start ^ goal;
        int sum = 0;
        while (N != 0) {
            N &= (N - 1);
            ++sum;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        // 3

        System.out.println(minBitFlips(3, 4));
        // 3

        System.out.println(minBitFlips(0, 1));
    }
}
