package job_interview.code_top.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.code_top.array
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2025/5/8 09:46
 * @Description: 两数之和
 * https://leetcode.cn/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(mp.containsKey(target - nums[i])) {
                return new int[]{mp.get(target - nums[i]), i};
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
        // [0, 1]
    }
}
