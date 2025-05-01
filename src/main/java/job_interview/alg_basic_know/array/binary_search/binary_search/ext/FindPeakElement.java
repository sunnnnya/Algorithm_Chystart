package job_interview.alg_basic_know.array.binary_search.binary_search.ext;

/**
 * @package: leetcode.skill.array.binary_search
 * @author: chystart
 * @create: 2025-03-10 13:43
 * @description: 寻找峰值
 *
 * leetcode: https://leetcode.cn/problems/find-peak-element/description/
 **/
public class FindPeakElement {

    /**
     * 无序数组的 二分搜索
     *     重点：要找到可以二分的策略，一次砍一半！！
     *
     * @param nums 原始数组
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int l = 1, r = n - 2;
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            if(nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
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
        int[] arr = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println("找到最高的山峰的索引：" + findPeakElement(arr));
        // 找到最高的山峰的索引：5

        int[] arr1 = new int[]{1, 2, 3, 1};
        System.out.println("找到最高的山峰的索引：" + findPeakElement(arr1));
        // 找到最高的山峰的索引：2
    }
}
