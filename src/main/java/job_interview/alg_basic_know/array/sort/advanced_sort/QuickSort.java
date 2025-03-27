package job_interview.alg_basic_know.array.sort.advanced_sort;

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
     * @param arr  原始数组
     * @param L    L index
     * @param R    R index
     */
    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        int[] p = partition(arr, L, R);
        quickSort(arr, L, p[0] - 1);
        quickSort(arr, p[1] + 1, R);
    }

    /**
     * 荷兰国旗问题
     *
     * @param arr 原始数组
     * @param l   l index
     * @param r   r index
     * @return 返回 == target 的左边界和右边界
     */
    public static int[] partition(int[] arr, int l, int r) {
        int less = l, more = r, index = l, target = arr[r];
        while(index <= more) {
            if(arr[index] < target) {
                swap(arr, index++, less++);
            } else if(arr[index] > target) {
                swap(arr, index, more--);
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
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        // [1, 2, 3, 5, 7, 10, 12, 21]
    }
}
