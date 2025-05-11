package job_interview.code_top.array.array_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array.sort
 * @ClassName: SortArray
 * @Author: 丛虹羽
 * @Date: 2025/5/9 14:52
 * @Description: 排序数组
 * https://leetcode.cn/problems/sort-an-array/description/
 */
public class SortArray {

    /**
     * 快速排序
     *
     * @param nums 原始数组
     * @return int[]
     */
    static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums 原始数组
     * @param l    l
     * @param r    r
     */
    static void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return ;
        }
        swap(nums, l + (int)(Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        quickSort(nums, l, p[0] - 1);
        quickSort(nums, p[1] + 1, r);
    }

    /**
     * 荷兰国旗问题
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     * @return int[]
     */
    static int[] partition(int[] nums, int l, int r) {
        int target = nums[r], less = l, index = l, more = r;
        while(index <= more) {
            if(nums[index] < target) {
                swap(nums, index++, less++);
            } else if(nums[index] > target) {
                swap(nums, index, more--);
            } else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    /**
     * 交换两个下标对应的数
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(sortArray(nums)));
        // [0, 0, 1, 1, 2, 5]
    }
}
