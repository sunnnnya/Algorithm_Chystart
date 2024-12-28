package practice_questions.data_pre_processing.prefix_sum.easy;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.easy
 * @ClassName: LongestSubArraySumEqualsAim
 * @Author: 丛虹羽
 * @Date: 2024/12/28 下午12:16
 * @Description: 返回无序数组中累加和为 aim 的最长子数组长度
 *
 * leetcode： https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/description/
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
        HashMap<Integer, Integer> map = new HashMap<>();
        // 一定要塞入这样一条记录，因为 nums = {5}、aim = 5 此时就会查到 前缀和为 0 的下标 -1，结果等于 0 - (-1) = 1
        map.put(0, -1);
        int ans = 0;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - aim)) {
                ans = Math.max(ans, i - map.get(sum - aim));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
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