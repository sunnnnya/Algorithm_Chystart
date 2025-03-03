package leetcode.skill.xor;

/**
 * @BelongsPackage: leetcode.skill.xor
 * @ClassName: GetSum
 * @Author: 丛虹羽
 * @Date: 2025/3/3 22:05
 * @Description: 两整数之和
 *
 * leetcode: https://leetcode.cn/problems/sum-of-two-integers/
 */
public class GetSum {

    /**
     * 异或表示无进位相加
     *
     * @param a 元素 a
     * @param b 元素 b
     * @return
     */
    public static int getSum(int a, int b) {
        int sum = a;
        while(b != 0) {
            // 无进位相加
            sum = a ^ b;
            // 进位信息
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
        System.out.println(getSum(12, 21));
        // 33
    }
}
