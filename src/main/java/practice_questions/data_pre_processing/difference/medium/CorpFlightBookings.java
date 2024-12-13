package practice_questions.data_pre_processing.difference.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.difference.medium
 * @ClassName: CorpFlightBookings
 * @Author: 丛虹羽
 * @Date: 2024/12/13 下午6:54
 * @Description: 航班预订统计
 *
 * leetcode：https://leetcode.cn/problems/corporate-flight-bookings
 */
public class CorpFlightBookings {

    /**
     * 差分数组的基本使用
     *
     * @param bookings 原始数组
     * @param n        结果数组的长度信息
     * @return         返回差分之后的前缀和数组
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 防止出现越界，准备 n + 1 的位置
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            diff[booking[1]] -= booking[2];
        }
        // 加工前缀和数组
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = diff[i];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(corpFlightBookings(arr, 5)));
        // [10, 55, 45, 25, 25]

        int[][] arr1 = new int[][]{{1, 2, 10}, {2, 2, 15}};
        System.out.println(Arrays.toString(corpFlightBookings(arr1, 2)));
        // [10, 25]
    }
}