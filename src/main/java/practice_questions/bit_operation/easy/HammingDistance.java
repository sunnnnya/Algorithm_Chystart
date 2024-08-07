package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: HammingDistance
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午5:38
 * @Description: 汉明距离
 *
 * leetcode: https://leetcode.cn/problems/hamming-distance/description/
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class HammingDistance {

    /**
     * 先使用异或获取不同bit位异或出来的值，然后统计;
     * 0 ^ N = N， N ^ N = 0
     * n & (n - 1)
     *     n = 1001010
     *      &
     * n - 1 = 1001001
     *       = 100100（对比1001010删除了最后的一个1）
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int sum = 0;
        while (z != 0) {
            z &= (z - 1);
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
        System.out.println(hammingDistance(1, 4));
        // 2
        System.out.println(hammingDistance(3, 1));
        // 1
    }
}
