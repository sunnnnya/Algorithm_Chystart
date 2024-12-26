package basic_knowledge.dynamic_programming.one_dimensional;

/**
 * @BelongsPackage: basic_knowledge.dynamic_programming.one_dimensional
 * @ClassName: Fibonacci
 * @Author: 丛虹羽
 * @Date: 2024/12/25 下午9:53
 * @Description: 一维动态规划 - 斐波那契数列
 */
public class Fibonacci {

    public static int MAXN = 1001;

    /**
     * 暴力递归求解斐波那契是咧
     *
     * @param n 待求解的第 n 个数
     * @return 返回第 n 个数的值
     */
    public static int fib1(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param n 待求解的第 n 个数
     * @return 返回第 n 个数的值
     */
    public static int fib2(int n) {
        int[] dp = new int[MAXN];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return process(n, dp);
    }

    /**
     * 暴力递归 + 缓存表
     *
     * @param n  第 n 个数
     * @param dp dp 缓存表
     * @return
     */
    public static int process(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }
        if(n <= 2) {
            return 1;
        }
        int ans = process(n - 1, dp) + process(n - 2, dp);
        dp[n] = ans;
        return dp[n];
    }

    /**
     * 动态规划版本
     *
     * @param n 待求解的某个数
     * @return
     */
    public static int fib3(int n) {
        int[] dp = new int[MAXN];
        dp[1] = dp[2] = 1;
        for(int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 使用滚动数组的方式实现斐波那契数列
     *
     * @param n 待求解的 n 个数
     * @return
     */
    public static int fib4(int n) {
        if(n <= 2) {
            return 1;
        }
        int res = 0;
        for(int i = 3, q = 1, w = 1; i <= n; i++) {
            res = q + w;
            q = w;
            w = res;
        }
        return res;
    }

    /**
     * 使用矩阵快速幂实现斐波那契数列
     *
     * @param n 待求解的 n 个数
     * @return
     */
    public static int fib5(int n) {
        if(n <= 2) {
            return 1;
        }
        int[][] base = new int[][]{{0, 1}};
        int[][] loop = new int[][]{{0, 1},
                                   {1, 1}};
        int[][] mul = matrixPower(loop, n - 1);
        return matrixMul(base, mul)[0][1];
    }

    /**
     * 矩阵快速幂
     *
     * @param matrix 矩阵
     * @param num    矩阵的幂次
     * @return
     */
    private static int[][] matrixPower(int[][] matrix, int num) {
        int n = matrix.length;
        int[][] unit = initUnit(n);
        for(; num != 0; num >>= 1) {
            if((num & 1) == 1) {
                unit = matrixMul(unit, matrix);
            }
            matrix = matrixMul(matrix, matrix);
        }
        return unit;
    }

    /**
     * 返回单位矩阵
     *
     * @param len 单位矩阵的长度信息
     * @return
     */
    private static int[][] initUnit(int len) {
        int[][] unit = new int[len][len];
        for(int i = 0; i < len; i++) {
            unit[i][i] = 1;
        }
        return unit;
    }

    /**
     * 矩阵的乘法
     *
     * @param a 矩阵 a
     * @param b 矩阵 b
     * @return
     */
    private static int[][] matrixMul(int[][] a, int[][] b) {
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        int[][] c = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < K; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 暴力递归
        System.out.println(fib1(10));

        // 暴力递归 + 缓存表
        System.out.println(fib2(10));

        // 动态规划
        System.out.println(fib3(10));

        // 使用滚动数组实现
        System.out.println(fib4(10));

        // 使用矩阵快速幂 + 同余原理实现
        System.out.println(fib5(10));
    }
}