package practice_questions.slide_window.medium.not_fixed_length.max_length;

/**
 * @BelongsPackage: practice_questions.slide_window.medium.not_fixed_length
 * @ClassName: LongestSubarray
 * @Author: 丛虹羽
 * @Date: 2024/12/9 下午9:27
 * @Description: 删掉一个元素以后全为 1 的最长子数组
 *
 * leetcode: https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubarray {
    /**
     * 不定长滑动窗口 + 哈希统计
     * 要抽象好左边界收缩的条件
     *
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        int[] bit = new int[2];
        int max = 0;
        for(int i = 0, left = 0; i < nums.length; i++) {
            while(nums[i] == 0 && bit[nums[i]] > 0) {
                bit[nums[left++]]--;
            }
            bit[nums[i]]++;
            max = Math.max(max, i - left + 1);
        }
        // 减掉要删除的 0
        return max - 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
        // 5

        int[] arr1 = new int[]{1,1,0,1};
        System.out.println(longestSubarray(arr1));
        // 3

        int[] arr2 = new int[]{1,1,1};
        System.out.println(longestSubarray(arr2));
        // 2

        int[] arr3 = new int[]{0, 0};
        System.out.println(longestSubarray(arr3));
        // 0
    }
}