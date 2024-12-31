package practice_questions.matrix_fast_power.hard;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.hard
 * @ClassName: CountVowelPermutation
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午9:41
 * @Description: 统计元音字母序列的数目
 *
 * leetcode: https://leetcode.cn/problems/count-vowels-permutation
 */
public class CountVowelPermutation {

    public static int MOD = 1000000007;

    /**
     * 分析 dp 表进行递推，使用矩阵快速幂：
     * dp 表的含义: dp[l][x] 长度为 l 且以 x 字母结尾的合法方法数是 dp[l][x]
     *      base = dp[1][a | e | i | o | u] = {{1, 1, 1, 1, 1}};
     * 根据题目中的规则进行分析：
     *      dp[l][a] -> 表示长度为 l 时以 a 结尾的方法数 = dp[l - 1][e] + dp[l - 1][i] + dp[l - 1][u];
     *      dp[l][e] -> 表示长度为 l 时以 e 结尾的方法数 = dp[l - 1][a] + dp[l - 1][i];
     *      dp[l][i] -> 表示长度为 l 时以 i 结尾的方法数 = dp[l - 1][e] + dp[l - 1][o];
     *      dp[l][o] -> 表示长度为 l 时以 o 结尾的方法数 = dp[l - 1][i];
     *      dp[l][u] -> 表示长度为 l 时以 u 结尾的方法数 = dp[l - 1][i] + dp[l - 1][o];
     *      总结：
     *          base[][] = {{1, 1, 1, 1, 1}};
     *                       a  e  i  o  u
     *          loop[][] = {{0, 1, 0, 0, 0},
     *                      {1, 0, 1, 0, 0},
     *                      {1, 1, 0, 1, 1},
     *                      {0, 0, 1, 0, 1},
     *                      {1, 0, 0, 0, 0}}
     *
     * @param n 原始数据
     * @return
     */
    public static int countVowelPermutation(int n) {
        if(n == 1) {
            return 5;
        }
        int[][] base = new int[][]{{1, 1, 1, 1, 1}};
        int[][] loop = new int[][]{{0, 1, 0, 0, 0},
                                   {1, 0, 1, 0, 0},
                                   {1, 1, 0, 1, 1},
                                   {0, 0, 1, 0, 1},
                                   {1, 0, 0, 0, 0}};
        int[][] res = matrixPower(loop, n - 1);
        return getAns(matrixMul(base, res));
    }

    /**
     * 利用幂级进行二进制计算
     *
     * @param arr 原始数组
     * @param n   幂次
     * @return
     */
    public static int[][] matrixPower(int[][] arr, int n) {
        int[][] init = initArr(5);
        for(;n > 0; n >>= 1, arr = matrixMul(arr, arr)) {
            if((n & 1) == 1) {
                init = matrixMul(init, arr);
            }
        }
        return init;
    }

    /**
     * 矩阵乘法
     *
     * @param a 矩阵 a
     * @param b 矩阵 b
     * @return
     */
    public static int[][] matrixMul(int[][] a, int [][] b) {
        int n = a.length;
        int m = b[0].length;
        int k = a[0].length;
        int[][] c = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int w = 0; w < k; w++) {
                    c[i][j] = (int)((long)c[i][j] + (a[i][w] * b[w][j]) % MOD) % MOD;
                }
            }
        }
        return c;
    }

    /**
     * 初始化单位矩阵
     *
     * @param n 原始数据
     * @return
     */
    public static int[][] initArr(int n) {
        int[][] init = new int[n][n];
        for(int i = 0; i < n; i++) {
            init[i][i] = 1;
        }
        return init;
    }

    /**
     * 获取乘积之后的结果总和
     *
     * @param arr 初始矩阵 和 状态矩阵 的 乘积
     * @return
     */
    public static int getAns(int[][] arr) {
        int sum = 0;
        for(int i = 0, j = 0; j < arr[i].length; j++) {
            sum = (sum + arr[i][j]) % MOD;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        // 5

        System.out.println(countVowelPermutation(2));
        // 10

        System.out.println(countVowelPermutation(5));
        // 58
    }
}