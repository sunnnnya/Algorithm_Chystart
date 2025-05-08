package job_interview.code_top.array.data_pre_process;

/**
 * @BelongsPackage: job_interview.code_top.array.data_pre_process
 * @ClassName: CountSquares
 * @Author: 丛虹羽
 * @Date: 2025/5/8 16:26
 * @Description: 统计全为 1 的正方形子矩阵
 * https://leetcode.cn/problems/count-square-submatrices-with-all-ones/description/
 */
public class CountSquares {

    /**
     * 前缀和数组的基本使用
     *
     * @param matrix 原始数组
     * @return int
     */
    public static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0;
        int[][] sum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int num = matrix[i - 1][j - 1];
                count += num == 1 ? 1 : 0;
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num;
            }
        }
        for(int len = 1; len < Math.min(m, n); len++) {
            int mm = sum.length, nn = sum[0].length;
            for(int i = 1; i < mm - len; i++) {
                for(int j = 1; j < nn - len; j++) {
                    count += getNum(sum, i, j, i + len, j + len, len) ? 1 : 0;
                }
            }
        }
        return count;
    }

    private static boolean getNum(int[][] sum, int x1, int y1, int x2, int y2, int len) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1] == Math.pow(len + 1, 2);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};;
        System.out.println(countSquares(matrix));
        // 15

        int[][] matrix1 = new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(countSquares(matrix1));
        // 7
    }
}
