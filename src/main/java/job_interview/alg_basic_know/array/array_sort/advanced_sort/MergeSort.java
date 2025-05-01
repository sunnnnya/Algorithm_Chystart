package job_interview.alg_basic_know.array.array_sort.advanced_sort;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.advance_sort
 * @ClassName: MergeSort
 * @Author: 丛虹羽
 * @Date: 2025/3/25 15:12
 * @Description: 归并排序
 *
 *  master公式：分析 等规模子问题 递归函数的时间复杂度的
 *       T(N) = a * (N / b) + O(N ^ d)
 *       log(b^a) < d = O(N^d)
 *       log(b^a) > d = O(N^log(b^a))
 *       log(b^a) = d = O(N^d * log N)
 *  举例：
 *       T(N) = 2 * (N / 2) + O(N ^ 1)
 *       a = 2、b = 2、d = 1
 *       log(2^2) = 1 == d -> O(N * logN) 下面递归的时间复杂度分析
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param nums 原始数组
     */
    public static void mergeSort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    /**
     * 递归函数的含义：[l, r]的范围要有序
     *
     * @param nums 原始数组
     * @param l    l index
     * @param r    r index
     */
    public static void process(int[] nums, int l, int r) {
        if(l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(nums, l, mid);
        process(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    /**
     * 合并的过程
     *
     * @param nums 原始数组
     * @param l    l index
     * @param mid  mid index
     * @param r    r index
     */
    private static void merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r) {
            help[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while(p2 <= r) {
            help[index++] = nums[p2++];
        }
        for(int i = 0; i < index; i++) {
            nums[l + i] = help[i];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 6, 7, 8, 10, 2, 1, -2};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        // [-2, 1, 1, 2, 2, 3, 6, 7, 8, 10]
    }
}
