package practice_questions.dynamic_program.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dynamic_program.medium
 * @ClassName: NumDecodingsII
 * @Author: 丛虹羽
 * @Date: 2025/1/10 下午10:16
 * @Description: 解码方法 II
 *
 * leetcode: https://leetcode.cn/problems/decode-ways-ii/description/
 */
public class NumDecodingsII {

    // 一般情况下 1000000007 使用 long 类型进行处理
    public static long MOD = 1000000007;

    /**
     * 暴力递归 + 分情况讨论 —— TLE
     *
     * @param s 原始字符串
     * @return  返回有效的转换方法数
     */
    public static int numDecodings1(String s) {
        // 计算结果的过程中可能出现，爆 int 的情况，索引直接使用 long 进行处理，最后转换就可以！！！
        return (int)dfs1(s.toCharArray(), 0);
    }

    /**
     * 暴力递归函数含义：
     *      从 i 到 最后位置 返回的方法数
     *
     * @param c 字符数组
     * @param i 索引位置
     * @return
     */
    public static long dfs1(char[] c, int i) {
        if(i == c.length) {
            return 1;
        }
        if(c[i] == '0') {
            return 0;
        }
        long ways = dfs1(c, i + 1) * (c[i] == '*' ? 9 : 1) % MOD;
        // i 位置单独转：
        //     *   -> 9 种转换方法
        //   1 ~ 9 -> 1 种方法
        if(i + 1 < c.length) {
            if(c[i] != '*') {
                if(c[i + 1] != '*') {
                    // num  num
                    //  i  i + 1
                    if((c[i] - '0') * 10 + (c[i + 1] - '0') <= 26) {
                        ways = (ways + dfs1(c, i + 2) % MOD) % MOD;
                    }
                } else {
                    // num   *
                    //  i  i + 1
                    if(c[i] == '1') {
                        ways = (ways + 9 * dfs1(c, i + 2) % MOD) % MOD;
                    } else if(c[i] == '2') {
                        ways = (ways + 6 * dfs1(c, i + 2) % MOD) % MOD;
                    }
                }
            } else {
                if(c[i + 1] != '*') {
                    // *   num
                    // i  i + 1
                    if(c[i + 1] <= '6') {
                        ways = (ways + 2 * dfs1(c, i + 2) % MOD) % MOD;
                    } else {
                        ways = (ways + dfs1(c, i + 2) % MOD) % MOD;
                    }
                } else {
                    // *    *
                    // i  i + 1
                    ways = (ways + 15 * dfs1(c, i + 2) % MOD) % MOD;
                }
            }
        }
        return ways;
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param s 原始字符串
     * @return  返回有效的转换方法数
     */
    public static int numDecodings2(String s) {
        char[] c = s.toCharArray();
        long[] dp = new long[c.length];
        Arrays.fill(dp, -1);
        return (int)dfs2(c, 0, dp);
    }

    /**
     * 暴力递归函数的定义：
     *      从 i 到 结束 位置返回的方法数
     *
     * @param c 字符数组
     * @param i 索引位置
     * @return
     */
    public static long dfs2(char[] c, int i, long[] dp) {
        if(i == c.length) {
            return 1;
        }
        if(c[i] == '0') {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        long ways = dfs2(c, i + 1, dp) * (c[i] == '*' ? 9 : 1) % MOD;
        // i 位置单独转：
        //     * -> 9种
        //     1 ~ 9 -> 1种
        if(i + 1 < c.length) {
            if(c[i] != '*') {
                if(c[i + 1] != '*') {
                    // num  num
                    //  i  i + 1
                    if((c[i] - '0') * 10 + (c[i + 1] - '0') <= 26) {
                        ways = (ways + dfs2(c, i + 2, dp) % MOD) % MOD;
                    }
                } else {
                    // num   *
                    //  i  i + 1
                    if(c[i] == '1') {
                        ways = (ways + 9 * dfs2(c, i + 2, dp) % MOD) % MOD;
                    } else if(c[i] == '2') {
                        ways = (ways + 6 * dfs2(c, i + 2, dp) % MOD) % MOD;
                    }
                }
            } else {
                if(c[i + 1] != '*') {
                    // *   num
                    // i  i + 1
                    if(c[i + 1] <= '6') {
                        ways = (ways + 2 * dfs2(c, i + 2, dp) % MOD) % MOD;
                    } else {
                        ways = (ways + dfs2(c, i + 2, dp) % MOD) % MOD;
                    }
                } else {
                    // *    *
                    // i  i + 1
                    ways = (ways + 15 * dfs2(c, i + 2, dp) % MOD) % MOD;
                }
            }
        }
        ways %= MOD;
        dp[i] = ways;
        return ways;
    }

    /**
     * 动态规划版本
     *
     * @param s 原始字符串
     * @return  返回解码方法总数
     */
    public static int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(c[i] != '0') {
                dp[i] = (c[i] == '*' ? 9 : 1) * dp[i + 1];
                if(i + 1 < n) {
                    if(c[i] != '*') {
                        if(c[i + 1] != '*') {
                            if((c[i] - '0') * 10 + (c[i + 1] - '0') <= 26) {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            if(c[i] == '1') {
                                dp[i] += 9 * dp[i + 2];
                            } else if(c[i] == '2') {
                                dp[i] += 6 * dp[i + 2];
                            }
                        }
                    } else {
                        if(c[i + 1] != '*') {
                            if(c[i + 1] <= '6') {
                                dp[i] += 2 * dp[i + 2];
                            } else {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            dp[i] += 15 * dp[i + 2];
                        }
                    }
                }
                dp[i] %= MOD;
            }
        }
        return (int)dp[0];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numDecodings1("*"));
        // 9

        System.out.println(numDecodings2("1*"));
        // 18

        System.out.println(numDecodings("2*"));
        // 15

        System.out.println(numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
        // 196465252
    }
}