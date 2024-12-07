package practice_questions.dp.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.recursion.easy
 * @ClassName: ClimbStairs
 * @Author: 丛虹羽
 * @Date: 2024/12/7 下午11:47
 * @Description: 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * leetcode:https://leetcode.cn/problems/climbing-stairs
 */
public class ClimbStairs {

    public static int number = 10;

    /**
     * 使用递归解题(不使用记忆化搜索)，时间复杂度O（2^N）
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        // 原始递归的方式有很多次重复计算
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 使用递归 + 记忆化搜索
     *
     * @return
     */
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // 理解递归中的 值传递(各一份) 和 引用传递(共享一份) 的区别
        return f2(n, dp);
    }

    public static int f2(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = f2(n - 1, dp) + f2(n - 2, dp);
        return dp[n];
    }

    /**
     * 一维动态规划，实现
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int[] arr = new int[46];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= 45; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 滚动数组
     *
     * @param n
     * @return
     */
    public static int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        for (int i = 3, c; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * 使用矩阵快速幂O（log N）
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n >= 1 && n <= 2) {
            return n;
        }
        int[][] arr = new int[][]{{1, 2}};
        int[][] loop = new int[][]{{0, 1}, {1, 1}};
        int[][] result = matrixFasterPower(loop, n - 2);
        return matrixMulti(arr, result)[0][1];
    }

    /**
     * 矩阵的乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixMulti(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new RuntimeException("矩阵 a 的行数和矩阵 b 的列数对应不上，不能进行计算！！！");
        }
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    ans[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return ans;
    }

    /**
     * 矩阵快速幂
     *
     * @param arr
     * @param n
     * @return
     */
    public static int[][] matrixFasterPower(int[][] arr, int n) {
        int N = arr.length;
        // 单位矩阵
        int[][] unit = new int[N][N];
        for (int i = 0; i < N; i++) {
            unit[i][i] = 1;
        }
        for (; n > 0; n >>= 1, arr = matrixMulti(arr, arr)) {
            if ((n & 1) == 1) {
                unit = matrixMulti(unit, arr);
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
        System.out.println(climbStairs1(2));
        // 2

        System.out.println(climbStairs2(3));
        // 3

        System.out.println(climbStairs3(45));
        // 1836311903

        System.out.println(climbStairs(45));
        // 1836311903
    }
}