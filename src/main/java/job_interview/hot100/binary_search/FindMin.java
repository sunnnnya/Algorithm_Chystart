package job_interview.hot100.binary_search;

/**
 * @BelongsPackage: job_interview.hot100.binary_search
 * @ClassName: FindMin
 * @Author: 丛虹羽
 * @Date: 2025/7/27 11:14
 * @Description: 寻找旋转排序数组中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class FindMin {

    /**
     * 找到可以进行比对的条件进行处理
     *
     * @param nums 原始数组
     * @return int
     */
    public static int findMin(int[] nums) {
        return nums[getMinIndex(nums)];
    }

    /**
     * 获取数组中的最小值
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
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));
        // 1

        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums1));
        // 0
    }
}
