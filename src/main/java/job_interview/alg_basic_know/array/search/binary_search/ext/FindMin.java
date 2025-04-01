package job_interview.alg_basic_know.array.search.binary_search.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.search.binary_search.ext
 * @ClassName: FindMin
 * @Author: 丛虹羽
 * @Date: 2025/4/1 22:27
 * @Description: 寻找旋转排序数组中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMin {

    /**
     * 二分策略：和最后的一个值进行比较
     *
     * @param nums 原始数组
     * @return
     */
    public static int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, target = nums[nums.length - 1];
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
        // 0
    }
}
