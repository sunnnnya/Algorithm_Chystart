package practice_questions.matrix_fast_power.medium;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.medium
 * @ClassName: NumTilings
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午8:24
 * @Description: 多米诺和托米诺平铺
 *
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
 *
 * leetcode：https://leetcode.cn/problems/domino-and-tromino-tiling
 */
public class NumTilings {

    private static final int MOD = 1000000007;

    /**
     * 暴力打标
     *
     * @param n
     * @return
     */
    public static void table(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("2 * " + i + " 的瓷砖总共有铺法: 有 " + process(i, 0) + " 种;");
        }
    }

    /**
     * 暴力递归
     *
     * @param n  表示宽度
     * @param m  是否单独多出来一块
     * @return
     */
    public static int process(int n, int m) {
        if (n == 0) {
            return m ^ 1;
            // return m == 0 ? 1 : 0;
        }
        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return process(n - 1, 1) + process(n - 1, 0);
        } else {
            return process(n - 1, 0) + 2 * process(n - 2, 1) + process(n - 2, 0);
        }
    }

    /**
     * 使用矩阵快速幂
     *
     * @param n
     * @return
     */
    public static int numTilings(int n) {
        int[][] base = new int[][]{{1, 2, 5, 11}};
        if (n <= 4) {
            return base[0][n - 1];
        }
        int[][] loop = new int[][]{{0, 0, 0, 0},
                                   {1, 0, 0, 1},
                                   {0, 1, 0, 0},
                                   {0, 0, 1, 2}};
        int[][] ans = matrixPower(loop, n - 4);
        // 这部分 + mod 的原因：防止前面出现负数
        return (matrixMultiply(base, ans)[0][3] + MOD) % MOD;
    }

    /**
     * 矩阵乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] matrixMultiply(int[][] a, int [][] b) {
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    ans[i][j] = (int)(((long)a[i][k] * b[k][j] + ans[i][j]) % MOD);
                }
            }
        }
        return ans;
    }

    /**
     * 矩阵快速幂
     *
     * @param arr
     * @param m
     * @return
     */
    public static int[][] matrixPower(int[][] arr, int m) {
        int N = arr.length;
        int[][] init = new int[N][N];
        for (int i = 0; i < N; i++) {
            init[i][i] = 1;
        }
        for ( ; m > 0; m >>>= 1) {
            if ((m & 1) == 1) {
                init = matrixMultiply(init, arr);
            }
            arr = matrixMultiply(arr, arr);
        }
        return init;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("======================打表开始======================");
        table(9);
        // 2 * 1 的瓷砖总共有铺法: 有 1 种;
        // 2 * 2 的瓷砖总共有铺法: 有 2 种;
        // 2 * 3 的瓷砖总共有铺法: 有 5 种;
        // 2 * 4 的瓷砖总共有铺法: 有 11 种;
        // 2 * 5 的瓷砖总共有铺法: 有 24 种;
        // 2 * 6 的瓷砖总共有铺法: 有 53 种;
        // 2 * 7 的瓷砖总共有铺法: 有 117 种;
        // 2 * 8 的瓷砖总共有铺法: 有 258 种;
        // 2 * 9 的瓷砖总共有铺法: 有 569 种;
        // 总结：
        //      f(1) = 1
        //      f(2) = 2
        //      f(3) = 5
        //      f(4) = 11
        //      f(n) = 2 * f(n-1) + f(n-3)
        System.out.println("===================矩阵快速幂实现====================");
        System.out.println(numTilings(3));
        // 5

        System.out.println(numTilings(5));
        // 24

        System.out.println(numTilings(30));
    }
}
