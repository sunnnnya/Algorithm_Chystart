package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: Multiply
 * @Author: 丛虹羽
 * @Date: 2024/8/11 上午10:50
 * @Description: 递归乘法
 *
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * https://leetcode.cn/problems/recursive-mulitply-lcci
 */
public class Multiply {

    /**
     * 两个数的乘法
     *
     * @param A
     * @param B
     * @return
     */
    public static int multiply(int A, int B) {
        int ans = 0;
        if (A == 0 || B == 0) {
            return ans;
        }
        while (B != 0) {
            if ((B & 1) == 1) {
                ans = add(ans, A);
            }
            A <<= 1;
            B >>>= 1;
        }
        return ans;
    }

    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
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
        System.out.println(multiply(1, 10));
        // 10
    }
}
