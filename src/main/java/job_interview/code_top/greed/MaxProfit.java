package job_interview.code_top.greed;

/**
 * @BelongsPackage: job_interview.code_top.greed
 * @ClassName: MaxProfit
 * @Author: 丛虹羽
 * @Date: 2025/5/17 19:26
 * @Description: 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class MaxProfit {

    /**
     * 贪心
     *
     * @param prices 原始数组
     * @return int
     */
    static int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            ans += tmp > 0 ? tmp : 0;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("Result: " + maxProfit(nums));
        // Result: 7
    }
}
