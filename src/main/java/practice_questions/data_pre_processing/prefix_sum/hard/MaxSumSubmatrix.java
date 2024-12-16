package practice_questions.data_pre_processing.prefix_sum.hard;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.hard
 * @ClassName: MaxSumSubmatrix
 * @Author: 丛虹羽
 * @Date: 2024/12/16 下午4:32
 * @Description: 矩形区域不超过 K 的最大数值和
 *
 * leetcode: https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k
 */
public class MaxSumSubmatrix {

    /**
     * 通过枚举各个点进行计算，矩阵中元素的个数
     *
     * @param matrix 原始数组
     * @param k      约束条件
     * @return
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = matrix[i][j];
            }
        }
        build(sum);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                for(int q = i; q <= n; q++) {
                    for(int w = j; w <= m; w++) {
                        if(sum(sum, i, j, q, w) <= k) {
                            ans = Math.max(ans, sum(sum, i, j, q ,w));
                        }
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 构建前缀和数组，通过补充一行一列的情况下，免去很多边界的讨论
     *  左 + 上 + 自身 - 左上 = 当前前缀和的值
     *
     * @param sum 原始数组
     */
    private static void build(int[][] sum) {
        for(int i = 1; i < sum.length; i++) {
            for(int j = 1; j < sum[i].length; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    /**
     * 求指定两个坐标之间的和
     *
     * @param sum 原始数组
     * @param a   左上角坐标 x
     * @param b   左上角坐标 y
     * @param c   右下角坐标 x
     * @param d   右下角坐标 y
     * @return
     */
    private static int sum(int[][] sum, int a, int b, int c, int d) {
        return sum[c][d] - sum[c][b - 1] - sum[a - 1][d] + sum[a - 1][b - 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(arr, k));
        // 2
    }
}