package job_interview.code_top.array.binary_search;

/**
 * @BelongsPackage: job_interview.code_top.array.binary_search
 * @ClassName: FindPeakElement
 * @Author: 丛虹羽
 * @Date: 2025/5/17 14:54
 * @Description: 寻找峰值
 * https://leetcode.cn/problems/find-peak-element/description/
 */
public class FindPeakElement {

    /**
     * 拓展二分搜索：找到可以二分的点
     *
     * @param nums 原始数组
     * @return int
     */
    static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;
        int l = 1, r = n - 2;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else if(nums[mid] < nums[mid - 1]) {
                r = mid - 1;
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
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println("Index: " + findPeakElement(nums));
        // Index: 5
    }
}
