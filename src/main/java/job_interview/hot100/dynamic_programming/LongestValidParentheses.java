package job_interview.hot100.dynamic_programming;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: LongestValidParentheses
 * @Author: 丛虹羽
 * @Date: 2025/8/2 20:39
 * @Description: 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 * https://www.bilibili.com/video/BV1Ct4y197M3/?spm_id_from=333.337.search-card.all.click&vd_source=9eeeab41783c1ac3e2c0bb2c5060f976
 */
public class LongestValidParentheses {

    /**
     * 一维动态规划处理
     *
     * @param s 原始字符串
     * @return 最长的长度
     */
    public static int longestValidParentheses(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] dp = new int[n];
        int mx = 0;
        for(int i = 1; i < n; i++) {
            if(c[i] == ')') {
                int pre = i - dp[i - 1] - 1;
                if(pre >= 0 && c[pre] == '(') {
                    dp[i] = 2 + dp[i - 1] + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            mx = Math.max(mx, dp[i]);
        }
        return mx;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longestValidParentheses(str));
        // 4
    }
}
