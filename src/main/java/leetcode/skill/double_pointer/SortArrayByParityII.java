package leetcode.skill.double_pointer;

import java.util.Arrays;

/**
 * @package: leetcode.skill.double_pointer
 * @author: chystart
 * @create: 2025-03-06 20:32
 * @description: 按奇偶排序数组 II
 *
 * leetcode： https://leetcode.cn/problems/sort-array-by-parity-ii/description/
 **/
public class SortArrayByParityII {

    /**
     * 双指针：
     *   最开始偶数指针定位 0，奇数指针定位 1，从数组的最后位置不断发货 -> even += 2 | odd += 2
     *
     * @param nums 原始数组
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums;
        }
        int even = 0;
        int odd = 1;
        while(even < n && odd < n) {
            if((nums[n - 1] & 1) == 1) {
                swap(nums, n - 1, odd);
                odd += 2;
            } else {
                swap(nums, n - 1, even);
                even += 2;
            }
        }
        return nums;
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
        int[] arr = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
        //

        int[] arr1 = new int[]{2, 3};
        System.out.println(Arrays.toString(sortArrayByParityII(arr1)));
        //
    }
}
