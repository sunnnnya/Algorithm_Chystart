package job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming
 * @ClassName: MinPathSum
 * @Author: 丛虹羽
 * @Date: 2025/8/2 18:20
 * @Description: 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinPathSum {

    /**
     * 最小路径: 问题转换从(0, 0) -> (m, n) 的问题，转换成 (m, n) -> (0, 0) 的最小值问题
     *  dp[i][j] 表示从 (i, j) -> (0, 0) 的最小路径总和
     *      dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
     *
     * @param grid 原始数组
     * @return int
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
        // 6

        int[][] grid1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(minPathSum(grid1));
        // 12
    }
}
