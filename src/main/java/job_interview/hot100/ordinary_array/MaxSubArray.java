package job_interview.hot100.ordinary_array;

/**
 * @BelongsPackage: job_interview.hot100.ordinary_array
 * @ClassName: MaxSubArray
 * @Author: 丛虹羽
 * @Date: 2025/7/13 17:54
 * @Description: 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxSubArray {

    /**
     * 维护最小的前缀和，当前前缀和 - 最小前缀和 = 最大子数组
     *
     * @param nums 原始数组
     * @return Integer
     */
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, minVal = 0;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum - minVal);
            minVal = Math.min(sum, minVal);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        // 6
    }
}
