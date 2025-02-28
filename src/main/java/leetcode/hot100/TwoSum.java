package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: TwoSum
 * @Author: 丛虹羽
 * @Date: 2025/2/28 22:09
 * @Description: 两数之和
 *
 * leetcode: https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class TwoSum {

    /**
     * 两数之和
     *  1: 使用 哈希表 进行处理
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println("Result: " + Arrays.toString(twoSum(arr, 9)));
        // Result: [1, 0]

        int[] arr1 = new int[]{3, 2, 4};
        System.out.println("Result: " + Arrays.toString(twoSum(arr1, 6)));
        // Result: [2, 1]

        int[] arr2 = new int[]{3, 3};
        System.out.println("Result: " + Arrays.toString(twoSum(arr2, 6)));
        // Result: [1, 0]
    }
}
