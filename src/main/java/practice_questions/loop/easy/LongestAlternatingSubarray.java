package practice_questions.loop.easy;

/**
 * @BelongsPackage: practice_questions.loop.easy
 * @ClassName: LongestAlternatingSubarray
 * @Author: 丛虹羽
 * @Date: 2025/1/6 下午11:23
 * @Description: 最长奇偶子数组
 *
 * leetcode: https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold
 */
public class LongestAlternatingSubarray {

    /**
     * 分组循环O(N)
     *
     * @param nums      原始数组
     * @param threshold 阈值
     * @return
     */
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int i = 0, ans = -1, n = nums.length;
        while (i < n) {
            if(nums[i] > threshold || (nums[i] & 1) == 1) {
                i++;
                continue;
            }
            int start = i;
            i++;
            while (i < n && nums[i] <= threshold && nums[i - 1] % 2 != nums[i] % 2) {
                i++;
            }
            ans = Math.max(ans, i - start);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4};
        int threshold = 5;
        System.out.println(longestAlternatingSubarray(nums, threshold));
        // 3
    }
}