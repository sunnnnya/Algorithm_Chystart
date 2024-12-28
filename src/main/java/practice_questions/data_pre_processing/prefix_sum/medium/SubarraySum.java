package practice_questions.data_pre_processing.prefix_sum.medium;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: SubarraySum
 * @Author: 丛虹羽
 * @Date: 2024/12/28 下午12:38
 * @Description: 和为 K 的子数组
 *
 * leetcode：https://leetcode.cn/problems/subarray-sum-equals-k/description/
 */
public class SubarraySum {

    /**
     * 构建前缀和个数信息
     *
     * @param nums 原始数组
     * @param k    指定和为 k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1: " + subarraySum(nums1, k1)); // 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Test Case 2: " + subarraySum(nums2, k2)); // 2

        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("Test Case 3: " + subarraySum(nums3, k3)); // 3

        int[] nums4 = {1, 2, 1, 2, 1};
        int k4 = 3;
        System.out.println("Test Case 4: " + subarraySum(nums4, k4)); // 4

        int[] nums5 = {0, 0, 0, 0};
        int k5 = 0;
        System.out.println("Test Case 5: " + subarraySum(nums5, k5)); // 10

        int[] nums6 = {1, 2, 3, 4, 5};
        int k6 = 15;
        System.out.println("Test Case 6: " + subarraySum(nums6, k6)); // 1

        int[] nums7 = {3, 4, -7, 1, 2, -1, 4, 2};
        int k7 = 5;
        System.out.println("Test Case 7: " + subarraySum(nums7, k7)); // 3
    }
}
