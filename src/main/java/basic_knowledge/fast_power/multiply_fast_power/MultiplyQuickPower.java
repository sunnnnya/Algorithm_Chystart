package basic_knowledge.fast_power.multiply_fast_power;

/**
 * @BelongsPackage: basic_knowledge.fast_power.mult_fast_power
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/20 下午5:19
 * @Description: 乘法快速幂 O(log n)
 * 求 10 的 75 次方 -> 75 对应的二进制数字：1001011
 * 思路：
 *      令 x = 10 的 1 次方
 *      x *= x -> x = 10 的 2 次方
 *      x *= x -> x = 10 的 4 次方
 *      x *= x -> x = 10 的 8 次方
 *      x *= x -> x = 10 的 16 次方
 *      x *= x -> x = 10 的 32 次方
 *      x *= x -> x = 10 的 64 次方
 *     然后判断 75 次幂中是否包含 10 的 1次方，如果包含进行结果的累乘。
 * 总结：
 *      75 = 64 + 8 + 2 + 1
 *      10 的 75 次幂 = (10 的 64 次幂) * (10 的 8 次幂) * (10 的 2 次幂) * (10 的 1 次幂)
 */
public class MultiplyQuickPower {

    /**
     * 乘法快速幂，输入的数字都是整数；
     *
     * @param n    n 的 m 次幂
     * @param m    n 的 m 次幂
     * @param mod  余数
     * @return
     */
    public static int quickPower(int n,  int m, int mod) {
        long ans = 1;
        for (; m > 0; m >>= 1, n = (n * n) % mod) {
            if ((m & 1) == 1) {
                ans = (ans * n) % mod;
            }
        }
        return (int) ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int result = quickPower(2, 3, 3);
        System.out.println("result = " + result);
        // result = 2

        int result1 = quickPower(3, 3, 1);
        System.out.println("result1 = " + result1);
        // result1 = 0
    }
}
