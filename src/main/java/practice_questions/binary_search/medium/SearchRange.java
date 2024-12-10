package practice_questions.binary_search.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.binary_search.medium
 * @ClassName: SearchRange
 * @Author: 丛虹羽
 * @Date: 2024/12/10 下午12:51
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 *
 * leetcode：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {

    /**
     * 找到 >= num 的最左边界应用
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int startIndex = lowerBound(nums, target);
        if(startIndex == nums.length || nums[startIndex] != target) {
            // startIndex == nums.length: 整个数组全部的数都 < target，导致 startIndex 一直向右
            // nums[startIndex] != target: 说明找到数不是 target
            return new int[]{-1, -1};
        }
        // 如果 target + 1 存在，返回 target + 1的最左位置，如果不存在返回的是 > target + 1的最左位置，都是挨着 target 的
        int endIndex = lowerBound(nums, target + 1) - 1;
        return new int[]{startIndex, endIndex};
    }

    /**
     * 找到 >= target 的最左元素
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return       >= target 最左的索引
     */
    private static int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
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
        int target = 8;
        System.out.println(Arrays.toString(searchRange(arr, target)));
        // [3, 4]
    }
}