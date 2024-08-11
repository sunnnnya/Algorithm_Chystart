package practice_questions.binary_search.easy;

/**
 * @BelongsPackage: practice_questions.binary_search.easy
 * @ClassName: MaximumCount
 * @Author: 丛虹羽
 * @Date: 2024/8/11 下午8:52
 * @Description: 正整数和负整数的最大计数
 *
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 *
 * leetcode:https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer
 */
public class MaximumCount {

    /**
     * 使用二分搜索找到负数的最右边界
     *
     * @param nums
     * @return
     */
    public static int maximumCount(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int L = 0;
        int R = nums.length - 1;
        int lessMaxIndex = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] < 0) {
                lessMaxIndex = mid;
                L = mid + 1;
            } else if (nums[mid] >= 0) {
                R = mid - 1;
            }
        }
        int ans = lessMaxIndex;
        for (int i = lessMaxIndex + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                lessMaxIndex++;
            }
        }
        // ans -> 负数的最大右边界
        // lessMaxIndex -> 0的最右边界
        return Math.max(ans == -1 ? 0 : ans + 1, nums.length - lessMaxIndex - 1);
    }

    /**
     * 使用计数的方式进行统计
     *
     * @param arr
     * @return
     */
    public static int maximumCount1(int[] arr) {
        int[] number = new int[2];
        for (int num : arr) {
            if (num < 0) {
                number[0]++;
            }
            if (num > 0) {
                number[1]++;
            }
        }
        return Math.max(number[0], number[1]);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-1,-1,1,2,3};
        System.out.println(maximumCount(arr));
        // 3

        int[] arr1 = new int[]{5,20,66,1314};
        System.out.println(maximumCount(arr1));
        // 3

        int[] arr2 = new int[]{-3,-2,-1,0,0,1,2};
        System.out.println(maximumCount(arr2));
        // 3

        int[] arr3 = new int[]{-4, -3, -2, -1, 0, 1, 3, 4, 6, 9};
        System.out.println(maximumCount(arr3));
        // 1
    }
}
