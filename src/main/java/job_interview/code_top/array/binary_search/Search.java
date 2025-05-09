package job_interview.code_top.array.binary_search;

/**
 * @BelongsPackage: job_interview.code_top.array.binary_search
 * @ClassName: Search
 * @Author: 丛虹羽
 * @Date: 2025/5/9 16:56
 * @Description: 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 */
public class Search {

    /**
     * 二分搜索的拓展
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return int
     */
    static int search(int[] nums, int target) {
        int minIdx = findMin(nums);
        if (nums[minIdx] == target) {
            return minIdx;
        }
        int leftIdx = getMidVal(nums, 0, minIdx - 1, target);
        int rightIdx = getMidVal(nums, minIdx + 1, nums.length - 1, target);
        return leftIdx != -1 ? leftIdx : rightIdx;
    }

    /**
     * 标准二分数组
     *
     * @param nums   原始数组
     * @param l      l index
     * @param r      r index
     * @param target target number
     * @return
     */
    static int getMidVal(int[] nums, int l, int r, int target) {
        // 越界直接返回 -1
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 获取数组中的最小值
     *
     * @param nums 原始数组
     * @return int
     */
    static int findMin(int[] nums) {
        int len = nums.length;
        int target = nums[len - 1];
        int l = 0, r = len - 1;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
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
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
        // 4
    }
}
