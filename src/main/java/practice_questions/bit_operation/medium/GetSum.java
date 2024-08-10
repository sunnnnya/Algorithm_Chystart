package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.middle
 * @ClassName: GetSum
 * @Author: 丛虹羽
 * @Date: 2024/8/10 下午11:31
 * @Description: 两整数之和
 *
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 *
 * leetcode：https://leetcode.cn/problems/sum-of-two-integers/description/
 */
public class GetSum {

    /**
     * 理解a ^ b的结果是无进位相加，(a & b) << 1的结果是进位信息
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = ((a & b) << 1);
            a = sum;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        // 3

        System.out.println(getSum(2, -1));
        // 1
    }
}
