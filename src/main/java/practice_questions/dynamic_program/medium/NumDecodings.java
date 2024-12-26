package practice_questions.dynamic_program.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dp.medium
 * @ClassName: NumDecodings
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午3:04
 * @Description: 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *     "1" -> 'A'
 *     "2" -> 'B'
 *     ...
 *     "25" -> 'Y'
 *     "26" -> 'Z'
 * 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
 * 例如，"11106" 可以映射为：
 *      "AAJF" ，将消息分组为 (1, 1, 10, 6)
 *      "KJF" ，将消息分组为 (11, 10, 6)
 *      消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
 * 注意，可能存在无法解码的字符串。
 *
 * leetcode:https://leetcode.cn/problems/decode-ways
 */
public class NumDecodings {

    /**
     * 暴力递归，(超时)
     *
     * @param s
     * @return
     */
    public static int numDecodings1(String s) {
        return process(s.toCharArray(), 0);
    }

    /**
     * s：数字字符串
     * s[i....]有多少种有效的转换方案
     *
     * @param s
     * @param i
     * @return
     */
    public static int process(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        // i 没越界
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            // i 自己单独
            ans = process(s, i + 1);
            // [.. i, i + 1...] 的位置去转
            if(i + 1 < s.length && ((s[i] - '0') * 10 + (s[i + 1] - '0')) <= 26) {
                ans += process(s, i + 2);
            }
        }
        return ans;
    }

    /**
     * 使用暴力递归 + 记忆化搜索
     *
     * @param s
     * @return
     */
    public static int numDecodings2(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return process1(s.toCharArray(), 0, dp);
    }

    /**
     * 方案一样，只是加了缓存表
     *
     * @param s
     * @param i
     * @param dp
     * @return
     */
    public static int process1(char[] s, int i, int[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            ans = process1(s, i + 1, dp);
            if (i + 1 < s.length && ((s[i] - '0') * 10 + (s[i + 1] - '0')) <= 26) {
                ans += process1(s, i + 2, dp);
            }
        }
        dp[i] = ans;
        return ans;
    }

    /**
     * 采用动态规划的方式进行填充
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (c[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < c.length && ((c[i] - '0') * 10 + (c[i + 1] - '0')) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
        // 3
    }
}
