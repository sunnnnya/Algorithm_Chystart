package practice_questions.merge_sort.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.merge_sort.medium
 * @ClassName: SortArray
 * @Author: 丛虹羽
 * @Date: 2024/8/13 下午8:47
 * @Description: 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * leetcode：https://leetcode.cn/problems/sort-an-array
 */
public class SortArray {

    /**
     * 归并排序的代码实现
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param l
     * @param r
     */
    public static void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return ;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    /**
     * 合并数组的过程
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        int p1 = l;
        int p2 = mid + 1;
        int index = 0;
        int[] help = new int[r - l + 1];
        while (p1 <= mid && p2 <= r) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < index; i++) {
            arr[l + i] = help[i];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(sortArray(arr)));
        // [1, 2, 3, 5]
    }
}
