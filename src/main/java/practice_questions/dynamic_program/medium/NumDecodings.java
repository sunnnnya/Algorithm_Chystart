package practice_questions.dynamic_program.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dp.medium
 * @ClassName: NumDecodings
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午3:04
 * @Description: 解码方法
 *
 * leetcode:https://leetcode.cn/problems/decode-ways
 */
public class NumDecodings {

    /**
     * 暴力递归 —— TLE
     *
     * @param s 原始字符串
     * @return
     */
    public static int numDecodings1(String s) {
        return process(s.toCharArray(), 0);
    }

    /**
     * 返回 char[] -> c[i....]有多少种有效的转换方案
     *
     * @param s 原始字符串
     * @param i 当时字符串的索引位置
     * @return  返回转换的方法数
     */
    public static int process(char[] s, int i) {
        // 说明当前字符串已经遍历结束都没返回 0，说明找到一种转换方法
        if (i == s.length) {
            return 1;
        }
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            // c[i] 单独转换
            ans = process(s, i + 1);
            // c[i] + c[i + 1] 一起转换
            if(i + 1 < s.length && ((s[i] - '0') * 10 + (s[i + 1] - '0')) <= 26) {
                ans += process(s, i + 2);
            }
        }
        return ans;
    }

    /**
     * 暴力递归 + 缓存表 => 记忆化搜索
     *
     * @param s 原始字符串
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
     * @param s  原始字符串
     * @param i  字符串索引位置
     * @param dp 缓存表
     * @return   返回方法数
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
     * @param s 原始字符串
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

        System.out.println(numDecodings("06"));
        // 0

        System.out.println(numDecodings("12"));
        // 2
    }
}