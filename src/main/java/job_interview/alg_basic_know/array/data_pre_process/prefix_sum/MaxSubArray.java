package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: MaxSubArray
 * @Author: 丛虹羽
 * @Date: 2025/3/30 14:22
 * @Description: 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
public class MaxSubArray {

    /**
     * 前缀和的基本使用
     *
     * @param nums 原始数组
     * @return     最大的子数组的个数
     */
    public static int maxSubArray(int[] nums) {
        int minVal = 0, maxVal = Integer.MIN_VALUE;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            maxVal = Math.max(maxVal, sum - minVal);
            minVal = Math.min(minVal, sum);
        }
        return maxVal;
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
