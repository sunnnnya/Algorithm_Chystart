package practice_questions.prefix_sum_array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: RunningSum
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午10:14
 * @Description: 一维数组的动态和
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * leetcode：https://leetcode.cn/problems/running-sum-of-1d-array
 */
public class RunningSum {

    /**
     * 前缀和基础模板
     *
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(runningSum(arr1)));
        // [1, 3, 6, 10]

        int[] arr2 = new int[]{1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(arr2)));
        // [1, 2, 3, 4, 5]

        int[] arr3 = new int[]{3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum(arr3)));
        // [3, 4, 6, 16, 17]
    }
}
