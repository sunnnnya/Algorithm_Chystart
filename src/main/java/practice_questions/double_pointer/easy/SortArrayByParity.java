package practice_questions.double_pointer.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.double_pointer.easy
 * @ClassName: SortArrayByParityII
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午12:22
 * @Description: 按奇偶排序数组
 *
 * leetcode: https://leetcode.cn/problems/sort-array-by-parity-ii
 */
public class SortArrayByParity {
    /**
     * 小技巧：
     *      一直定位到最后一位数，不断和前面的代表 奇数 和 偶数 的索引的数组值进行交换
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1, n = nums.length;
        while(even < n && odd < n) {
            if((nums[n - 1] & 1) == 1) {
                swap(nums, odd, n - 1);
                odd += 2;
            } else {
                swap(nums, even, n - 1);
                even += 2;
            }
        }
        return nums;
    }

    /**
     * 交换数组中两个索引的元素
     *
     * @param arr 原始数组
     * @param i   i 下标
     * @param j   j 下标
     */
    private static void swap(int[] arr, int i, int j) {
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
        int[] arr = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
        // [2, 7, 4, 5]
    }
}