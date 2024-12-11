package practice_questions.binary_answer.hard;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.binary_answer.hard
 * @ClassName: SmallestDistancePair
 * @Author: 丛虹羽
 * @Date: 2024/12/11 下午11:38
 * @Description: 找出第 K 小的数对距离 ！ ！
 *
 * 二分答案 + 滑动窗口
 *
 * leetcode：https://leetcode.cn/problems/find-k-th-smallest-pair-distance
 */
public class SmallestDistancePair {

    /**
     * 分析：
     *  题目要求的是第 k 小的数对距离，所以对数对可能的距离答案进行二分搜索
     *  数对距离: [0, max]
     *
     * @param nums 原始数组
     * @param k    k 序列
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, ans = 0, r = nums[nums.length - 1] - nums[0];
        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            // 问题：为什么要在 >= 区域进行 ans 的更新呢，因为你要找到满足 等于 >=k 的最小值
            if(f(nums, mid) >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /**
     * f 函数的含义：限定 limit 数对距离，返回数字对的个数
     *
     * @param nums
     * @param limit
     * @return
     */
    private static int f(int[] nums, int limit) {
        int ans = 0;
        for (int l = 0, r = 0; l < nums.length; l++) {
            while(r + 1 < nums.length && nums[r + 1] - nums[l] <= limit) {
                r++;
            }
            ans += r - l;
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,1};
        int k = 1;
        System.out.println(smallestDistancePair(arr, k));
        // 0
    }
}