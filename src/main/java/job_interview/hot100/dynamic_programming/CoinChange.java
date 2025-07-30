package job_interview.hot100.dynamic_programming;


import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: CoinChange
 * @Author: 丛虹羽
 * @Date: 2025/7/30 23:11
 * @Description: 零钱兑换
 * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class CoinChange {

    /**
     * 动态规划版本(记忆点 + 高度总结之后的版本)
     *
     * @param coins 硬币数组
     * @param amount 金额
     * @return 最小凑成金额数量
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                if(dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        int total = 11;
        System.out.println(coinChange(nums, total));
        // 3
    }
}
