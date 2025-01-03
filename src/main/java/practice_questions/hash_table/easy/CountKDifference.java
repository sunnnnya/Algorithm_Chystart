package practice_questions.hash_table.easy;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.hash_table.easy
 * @ClassName: CountKDifference
 * @Author: 丛虹羽
 * @Date: 2025/1/3 下午11:35
 * @Description: 差的绝对值为 K 的数对数目
 *
 *  TwoSum 变种题！！！！！！！！！
 *
 * leetcode: https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k
 */
public class CountKDifference {

    /**
     * 暴力
     *
     * @param nums
     * @param k
     * @return
     */
    public static int countKDifference1(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                ans += Math.abs(nums[i] - nums[j]) == k ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 哈希表
     *
     * @param nums
     * @param k
     * @return
     */
    public static int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans += map.getOrDefault(nums[i] + k, 0) + map.getOrDefault(nums[i] - k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
        // 4
    }
}
