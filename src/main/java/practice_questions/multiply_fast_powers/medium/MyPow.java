package practice_questions.multiply_fast_powers.medium;

/**
 * @BelongsPackage: practice_questions.multiply_fast_powers.medium
 * @ClassName: MyPow
 * @Author: 丛虹羽
 * @Date: 2025/1/9 下午11:38
 * @Description: Pow(x, n)
 *
 * leetcode: https://leetcode.cn/problems/powx-n/description/?envType=study-plan-v2&envId=programming-skills
 */
public class MyPow {

    /**
     * 乘法快速幂（考虑负指数）
     *
     * @param x x ^ n
     * @param n x ^ n
     * @return
     */
    public static double myPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        double mul = 1.0;
        for(; n > 0 ; n >>= 1, x = x * x) {
            if((n & 1) == 1) {
                mul = mul * x;
            }
        }
        return mul;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        // 1024.00000

        double x1 = 2.10000;
        int n1 = 3;
        System.out.println(myPow(x1, n1));
        // 9.261000000000001

        double x2 = 2.00000;
        int n2 = -2;
        System.out.println(myPow(x2, n2));
        // 0.25000
    }
}