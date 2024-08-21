package practice_questions.matrix_fast_power.easy;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.easy
 * @ClassName: Fib
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午4:20
 * @Description: 斐波那契数
 *
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 *
 */
public class Fib {

    private static final int MOD = 1000000007;

    /**
     * 使用矩阵快速幂解决问题
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] base = {{0, 1}};
        int[][] loop = new int[][]{{0, 1}, {1, 1}};
        int[][] res = power(loop, n - 1);
        return (multiply(base, res)[0][1] + MOD) % MOD;
    }

    /**
     * 矩阵的乘法
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
                    arr[i][j] = (arr[i][j] + (int)(((long) a[i][k] * b[k][j]) % MOD)) % MOD; // Apply modulo
                }
            }
        }
        return arr;
    }

    /**
     * 矩阵快速幂
     *
     * @param arr
     * @param n
     * @return
     */
    public static int[][] power(int[][] arr, int n) {
        int N = arr.length;
        int[][] unit = new int[N][N];
        for (int i = 0; i < N; i++) {
            unit[i][i] = 1;
        }
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                unit = multiply(unit, arr);
            }
            arr = multiply(arr, arr);
        }
        return unit;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib(5));
        // 5

        System.out.println(fib(6));
        // 8

        System.out.println(fib(100));
        // 687995182
    }
}