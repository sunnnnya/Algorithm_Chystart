package job_interview.code_top.array.binary_search;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.binary_search
 * @ClassName: SearchRange
 * @Author: 丛虹羽
 * @Date: 2025/3/25 14:38
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class SearchRange {

    /**
     * 二分搜索：
     *  技巧：利用已有函数，再次查询 >= target + 1 的最左位置的数
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return       索引数组下标
     */
    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = moreEqualTarget(nums, target);
        if(leftIndex == nums.length || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{leftIndex, moreEqualTarget(nums, target + 1) - 1};
    }

    /**
     * >= target 的最左位置
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return 索引位置
     */
    public static int moreEqualTarget(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
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
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println("Result: " + Arrays.toString(searchRange(nums, 8)));
        // Result: [3, 4]
    }
}
