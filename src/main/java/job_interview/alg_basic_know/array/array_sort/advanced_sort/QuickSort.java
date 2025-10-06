package job_interview.alg_basic_know.array.array_sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.sort.advanced_sort
 * @ClassName: QuickSort
 * @Author: 丛虹羽
 * @Date: 2025/3/26 11:43
 * @Description: 快速排序
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param nums 原始数组
     */
    public static void quickSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     *
     * @param nums  原始数组
     * @param l    l index
     * @param r    r index
     */
    public static void quickSort(int[] nums, int l, int r) {
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
     * @param l   l index
     * @param r   r index
     * @return 返回 == target 的左边界和右边界
     */
    private static int[] partition(int[] nums, int l, int r) {
        int index = l, less = l, more = r, target = nums[r];
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
     * 交换两个数
     *
     * @param nums 原始数组
     * @param i    i index
     * @param j    j index
     */
    public static void swap(int[] nums, int i, int j) {
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
        int[] nums = new int[]{10, 2, 3, 1, 5, 7, 12, 21};
        System.out.println("before quick_sort: " + Arrays.toString(nums));
        // before quick_sort: [10, 2, 3, 1, 5, 7, 12, 21]
        quickSort(nums);
        System.out.println("after quick_sort: " + Arrays.toString(nums));
        // after quick_sort: [1, 2, 3, 5, 7, 10, 12, 21]
    }
}