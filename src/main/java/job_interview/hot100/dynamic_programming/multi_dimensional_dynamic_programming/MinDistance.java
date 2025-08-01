package job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.multi_dynamic_programming
 * @ClassName: MinDistance
 * @Author: 丛虹羽
 * @Date: 2025/8/1 23:48
 * @Description: 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked
 * https://www.bilibili.com/video/BV1sA411B73r/?spm_id_from=333.337.search-card.all.click&vd_source=9eeeab41783c1ac3e2c0bb2c5060f976
 */
public class MinDistance {

    /**
     * 多维度动态规划
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 最小的操作次数
     */
    public static int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        for(int j = 0; j <= n; j++) dp[0][j] = j;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
        // 5
    }
}
