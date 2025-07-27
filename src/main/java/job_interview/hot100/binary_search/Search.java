package job_interview.hot100.binary_search;

/**
 * @BelongsPackage: job_interview.hot100.binary_search
 * @ClassName: Search
 * @Author: 丛虹羽
 * @Date: 2025/7/27 11:01
 * @Description: 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Search {

    /**
     * 二分搜索
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return int
     */
    public static int search(int[] nums, int target) {
        int minIndex = getMinIndex(nums);
        if(nums[minIndex] == target) {
            return minIndex;
        }
        int leftIndex = binarySearch(nums, target, 0, minIndex - 1);
        int rightIndex = binarySearch(nums, target, minIndex + 1, nums.length - 1);
        return leftIndex == -1 ? rightIndex : leftIndex;
    }

    /**
     * 普通的二分搜索数组
     *
     * @param nums 原始数组
     * @param target 目标值
     * @param l l index
     * @param r r index
     * @return
     */
    private static int binarySearch(int[] nums, int target, int l, int r) {
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] > target) {
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 按照最后一位元素进行比较
     *
     * @param nums 原始数组
     * @return int
     */
    private static int getMinIndex(int[] nums) {
        int l = 0, r = nums.length - 1, target = nums[nums.length - 1];
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] > target) {
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
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
        // 4
    }
}
