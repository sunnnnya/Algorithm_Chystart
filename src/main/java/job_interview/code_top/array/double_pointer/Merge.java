package job_interview.code_top.array.double_pointer;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array.double_pointer
 * @ClassName: Merge
 * @Author: 丛虹羽
 * @Date: 2025/5/14 16:35
 * @Description: 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class Merge {

    /**
     * 数组合并，可能会出现
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        // [1, 2, 2, 3, 5, 6]
    }
}
