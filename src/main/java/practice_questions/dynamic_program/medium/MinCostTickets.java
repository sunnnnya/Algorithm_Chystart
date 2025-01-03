package practice_questions.dynamic_program.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dp.medium
 * @ClassName: MincostTickets
 * @Author: 丛虹羽
 * @Date: 2024/8/19 下午11:54
 * @Description: 最低票价
 *
 * https://leetcode.cn/problems/minimum-cost-for-tickets
 */
public class MinCostTickets {

    public static int MAXN = 366;

    public static int[] dp = new int[MAXN];

    public static int[] duration = {1, 7, 30};

    /**
     * 暴力递归
     *
     * @param days  日期数组
     * @param costs 花费数组
     * @return
     */
    public static int minCostTickets1(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    /**
     * 暴力递归的尝试策略函数
     *
     * @param days 日期数组
     * @param cost 花费数组
     * @param i    处理第 i 天的位置
     * @return     返回最小的花费
     */
    public static int f1(int[] days, int[] cost, int i) {
        if (i == days.length) {
            return 0;
        }
        // i下标：第days[i]天，有一场旅行
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            // k是方案的编号：0 1 2
            while(j < days.length && days[i] + duration[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, cost[k] + f1(days, cost, j));
        }
        return ans;
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜素哦
     *
     * @param days  日期数组
     * @param costs 花费数组
     * @return
     */
    public static int minCostTickets2(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return f2(days, costs, 0, dp);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param days 日期数组
     * @param cost 花费数组
     * @param i    处理第 i 天的位置
     * @return     返回最小的花费
     */
    public static int f2(int[] days, int[] cost, int i, int[] dp) {
        if(i == days.length) {
            return 0;
        }
        if(dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = 0, j = i; k < 3; k++) {
            while(j < days.length && days[i] + duration[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, cost[k] + f2(days, cost, j, dp));
        }
        dp[i] = ans;
        return ans;
    }

    /**
     * 动态规划
     *
     * @param days  日期数组
     * @param costs 花费数组
     * @return
     */
    public static int minCostTickets(int[] days, int[] costs) {
        int n = days.length;
        // dp[0, .. n - 1, n]
        Arrays.fill(dp, 0, n + 1, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < 3; k++) {
                while (j < n && days[i] + duration[k] > days[j]) {
                    j++;
                }
                // 实际上利用了已经计算的过的信息
                dp[i] = Math.min(dp[i], costs[k] + dp[j]);
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
        int[] days = new int[]{1,4,6,7,8,20};
        int[] cost = new int[]{2,7,15};
        System.out.println(minCostTickets(days, cost));
        // 11
    }
}