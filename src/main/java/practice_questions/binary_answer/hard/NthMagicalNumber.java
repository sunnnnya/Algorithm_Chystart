package practice_questions.binary_answer.hard;

/**
 * @BelongsPackage: practice_questions.binary_answer.hard
 * @ClassName: NthMagicalNumber
 * @Author: 丛虹羽
 * @Date: 2024/12/21 下午2:22
 * @Description: 第 N 个神奇数字 —— 二分答案法 —— 容斥原理
 *
 * leetcode: https://leetcode.cn/problems/nth-magical-number
 */
public class NthMagicalNumber {

    public static long MOD = 1000000007;

    /**
     * 先确定指定 n 范围内的最大值的 数值范围然后进行二分答案法求解
     * 最小的答案设置为 0，最大的答案：Math.min(a, b) * n，因为两个数中的最小值 * n，一定已经是第 n 个神奇的数了
     * 容斥原理
     * x / 2 + x / 3 - x / lcm(2, 3)
     *
     * @param n 表示第几个数
     * @param a 第一个数 a
     * @param b 第二个数 b
     * @return
     */
    public static int nthMagicalNumber(int n, int a, int b) {
        long lcm = lcm(a, b), ans = 0;
        long l = 0, r = (long)Math.min(a, b) * n;
        while(l <= r) {
            long mid = l + ((r - l) >> 1);
            // 容斥
            if(mid / a + mid / b - mid / lcm >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)(ans % MOD);
    }

    /**
     * gcd: 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * lcm： 最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 1, a = 2, b = 3;
        System.out.println(nthMagicalNumber(n, a, b));
        // 2

        int n1 = 4, a1 = 2, b1 = 3;
        System.out.println(nthMagicalNumber(n1, a1, b1));
        // 6
    }
}
