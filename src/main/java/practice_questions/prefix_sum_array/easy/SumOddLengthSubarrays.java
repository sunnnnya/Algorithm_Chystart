package practice_questions.prefix_sum_array.easy;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: SumOddLengthSubarrays
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午10:22
 * @Description: 所有奇数长度子数组的和
 *
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和。
 *
 * leetcode：https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOddLengthSubarrays {

    /**
     * 前缀和数组的基本使用
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        int ans = arr[n - 1];
        // 枚举 奇数 个数
        for (int i = 2; i < n; i += 2) {
            // 进行 边界 累加
            for (int j = 0; j < n - i; j++) {
                if (j == 0) {
                    ans += arr[j + i];
                } else {
                    ans += arr[j + i] - arr[j - 1];
                }
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
        // 58

        int[] arr1 = new int[]{1,2};
        System.out.println(sumOddLengthSubarrays(arr1));
        // 3

        int[] arr2 = new int[]{10,11,12};
        System.out.println(sumOddLengthSubarrays(arr2));
        // 66
    }
}
