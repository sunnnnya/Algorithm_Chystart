package basic_knowledge.math;

/**
 * @BelongsPackage: basic_knowledge.math
 * @ClassName: PrincipleOfCongruence
 * @Author: 丛虹羽
 * @Date: 2024/12/21 下午2:58
 * @Description: 同余原理
 *
 * 加法同余原理：((a + b) + c) % mod = (((a % mod) + (b % mod)) + (c % mod)) % mod;
 * 乘法同余原理：((a * b) * c) % mod = ((int)((long)(a * b) % mod) * (c % mod)) % mod
 * 减法同余原理：(a - b) % mod = ((a % mod) - (b % mod) + mod) % mod
 */
public class PrincipleOfCongruence {

    /**
     * (((a + b) * (c - d)) + (a * c - b * d)) % mod
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param mod
     * @return
     */
    public static int f(long a, long b, long c, long d, int mod) {
        int o1 = (int) (a % mod); // a
        int o2 = (int) (b % mod); // b
        int o3 = (int) (c % mod); // c
        int o4 = (int) (d % mod); // d
        int o5 = (o1 + o2) % mod; // a + b
        int o6 = (o3 - o4 + mod) % mod; // c - d
        int o7 = (int) (((long) o1 * o3) % mod); // a * c
        int o8 = (int) (((long) o2 * o4) % mod); // b * d
        int o9 = (int) (((long) o5 * o6) % mod); // (a + b) * (c - d)
        int o10 = (o7 - o8 + mod) % mod; // (a * c - b * d)
        int ans = (o9 + o10) % mod; // (((a + b) * (c - d)) + (a * c - b * d)) % mod
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        long a = 5, b = 3, c = 7, d = 2, mod = 10;
        int result1 = f(a, b, c, d, (int) mod);
        System.out.println("Test Case 1 Result: " + result1);

        a = -5;
        b = -3;
        c = -7;
        d = -2;
        mod = 10;
        int result2 = f(a, b, c, d, (int) mod);
        System.out.println("Test Case 2 Result: " + result2);

        a = 0;
        b = 0;
        c = 0;
        d = 0;
        mod = 10;
        int result3 = f(a, b, c, d, (int) mod);
        System.out.println("Test Case 3 Result: " + result3);

        a = 1_000_000_000;
        b = 2_000_000_000;
        c = 3_000_000_00;
        d = 4_000_000_00;
        mod = 1_000_000_007;
        int result4 = f(a, b, c, d, (int) mod);
        System.out.println("Test Case 4 Result: " + result4);

        a = 12345;
        b = 67890;
        c = 11121;
        d = 31415;
        mod = 1;
        int result5 = f(a, b, c, d, (int) mod);
        System.out.println("Test Case 5 Result: " + result5);
    }
}