package practice_questions.slide_window.medium.not_fixed_length.max_length;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: practice_questions.slide_window.medium.not_fixed_length
 * @ClassName: MaxSubarrayLength
 * @Author: 丛虹羽
 * @Date: 2024/12/9 下午4:43
 * @Description: 最多 K 个重复元素的最长子数组
 *
 * leetcode：https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency
 */
public class MaxSubarrayLength {

    /**
     * 不定长滑动窗口 + 哈希表
     *
     * @param nums 原始数组
     * @param k    至少出现的次数
     * @return
     */
    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, left = 0; i < nums.length; i++) {
            while(map.getOrDefault(nums[i], 0) >= k) {
                if(map.get(nums[left]) > 1) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                } else {
                    map.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLength(arr, 2));
        // 6

        int[] arr1 = new int[]{1,2,1,2,1,2,1,2};
        System.out.println(maxSubarrayLength(arr1, 1));
        // 2

        int[] arr2 = new int[]{5,5,5,5,5,5,5};
        System.out.println(maxSubarrayLength(arr2, 4));
        // 4
    }
}