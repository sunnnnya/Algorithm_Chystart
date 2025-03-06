package leetcode.hot100;

import java.util.Arrays;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 20:26
 * @description: 颜色分类
 *
 * leetcode: https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class SortColors {

    /**
     * 荷兰国旗问题
     *
     * @param nums 原始数组
     */
    public static void sortColors(int[] nums) {
        int less = 0, more = nums.length - 1, index = 0, target = 1;
        // == 的时候也要判断，因为这个结果还没有判断呢！！！
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
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        // [0, 0, 1, 1, 2, 2]
    }
}
