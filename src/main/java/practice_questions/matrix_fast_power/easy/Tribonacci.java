package practice_questions.matrix_fast_power.easy;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.easy
 * @ClassName: Tribonacci
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午7:52
 * @Description: 第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * leetcode：https://leetcode.cn/problems/n-th-tribonacci-number
 */
public class Tribonacci {

    /**
     * 使用矩阵快速幂实现代码
     *
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = new int[][]{{0, 1, 1}};
        int[][] loop = new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 1, 1}};
        int[][] result = power(loop, n - 2);
        return multiply(base, result)[0][2];
    }

    /**
     * 矩阵快速幂
     *
     * @param arr
     * @param m
     * @return
     */
    public static int[][] power(int[][] arr, int m) {
        int N = arr.length;
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            ans[i][i] = 1;
        }
        for (;m > 0; m >>= 1) {
            if ((m & 1) == 1) {
                ans = multiply(ans, arr);
            }
            arr = multiply(arr, arr);
        }
        return ans;
    }

    /**
     * 矩阵乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int N = a.length;
        int K = a[0].length;
        int M = b[0].length;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    arr[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return arr;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        // 4

        System.out.println(tribonacci(25));
        // 1389537
    }
}