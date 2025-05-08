package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: PrefixSumArrayII
 * @Author: 丛虹羽
 * @Date: 2025/5/8 16:39
 * @Description: 二维前缀和数组
 * （1）原始数组构建前缀和数组：
 *      sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
 *
 * （2）从左上角 (a,b) 到 右下角 (c,d) 的累加范围和
 *      total = sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1];
 */
public class PrefixSumArrayII {

    /**
     * 二维前缀和的基本使用
     *
     * @param matrix 原始数组
     */
    static int[][] prefixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        return sum;
    }

    /**
     * 获取指定坐标的之间的值
     *
     * @param sum 前缀和数组
     * @param x1  左上角 x
     * @param y1  左上角 y
     * @param x2  右下角 x
     * @param y2  右下角 y
     * @return int
     */
    static int getSum(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2 + 1][y2 + 1] - sum[x2 + 1][y1] - sum[x1][y2 + 1] + sum[x1][y1];
    }

    /**
     * 打印二维数组的值
     *
     * @param ans 前缀和数组
     */
    static void print(int[][] ans) {
        int m = ans.length, n = ans[0].length;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(j == n - 1) {
                    System.out.print(ans[i][j]);
                } else {
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1：构建前缀和数组
        int[][] arr = new int[][]{{1, 2, 3, 4},
                                  {2, 3, 4, 9},
                                  {1, 4, 2, 9}};
        int[][] ans = prefixSum(arr);
        print(ans);
        // 1 3 6 10
        // 3 8 15 28
        // 4 13 22 44

        // 2：求指定坐标之间的总和
        System.out.println(getSum(ans, 1, 1, 2, 3));
        // 31
    }
}
