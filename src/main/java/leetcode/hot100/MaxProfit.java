package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-22 15:51
 * @description: 买卖股票的最佳时机
 *
 * leetcode: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class MaxProfit {

    /**
     * 记录最小票价
     *   思路：使用一个变量（minPrice）记录当前遍历到的值（nums[i]）之前的最小值，Math.Max(ans, nums[i] - minPrice)就是答案！！
     *
     * @param prices 价格
     * @return 票数的价格
     */
    public static int maxProfit(int[] prices) {
        int ans = 0, minPrice = prices[0];
        for(int price : prices) {
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("Result: " + maxProfit(arr));
        // Result: 5

        int[] arr1 = new int[]{7, 6, 4, 3, 1};
        System.out.println("Result: " + maxProfit(arr1));
        // Result: 0
    }
}
