package job_interview.code_top.array;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: MergeII
 * @Author: 丛虹羽
 * @Date: 2025/5/2 14:17
 * @Description: 合并两个有序数组
 * https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class MergeII {

    /**
     * 数据合并问题
     *
     * @param nums1 数组1
     * @param m     数组1的长度
     * @param nums2 数组2
     * @param n     数组2的长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1, l2 = n - 1, l = m + n - 1;
        while(l2 >= 0) {
            if (l1 >= 0 && nums1[l1] > nums2[l2]) {
                nums1[l--] = nums1[l1--];
            } else {
                nums1[l--] = nums2[l2--];
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        // [1, 2, 2, 3, 5, 6]
    }
}
