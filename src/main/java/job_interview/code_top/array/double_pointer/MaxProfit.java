package job_interview.code_top.array.double_pointer;

/**
 * @BelongsPackage: job_interview.code_top.array.double_pointer
 * @ClassName: MaxProfit
 * @Author: 丛虹羽
 * @Date: 2025/5/14 12:57
 * @Description: 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class MaxProfit {

    /**
     * 记录之前的最小值，然后之间获取到最大值
     *
     * @param prices 原始数组
     * @return int
     */
    static int maxProfit(int[] prices) {
        int ans = 0, minVal = prices[0];
        for(int p : prices) {
            ans = Math.max(ans, p - minVal);
            minVal = Math.min(p, minVal);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        // 5
    }
}
