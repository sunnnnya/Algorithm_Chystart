package job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming
 * @ClassName: UniquePaths
 * @Author: 丛虹羽
 * @Date: 2025/8/2 19:37
 * @Description: 不同路径
 * https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked
 */
public class UniquePaths {

    /**
     * 不同的路径个数:
     *  dp[i][j] 表示从(i, j) -> (0, 0)的路径条数
     *  dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
     *
     * @param m 行数
     * @param n 列数
     * @return int
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
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
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
        // 28
    }
}
