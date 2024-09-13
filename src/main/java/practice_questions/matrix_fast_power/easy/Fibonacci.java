package practice_questions.matrix_fast_power.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.easy
 * @ClassName: Fibonacci
 * @Author: 丛虹羽
 * @Date: 2024/9/13 下午8:03
 * @Description: 矩阵快速幂的实现
 *
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * F(0) = 0，F(1) = 1，F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * leetcode： https://leetcode.cn/problems/fibonacci-number
 */
public class Fibonacci {

    public static int[] dp = new int[32];

    private static final int MOD = 1000000007;

    static {
        Arrays.fill(dp, -1);
    }

    /**
     * 使用滚动数组的方式实现
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int b = 1;
        for (int i = 0, c = 0, a = 0; i <= n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * 使用暴力递归的方式实现
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    /**
     * 使用暴力递归 + 缓存表
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if(n == 0) {
            dp[0] = 0;
            return 0;
        }
        if (n == 1) {
            dp[1] = 1;
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int number = fib3(n - 1) + fib3(n - 2);
        dp[n] = number;
        return dp[n];
    }

    /**
     * 使用矩阵快速幂的方式实现
     *
     * @param n
     * @return
     */
    public static long fib(int n) {
        if(n <= 1) {
            return n;
        }
        long[][] base = new long[][]{{0, 1}};
        long[][] loop = new long[][]{{0, 1},
                                   {1, 1}};
        long[][] result = matrixFasterPow(loop, n - 1);
        return matrixMulti(base, result)[0][1];
    }

    /**
     * 矩阵的乘法实现
     *
     * @param a
     * @param b
     * @return
     */
    public static long[][] matrixMulti(long[][] a, long[][] b) {
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        long[][] c = new long[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 矩阵快速幂的实现
     *
     * @param base
     * @param n
     * @return
     */
    public static long[][] matrixFasterPow(long[][] base, int n) {
        int N = base.length;
        long[][] unit = new long[N][N];
        for (int i = 0; i < N; i++) {
            unit[i][i] = 1;
        }
        for (; n > 0; n >>= 1, base = matrixMulti(base, base)) {
            if ((n & 1) == 1) {
                unit = matrixMulti(base, unit);
            }
        }
        return unit;
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib(2));
        // 1

        System.out.println(fib(3));
        // 2

        System.out.println(fib(4));
        // 3

        System.out.println(fib(100));
        // 3736710778780434371

        System.out.println(fib(100) % MOD);
        // 687995182
    }
}
