package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: RangeBitwiseAnd
 * @Author: 丛虹羽
 * @Date: 2024/8/14 上午11:42
 * @Description: 数字范围按位与
 *
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * leetcode：https://leetcode.cn/problems/bitwise-and-of-numbers-range
 */
public class RangeBitwiseAnd {

    /**
     * 基本的 按位与 操作，普通的解法直接 timeout
     *
     * @param left
     * @param right
     * @return
     */
    public static int rangeBitwiseAnd1(int left, int right) {
        if (right < left) {
            return -1;
        }
        int ans = left;
        for (int i = left + 1; i <= right; i++) {
            ans &= i;
        }
        return ans;
    }

    /**
     * 技巧解法：利用 Brian Kernighan 算法，消除之后的 0， 进行比较
     * 举例： 12 21
     *   12： 01100
     * & 13： 01101
     * & 14： 01110
     * & 15： 01111
     * & 16： 10000
     * & 17： 10001
     * & 18： 10010
     * & 19： 10011
     * & 20:  10100
     * & 21： 10101
     * 对 21 使用 BK 算法，不断删除末尾的1，直到 小于 12 的时候就找到了最长的前缀
     *
     * @param left
     * @param right
     * @return
     */
    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        // 4

        System.out.println(rangeBitwiseAnd(0, 0));
        // 0

        System.out.println(rangeBitwiseAnd(1, 2147483647));
        // 0
    }
}
