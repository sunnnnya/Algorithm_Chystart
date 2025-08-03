package job_interview.hot100.dynamic_programming;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.dynamic_programming
 * @ClassName: LengthOfLIS
 * @Author: 丛虹羽
 * @Date: 2025/8/3 16:46
 * @Description: 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LengthOfLIS {

    /**
     * 类似暴力的方式进行处理，时间复杂度O(N^2)
     *
     * @param nums 原始数组
     * @return int
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        // 4
    }
}
