package job_interview.hot100.binary_search;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.hot100.binary_search
 * @ClassName: SearchRange
 * @Author: 丛虹羽
 * @Date: 2025/7/16 22:08
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchRange {

    /**
     * 二分搜索
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] searchRange(int[] nums, int target) {
        int idx = getTargetLeftIndex(nums, target);
        if(idx == nums.length || nums[idx] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{idx, getTargetLeftIndex(nums, target + 1) - 1};
    }

    /**
     * >= target 最左位置
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return 指定索引位置
     */
    private static int getTargetLeftIndex(int[] nums, int target) {
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
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
        // [3, 4]
    }
}
