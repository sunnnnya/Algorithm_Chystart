package practice_questions.dp.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dp.medium
 * @ClassName: MincostTickets
 * @Author: 丛虹羽
 * @Date: 2024/8/19 下午11:54
 * @Description: 最低票价
 *
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *      火车票有 三种不同的销售方式 ：
 *          一张 为期一天 的通行证售价为 costs[0] 美元；
 *          一张 为期七天 的通行证售价为 costs[1] 美元；
 *          一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 *
 * https://leetcode.cn/problems/minimum-cost-for-tickets
 */
public class MinCostTickets {

    public static int MAXN = 366;

    public static int[] dp = new int[MAXN];

    public static int[] duration = {1, 7, 30};

    /**
     * 暴力尝试
     *
     * @param days
     * @param costs
     * @return
     */
    public int minCostTickets1(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    /**
     * days[i..... 最小花费是多少
     *
     * @param days
     * @param cost
     * @param i
     * @return
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
     * 使用动态规划
     *
     * @param days
     * @param costs
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
