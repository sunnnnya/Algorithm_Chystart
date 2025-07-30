package job_interview.hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: ClimbStairs
 * @Author: 丛虹羽
 * @Date: 2025/7/30 16:53
 * @Description: 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
 */
public class ClimbStairs {

    /**
     * 滚动数组的方式进行处理
     *
     * @param n 台阶数
     * @return int
     */
    public static int climbStairs1(int n) {
        if(n <= 2) return n;
        int c = 0;
        for(int i = 3, a = 1, b = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 使用 一维动态规划 进行处理
     *
     * @param n 台阶数
     * @return int
     */
    public static int climbStairs2(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 使用 记忆化搜索 进行处理
     *
     * @param n 台阶数
     * @return int
     */
    public static int climbStairs3(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return process(n, cache);
    }

    /**
     * 暴力递归 + 缓存表
     *
     * @param n n 位数
     * @param cache cache[]
     * @return int
     */
    private static int process(int n, int[] cache) {
        if(n == 1) {
            cache[1] = 1;
            return cache[1];
        }
        if(n == 2) {
            cache[2] = 2;
            return cache[2];
        }
        if(cache[n] != -1) {
            return cache[n];
        }
        cache[n] = process(n - 1, cache) + process(n - 2, cache);
        return cache[n];
    }

    /**
     * 使用 矩阵快速幂 进行处理 -> 最优解
     *
     * @param n 台阶数
     * @return int
     */
    public static int climbStairs(int n) {
        if(n <= 2) return n;
        int[][] base = new int[][]{{1, 2}};
        int[][] loop = new int[][]{{0, 1}, {1, 1}};
        int[][] res = matrixPower(loop ,n - 2);
        return matrixMulti(base, res)[0][1];
    }

    /**
     * 矩阵快速幂的乘法
     *
     * @param arr 原始数组
     * @param n   n 次幂
     * @return int[][]
     */
    private static int[][] matrixPower(int[][] arr, int n) {
        int len = arr.length;
        int[][] init = new int[len][len];
        for(int i = 0; i < len; i++) {
            init[i][i] = 1;
        }
        while(n > 0) {
            if((n & 1) == 1) {
                init = matrixMulti(init, arr);
            }
            arr = matrixMulti(arr, arr);
            n >>= 1;
        }
        return init;
    }

    /**
     * 矩阵乘法
     *
     * @param a int[][] a
     * @param b int[][] b
     * @return  int[][] c
     */
    private static int[][] matrixMulti(int[][] a, int[][] b) {
        int m = a.length;
        int w = a[0].length;
        int n = b[0].length;
        int[][] c = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < w; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairs1(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
        System.out.println(climbStairs(n));
    }
}
