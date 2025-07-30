package job_interview.hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: Rob
 * @Author: 丛虹羽
 * @Date: 2025/7/30 21:58
 * @Description: 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rob {

    /**
     * 记忆化搜索
     *
     * @param nums 原始数组
     * @return int
     */
    public static int rob1(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n - 1, nums, cache);
    }

    /**
     * 递归含义：
     *  表示从 0 ~ pos 可以偷的最大钱数
     *
     * @param pos 当前下标位置
     * @param nums 原始数组
     * @param cache 标记数组
     * @return 最大可偷金额数
     */
    private static int dfs(int pos, int[] nums, int[] cache) {
        if(pos < 0) {
            return 0;
        }
        if(cache[pos] != -1) {
            return cache[pos];
        }
        cache[pos] = Math.max(dfs(pos - 1, nums, cache), dfs(pos - 2, nums, cache) + nums[pos]);
        return cache[pos];
    }

    /**
     * 动态规划版本
     *
     * @param nums 原始数组
     * @return int
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
        // 12
    }
}
