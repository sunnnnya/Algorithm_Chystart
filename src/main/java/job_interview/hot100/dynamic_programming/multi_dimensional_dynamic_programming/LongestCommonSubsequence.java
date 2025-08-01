package job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming.multi_dimensional_dynamic_programming
 * @ClassName: LongestCommonSubsequence
 * @Author: 丛虹羽
 * @Date: 2025/8/2 00:17
 * @Description: 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 * https://www.bilibili.com/video/BV1ey4y1d7oD/?spm_id_from=333.337.search-card.all.click&vd_source=9eeeab41783c1ac3e2c0bb2c5060f976
 */
public class LongestCommonSubsequence {

    /**
     * 字符串的 LCS 问题
     *  dp[i][j] 表示：text1 的前 i 个字符 和 text2 的前 j 个字符 LCS 最长的长度
     *  分析：text1.charAt(i) == text2.charAt(j) 说明当前两个字符是相等的，直接 LCS 的长度就会 + 1 -> dp[i][j] = dp[i - 1][j - 1] + 1;
     *       text1.charAt(i) != text2.charAt(j) 说明当前两个字符是不相等的；
     *          删除  text1.charAt(i) 的值，进行比较 -> dp[i][j] = dp[i - 1][j]
     *          删除  text2.charAt(j) 的值，进行比较 -> dp[i][j] = dp[i][j - 1]
     *        二者中取最大值
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return lcs 的数量
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
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
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        // 3
    }
}
