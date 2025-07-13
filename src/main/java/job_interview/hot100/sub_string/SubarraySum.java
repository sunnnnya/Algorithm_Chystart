package job_interview.hot100.sub_string;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.hot100.sub_string
 * @ClassName: SubarraySum
 * @Author: 丛虹羽
 * @Date: 2025/7/13 16:11
 * @Description: 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class SubarraySum {

    /**
     * 前缀和统计
     *
     * @param nums 原始数组
     * @param k 和为 k
     * @return 统计和为 k 的总个数
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
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum(nums, 2));
        // 2
    }
}
