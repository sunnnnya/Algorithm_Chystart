package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: mnChanges
 * @Author: 丛虹羽
 * @Date: 2024/8/8 下午2:57
 * @Description: 使两个整数相等的位更改次数
 *
 * 给你两个正整数 n 和 k。
 * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
 * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
 *
 * leetcode: https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/
 *
 */
public class MinChanges {

    /**
     * 思考：题目要求是n从1变成0，是否等于 k，故 k 是 n 的子集，所以 n & k != k说明根本变不到
     *
     * @param n
     * @param k
     * @return
     */
    public static int minChanges(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minChanges(13, 4));
        // 2

        System.out.println(minChanges(12, 12));
        // 0

        System.out.println(minChanges(14, 13));
        // -1

        System.out.println(minChanges(52, 14));
        // -1

        System.out.println(minChanges(44, 4));
        // 2
    }
}
