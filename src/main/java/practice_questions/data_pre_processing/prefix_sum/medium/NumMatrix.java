package practice_questions.data_pre_processing.prefix_sum.medium;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: NumMatrix
 * @Author: 丛虹羽
 * @Date: 2024/12/15 下午4:28
 * @Description: 二维数组前缀和
 *
 * leetcode： https://leetcode.cn/problems/O4NDxx/
 */
public class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        sum = new int[n][m];
        // 把数组中值复制到 sum 数组中
        for(int a = 1, c = 0; c < n; a++, c++) {
            for(int b = 1, d = 0; d < m; b++, d++) {
                sum[a][b] = matrix[c][d];
            }
        }
        // 不需要考虑边界了，直接计算就可以！！！
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        col2++;
        return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
    }
}
