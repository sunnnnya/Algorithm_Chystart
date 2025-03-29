package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: LongestSubarrayWithEqualPositivesAndNegatives
 * @Author: 丛虹羽
 * @Date: 2025/3/29 11:19
 * @Description: 求数组中出现正数和负数个数相同的最长子数组长度
 * https://www.nowcoder.com/practice/545544c060804eceaed0bb84fcd992fb
 */
public class LongestSubarrayWithEqualPositivesAndNegatives {

    /**
     * 前缀和的基本使用
     *
     * @param nums 原始数组
     * @return 最长子数组长度
     */
    public static int longestSubarrayWithEqualPositivesAndNegatives(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int[] arr = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] > 0 ? 1 : (nums[i] == 0 ? 0 : -1);
        }
        for(int i = 0, sum = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                mx = Math.max(mx, i - map.get(sum));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return mx;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 0, 1, 2, -2, -4, -9};
        System.out.println(longestSubarrayWithEqualPositivesAndNegatives(arr));
        // 7
    }
}
