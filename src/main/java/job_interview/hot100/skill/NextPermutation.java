package job_interview.hot100.skill;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.skill
 * @ClassName: NextPermutation
 * @Author: 丛虹羽
 * @Date: 2025/7/13 10:09
 * @Description: 下一个排列
 * https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class NextPermutation {

    /**
     * 技巧，小背诵就可以
     *
     * @param nums 原始数组
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i > 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 交换两个数
     *
     * @param nums 原始数组
     * @param i    i 下标索引
     * @param j    j 下标索引
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 直接反转，因为一定是降序的
     *
     * @param nums 原始数组
     * @param start 开始反转的索引位置
     */
    public static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        // [1, 2, 3]

        int[] nums1 = new int[]{1,1,5};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
        // [1, 5, 1]
    }
}
