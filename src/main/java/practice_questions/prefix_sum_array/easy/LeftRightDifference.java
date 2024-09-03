package practice_questions.prefix_sum_array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: LeftRightDifference
 * @Author: 丛虹羽
 * @Date: 2024/9/3 下午9:37
 * @Description: 左右元素和的差值
 *
 * 给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
 * answer.length == nums.length
 * answer[i] = |leftSum[i] - rightSum[i]|
 * 其中：
 *      leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 *      rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回数组 answer
 *
 * leetcode：https://leetcode.cn/problems/left-and-right-sum-differences
 */
public class LeftRightDifference {

    /**
     * 前缀和数组的基本使用
     *
     * @param nums
     * @return
     */
    public static int[] leftRightDifference(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return new int[]{0};
        }
        for (int i = 1; i < N; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int[] ans = new int[N];
        for (int k = 0; k < N; k++) {
            if (k == 0) {
                ans[k] = Math.abs(nums[N - 1] - nums[k]);
            }
            if (k == N - 1) {
                ans[k] = Math.abs(nums[N - 2]);
            }
            if (k != 0 && k != N - 1){
                ans[k] = Math.abs(nums[k - 1] - (nums[N - 1] - nums[k]));
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
        int[] arr = new int[]{10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
        // [15, 1, 11, 22]

        int[] arr1 = new int[]{1};
        System.out.println(Arrays.toString(leftRightDifference(arr1)));
        // [0]
    }
}