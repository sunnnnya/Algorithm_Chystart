package leetcode.hot100;

import java.util.Arrays;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-18 13:16
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 *
 * leetcode: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class SearchRange {

    /**
     * 二分搜索
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftIndex = getMoreEqualValIndex(nums, target);
        // 处理越界的情况
        if(leftIndex > nums.length - 1 || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }
        int rightIndex = getMoreEqualValIndex(nums, target + 1);
        return new int[]{leftIndex, rightIndex - 1};
    }

    /**
     * >= target 最左的位置
     *
     * @param arr    原始数组
     * @param target 目标值
     * @return       目标值索引
     */
    public static int getMoreEqualValIndex(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(arr[mid] >= target) {
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println("Result: " + Arrays.toString(searchRange(arr, 8)));
        // Result: [3, 4]
    }
}
