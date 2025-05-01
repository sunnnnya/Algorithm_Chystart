package job_interview.alg_basic_know.array.binary_search.binary_search.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.binary_search.ext
 * @ClassName: Search
 * @Author: 丛虹羽
 * @Date: 2025/4/14 09:52
 * @Description: 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 */
public class Search {

    /**
     * 两次二分
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return
     */
    public static int search(int[] nums, int target) {
        int minIdx = findMin(nums);
        if(nums[minIdx] == target) {
            return minIdx;
        }
        if(target > nums[nums.length - 1]) {
            return lowerBound(nums, 0, minIdx - 1, target);
        }
        return lowerBound(nums, minIdx + 1, nums.length - 1, target);
    }

    /**
     * 返回最小值的 index
     *
     * @param nums 原始数组
     * @return
     */
    private static int findMin(int[] nums) {
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
     * 标准二分
     *
     * @param nums   原始数组
     * @param l      左边界
     * @param r      右边界
     * @param target 目标值
     * @return
     */
    private static int lowerBound(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] > target) {
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
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
