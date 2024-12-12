package practice_questions.slide_window.medium.not_fixed_length.min_length;

/**
 * @BelongsPackage: practice_questions.slide_window.medium.not_fixed_length.min_length
 * @ClassName: MinSubArrayLen
 * @Author: 丛虹羽
 * @Date: 2024/12/9 下午10:13
 * @Description: 长度最小的子数组
 *
 * leetcode： https://leetcode.cn/problems/minimum-size-subarray-sum
 */
public class MinSubArrayLen {

    /**
     * 长度最小的子数组
     *
     * @param target 目标值
     * @param nums   原始数组
     * @return       最小的数组长度
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1, sum = 0;
        for (int i = 0, left = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                // 当找到 >= target 时，进行答案的记录更新！！！
                ans = Math.min(ans, i - left + 1);
                // 然后窗口的左边界进行值的更新！！！
                sum -= nums[left++];
            }
        }
        return ans <= nums.length ? ans : 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, arr));
        // 2
    }
}