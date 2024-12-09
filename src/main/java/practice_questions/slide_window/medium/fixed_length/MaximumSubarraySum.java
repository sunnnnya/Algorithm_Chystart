package practice_questions.slide_window.medium.fixed_length;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: MaximumSubarraySum
 * @Author: 丛虹羽
 * @Date: 2024/12/8 下午2:54
 * @Description: 长度为 K 子数组中的最大和
 *
 * 一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 *      子数组的长度是 k，且子数组中的所有元素 各不相同
 *
 * leetcode： https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */
public class MaximumSubarraySum {

    /**
     * 定长滑动窗口 + 哈希表
     *
     * @param nums 原始数组
     * @param k    窗口的宽度
     * @return
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // >= 1
            sum += nums[i];
            if(i < k - 1) {
                continue;
            }
            if(map.size() == k) {
                max = Math.max(max, sum);
            }
            if(map.get(nums[i - k + 1]) > 1) {
                map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);
            } else {
                map.remove(nums[i - k + 1]);
            }
            sum -= nums[i - k + 1];
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 2, 9, 9, 9};
        System.out.println(maximumSubarraySum(arr, 3));
        // 15

        int[] arr1 = new int[]{4, 4, 4};
        System.out.println(maximumSubarraySum(arr1, 3));
        // 0
    }
}