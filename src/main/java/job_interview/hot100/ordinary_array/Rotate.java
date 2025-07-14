package job_interview.hot100.ordinary_array;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.ordinary_array
 * @ClassName: Rotate
 * @Author: 丛虹羽
 * @Date: 2025/7/14 12:39
 * @Description: 轮转数组
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Rotate {

    /**
     * 反转数组实现
     *
     * @param nums 原始数组
     * @param k k 位
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // loop
        k %= n;
        // reverse
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * 指定索引位置进行翻转
     *
     * @param nums 原始数组
     * @param i    i 下标位置
     * @param j    j 下标位置
     */
    private static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        // [5, 6, 7, 1, 2, 3, 4]
    }
}
