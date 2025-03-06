package leetcode.hot100;

import java.util.Arrays;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 22:01
 * @description: 下一个排列
 *
 * leetcode: https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class NextPermutation {

    /**
     * 模拟
     *
     * @param nums 原始数组
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个逆序对 nums[i] < nums[i + 1]，如果是 3 2 1 的话，循环之后 i -> -1，直接整个逆序
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            // 从最右侧开始找到第一个 > nums[i] 的值
            while(j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
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
     * 数组的逆序
     *
     * @param nums  原始数组
     * @param start 起始 index
     */
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 3, 2]

        int[] arr1 = new int[]{3, 2, 1};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1));
        // [1, 2, 3]

        int[] arr2 = new int[]{1, 1, 5};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2));
        // [1, 5, 1]
    }
}
