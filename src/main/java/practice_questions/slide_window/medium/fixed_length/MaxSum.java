package practice_questions.slide_window.medium.fixed_length;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsPackage: practice_questions.slide_window.medium
 * @ClassName: MaxSum
 * @Author: 丛虹羽
 * @Date: 2024/12/8 下午3:45
 * @Description: 几乎唯一子数组的最大和
 *
 * 一个整数数组 nums 和两个正整数 m 和 k 。
 * 返回 nums 中长度为 k 的几乎唯一子数组的最大和 ，如果不存在几乎唯一子数组，请你返回 0
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，称它是几乎唯一子数组。
 *
 * leetcode: https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray
 */
public class MaxSum {

    /**
     * 定长滑动窗口 + 哈希表
     *
     * @param nums 原始数组
     * @param m    至少 m 个元素
     * @param k    窗口的宽度
     * @return
     */
    public static long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, max = 0;
        for(int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
            if(i < k - 1) {
                continue;
            }
            if(map.size() >= m) {
                max = Math.max(max, sum);
            }
            if(map.get(nums.get(i - k + 1)) > 1) {
                map.put(nums.get(i - k + 1), map.get(nums.get(i - k + 1)) - 1);
            } else {
                map.remove(nums.get(i - k + 1));
            }
            sum -= nums.get(i - k + 1);
        }
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 6, 7, 3, 1, 7);
        System.out.println(maxSum(list, 3, 4));
        // 18

        List<Integer> list1 = Arrays.asList(5, 9, 9, 2, 4, 5, 4);
        System.out.println(maxSum(list1, 1, 3));
        // 23
    }
}