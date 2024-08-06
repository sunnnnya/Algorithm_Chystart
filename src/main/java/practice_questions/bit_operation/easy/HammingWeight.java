package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: HammingWeight
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午9:14
 * @Description: 位1的个数
 *
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。
 *
 * leetcode: https://leetcode.cn/problems/number-of-1-bits/description/
 */
public class HammingWeight {

    /**
     * 明翰距离返回一个int类型的整数中的，有多少个bit位上为1
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                ++sum;
            }
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }
}
