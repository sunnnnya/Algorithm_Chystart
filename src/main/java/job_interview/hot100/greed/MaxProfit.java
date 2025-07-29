package job_interview.hot100.greed;

/**
 * @BelongsPackage: job_interview.hot100.greed
 * @ClassName: MaxProfit
 * @Author: 丛虹羽
 * @Date: 2025/7/29 23:57
 * @Description: 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxProfit {

    /**
     * 贪心策略
     *
     * @param prices 原始数组
     * @return int
     */
    public static int maxProfit(int[] prices) {
        int ans = 0, minValue = prices[0];
        for(int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        // 5
    }
}
