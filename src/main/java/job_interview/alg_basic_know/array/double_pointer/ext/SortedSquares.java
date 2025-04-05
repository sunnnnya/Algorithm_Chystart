package job_interview.alg_basic_know.array.double_pointer.ext;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.double_pointer.ext
 * @ClassName: SortedSquares
 * @Author: 丛虹羽
 * @Date: 2025/4/6 00:02
 * @Description: 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 */
public class SortedSquares {

    /**
     * 相向双指针
     *
     * @param nums 原始数组
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, index = nums.length - 1;
        int[] ans = new int[nums.length];
        while(l <= r) {
            int leftNumberABS = Math.abs(nums[l]);
            int rightNumberABS = Math.abs(nums[r]);
            ans[index--] = leftNumberABS > rightNumberABS ? (int)Math.pow(Math.abs(nums[l++]), 2) : (int)Math.pow(Math.abs(nums[r--]), 2);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
        // [0, 1, 9, 16, 100]
    }
}
