package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: SubarraySum
 * @Author: 丛虹羽
 * @Date: 2025/3/28 22:01
 * @Description: 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SubArraySum {

    /**
     * 前缀和数组的使用技巧
     *
     * @param nums 原始数组
     * @param k    和为 k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
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
        int[] nums = new int[]{1,2,3};
        System.out.println(subarraySum(nums, 3));
        // 2

        int[] nums1 = new int[]{1, 1, 1};
        System.out.println(subarraySum(nums1, 2));
        // 2
    }
}
