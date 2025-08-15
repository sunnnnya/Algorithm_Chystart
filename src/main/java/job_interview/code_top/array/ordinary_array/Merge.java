package job_interview.code_top.array.ordinary_array;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array.ordinary_array
 * @ClassName: Merge
 * @Author: 丛虹羽
 * @Date: 2025/8/15 17:53
 * @Description: 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class Merge {

    /**
     * 数组合并问题
     *
     * @param nums1 数组1
     * @param m     数组元素
     * @param nums2 数组2
     * @param n     数组元素
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        // [1, 2, 2, 3, 5, 6]
    }
}
