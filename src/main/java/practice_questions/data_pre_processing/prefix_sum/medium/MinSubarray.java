package practice_questions.data_pre_processing.prefix_sum.medium;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: MinSubarray
 * @Author: 丛虹羽
 * @Date: 2024/12/30 下午12:58
 * @Description: 使数组和能被 P 整除
 *
 * leetcode： https://leetcode.cn/problems/make-sum-divisible-by-p/description/
 */
public class MinSubarray {

    /**
     * 前缀和 + 哈希表
     *
     * @param nums 原始数组
     * @param p    整数
     * @return
     */
    public static int minSubarray(int[] nums, int p) {
        int mod = 0;
        for(int num : nums) {
            mod = (mod + num) % p;
        }
        // 不需要去除直接返回
        if(mod == 0) {
            return 0;
        }
        // 哈希表：记录前缀和余数最晚出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = Integer.MAX_VALUE;
        for(int i = 0, cur = 0, find; i < nums.length; i++) {
            cur = (cur + nums[i]) % p;
            find = cur >= mod ? (cur - mod) : (cur + p - mod);
            if(map.containsKey(find)){
                ans = Math.min(ans, i - map.get(find));
            }
            map.put(cur, i);
        }
        return ans == nums.length ? -1 : ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试案例 1：数组和不能被 p 整除，但移除一个元素后满足
        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 6));
        // 预期结果：1 （移除子数组 [4]，剩余和 6 能被 6 整除）

        // 测试案例 2：数组和本身已经能被 p 整除
        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 5));
        // 修正预期结果：0 （数组和 10 已经能被 5 整除，无需移除任何子数组）

        // 测试案例 3：无法找到符合条件的子数组
        System.out.println(minSubarray(new int[]{1, 2, 3}, 7));
        // 预期结果：-1 （无法找到满足条件的子数组）

        // 测试案例 4：只有一个元素，且该元素本身不能被 p 整除
        System.out.println(minSubarray(new int[]{4}, 3));
        // 预期结果：1 （只能移除整个数组）

        // 测试案例 5：空数组
        System.out.println(minSubarray(new int[]{}, 1));
        // 预期结果：-1 （无有效结果）

        // 测试案例 6：数组和本身已经能被 p 整除
        System.out.println(minSubarray(new int[]{5, 10, 15}, 5));
        // 修正预期结果：0 （数组和 30 已经能被 5 整除，无需移除任何子数组）

        // 测试案例 7：数组和不能被 p 整除，但移除一个较长的子数组后满足
        System.out.println(minSubarray(new int[]{6, 3, 5, 2}, 9));
        // 预期结果：2 （移除子数组 [3, 5]，剩余 [6, 2] 和为 8，能被 9 整除）

        // 测试案例 8：数组包含负数
        System.out.println(minSubarray(new int[]{-3, 1, 2, 6}, 5));
        // 预期结果：1 （移除子数组 [2]，剩余和为 4，可以被 5 整除）

        // 测试案例 9：数组有重复元素
        System.out.println(minSubarray(new int[]{1, 1, 1, 1, 1}, 3));
        // 预期结果：1 （移除任意一个 1，剩余和为 4，可以被 3 整除）
    }
}