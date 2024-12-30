package practice_questions.data_pre_processing.prefix_sum.medium;

import java.util.HashMap;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: LongestWPI
 * @Author: 丛虹羽
 * @Date: 2024/12/28 下午1:42
 * @Description: 表现良好的最长时间段
 *
 * leetcode： https://leetcode.cn/problems/longest-well-performing-interval/description/
 */
public class LongestWPI {

    /**
     * 前缀和第一次出现的位置 + 单调性分析
     *
     * @param hours 原始数组
     * @return
     */
    public static int longestWPI(int[] hours) {
        // HashMap：记录前缀和最早出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0, sum = 0; i < hours.length; i++) {
            // 技巧一：等价数组转换
            sum += hours[i] > 8 ? 1 : -1;
            if(sum > 0) {
                ans = i + 1;
            } else {
                // 技巧二：为什么找 sum - 1 原因画图就可以理解
                // 如果出现了 -5 的情况，一定是先变成 -4 然后 -1 变成 -5
                // 主要原因是因为：起点是 0
                if(map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
            // 只记录最早出现的位置
            if(!map.containsKey(sum)) {
                map.put(sum, i);
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
        int[] arr = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(arr));
        // 3

        int[] arr1 = {6, 6, 6};
        System.out.println(longestWPI(arr1));
        // 0
    }
}
