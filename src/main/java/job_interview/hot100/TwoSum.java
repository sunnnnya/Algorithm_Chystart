package job_interview.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsPackage: job_interview.hot100
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2025/7/12 21:05
 * @Description: 两数之和
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class TwoSum {

    /**
     * 哈希表
     *
     * @param nums 原始数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(mp.containsKey(target - nums[i])) {
                return new int[]{i, mp.get(target - nums[i])};
            }
            mp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
        // [1, 0]
    }
}
