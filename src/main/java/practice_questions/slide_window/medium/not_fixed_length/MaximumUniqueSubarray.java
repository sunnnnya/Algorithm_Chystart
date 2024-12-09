package practice_questions.slide_window.medium.not_fixed_length;

import java.util.HashSet;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: MaximumUniqueSubarray
 * @Author: 丛虹羽
 * @Date: 2024/12/9 上午11:41
 * @Description: 删除子数组的最大得分
 *
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * leetcode： https://leetcode.cn/problems/maximum-erasure-value
 */
public class MaximumUniqueSubarray {

    /**
     * 不定长滑动窗口
     *
     * @param nums
     * @return
     */
    public static int maximumUniqueSubarray(int[] nums) {
        // 这里使用 CopyOnWriteArraySet 会 timeout
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, max = 0;
        for (int i = 0, left = 0; i < nums.length; i++) {
            while(set.contains(nums[i])) {
                sum -= nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[i]);
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(arr));
        // 17

        int[] arr1 = new int[]{5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(arr1));
        // 8
    }
}
