package job_interview.alg_basic_know.array.data_pre_process.prefix_sum;

import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.data_pre_process.prefix_sum
 * @ClassName: FindMaxLength
 * @Author: 丛虹羽
 * @Date: 2025/4/17 14:16
 * @Description: 连续数组
 * https://leetcode.cn/problems/contiguous-array/description/
 */
public class FindMaxLength {

    /**
     * 前缀和数组的使用场景
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int ans = 0;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(mp.containsKey(sum)) {
                ans = Math.max(ans, i - mp.get(sum));
            }
            if(!mp.containsKey(sum)) {
                mp.put(sum, i);
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
        int[] nums = new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("maxLength: " + findMaxLength(nums));
        // maxLength: 6
    }
}
