package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: LongestSubArraySumEqualsAim
 * @Author: 丛虹羽
 * @Date: 2025/3/28 22:25
 * @Description: 返回无序数组中累加和为 aim 的最长子数组长度
 * https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/description/
 */
public class LongestSubArraySumEqualsAim {

    /**
     * 使用前缀和完成最长子数组长度
     *
     * @param nums 原始数组
     * @param aim  目标值
     * @return
     */
    public static int longestSubArraySumEqualsAim(int[] nums, int aim) {
        // 指定前缀和最早出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mx = -1;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - aim)) {
                mx = Math.max(mx, i - map.get(sum - aim));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return mx;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, -1, 5, -2, 3};
        int aim1 = 3;
        System.out.println("Test Case 1: " + longestSubArraySumEqualsAim(nums1, aim1)); // 4

        int[] nums2 = {-2, -1, 2, 1};
        int aim2 = 1;
        System.out.println("Test Case 2: " + longestSubArraySumEqualsAim(nums2, aim2)); // 2

        int[] nums3 = {1, 2, 3};
        int aim3 = 6;
        System.out.println("Test Case 3: " + longestSubArraySumEqualsAim(nums3, aim3)); // 3

        int[] nums4 = {1, 2, -3, 3, -2, 4};
        int aim4 = 4;
        System.out.println("Test Case 4: " + longestSubArraySumEqualsAim(nums4, aim4)); // 4

        int[] nums5 = {0, 0, 0, 0};
        int aim5 = 0;
        System.out.println("Test Case 5: " + longestSubArraySumEqualsAim(nums5, aim5)); // 4

        int[] nums6 = {5};
        int aim6 = 5;
        System.out.println("Test Case 6: " + longestSubArraySumEqualsAim(nums6, aim6)); // 1
    }
}
