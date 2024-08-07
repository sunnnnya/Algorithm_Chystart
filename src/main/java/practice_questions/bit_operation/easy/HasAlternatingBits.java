package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: HasAlternatingBits
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午5:28
 * @Description: 交替位二进制数
 *
 * leetcode：https://leetcode.cn/problems/binary-number-with-alternating-bits/
 *
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现(格雷码)：换句话说，就是二进制表示中相邻两位的数字永不相同。
 */
public class HasAlternatingBits {

    /**
     *
     *
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {
        int res = n ^ (n >> 1);
        return (res & (res + 1)) == 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        // true

        System.out.println(hasAlternatingBits(7));
        // false

        System.out.println(hasAlternatingBits(11));
        // false
    }
}
