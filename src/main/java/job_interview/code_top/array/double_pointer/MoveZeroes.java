package job_interview.code_top.array.double_pointer;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: MoveZeroes
 * @Author: 丛虹羽
 * @Date: 2025/5/8 15:53
 * @Description: 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 */
public class MoveZeroes {

    /**
     * 使用交换
     *
     * @param nums 原始数组
     */
    public static void moveZeroes1(int[] nums) {
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, left++);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 使用赋值
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[l++] = nums[i];
            }
        }
        Arrays.fill(nums, l, nums.length, 0);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        // [1, 3, 12, 0, 0]
    }
}
