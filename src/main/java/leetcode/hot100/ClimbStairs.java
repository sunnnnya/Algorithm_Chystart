package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 16:44
 * @description: 爬楼梯
 *
 * leetcode：https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
 **/
public class ClimbStairs {

    /**
     * 滚动计算
     *
     * @param n 原始数据
     * @return
     */
    public static int climbStairs1(int n) {
        if(n <= 2) {
            return n;
        }
        int c = 0;
        for(int a = 1, b = 2, i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 暴力递归
     *
     * @param n 原始数据
     * @return
     */
    public static int climbStairs2(int n) {
        if(n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    /**
     * 记忆化搜索
     *
     * @param n 原始数据
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return dfs(n, dp);
    }

    /**
     * dfs
     *
     * @param n  数值 n
     * @param dp 缓存表
     * @return
     */
    public static int dfs(int n, int[] dp) {
        if(n == 1) {
            dp[1] = 1;
            return 1;
        }
        if(n == 2) {
            dp[2] = 2;
            return 2;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        int result = dfs(n - 1, dp) + dfs(n - 2, dp);
        dp[n] = result;
        return dp[n];
    }

    /**
     * 动态规划
     *
     * @param n 原始数据
     * @return
     */
    public static int climbStairs4(int n) {
        if(n <= 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 矩阵快速幂
     *
     * @param n 原始数据
     * @return
     */
    public static int climbStairs5(int n) {
        if(n <= 2) {
            return n;
        }
        int[][] base = new int[][]{{1, 2}};
        int[][] loop = new int[][]{{0, 1},{1, 1}};
        int[][] res = matrixMulPow(loop, n - 2);
        return matrixPow(base, res)[0][1];
    }

    /**
     * 矩阵快速幂的基本代码
     *
     * @param arr 原始数组
     * @param num 幂次
     * @return    幂次之后的数组
     */
    public static int[][] matrixMulPow(int[][] arr, int num) {
        int n = arr.length;
        int[][] init = new int[n][n];
        for(int i = 0; i < n; i++){
            init[i][i] = 1;
        }
        for(; num != 0; num >>= 1) {
            if((num & 1) == 1) {
                init = matrixPow(init, arr);
            }
            arr = matrixPow(arr, arr);
        }
        return init;
    }

    /**
     * 矩阵的乘法
     *
     * @param arr1 矩阵 arr1
     * @param arr2 矩阵 arr2
     * @return     矩阵的乘法
     */
    public static int[][] matrixPow(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int k = arr1[0].length;
        int n = arr2[0].length;
        int[][] arr3 = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < k; l++) {
                    arr3[i][j] += arr1[i][l] * arr2[l][j];
                }
            }
        }
        return arr3;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        // 2

        System.out.println(climbStairs(3));
        // 3
    }
}
