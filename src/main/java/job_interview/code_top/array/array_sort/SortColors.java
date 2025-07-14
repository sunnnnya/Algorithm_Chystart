package job_interview.code_top.array.array_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.ext.quick_sort_partition
 * @ClassName: sortColors
 * @Author: 丛虹羽
 * @Date: 2025/3/26 11:32
 * @Description: 经典颜色分类
 * https://leetcode.cn/problems/sort-colors/description/
 */
public class SortColors {

    /**
     * 荷兰国旗问题
     *
     * @param nums 原始数组
     */
    public static void sortColors(int[] nums) {
        int target = 1;
        int less = 0, more = nums.length - 1, index = 0;
        while(index <= more) {
            if(nums[index] < target) {
                swap(nums, index++, less++);
            } else if(nums[index] > target) {
                swap(nums, index, more--);
            } else {
                index++;
            }
        }
    }

    /**
     * 交换两个数
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("Result: " + Arrays.toString(nums));
        // Result: [0, 0, 1, 1, 2, 2]
    }
}
