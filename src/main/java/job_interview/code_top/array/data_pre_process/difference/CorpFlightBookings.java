package job_interview.code_top.array.data_pre_process.difference;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.code_top.array.data_pre_process.difference
 * @ClassName: CorpFlightBookings
 * @Author: 丛虹羽
 * @Date: 2025/5/9 11:48
 * @Description: 航班预订统计
 * https://leetcode.cn/problems/corporate-flight-bookings/
 */
public class CorpFlightBookings {

    /**
     * 一维差分数组
     *
     * @param bookings 航班预定数组
     * @param n 班次
     * @return int[]
     */
    static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n + 2];
        int[] ans = new int[n];
        for(int[] b : bookings) {
            d[b[0]] += b[2];
            d[b[1] + 1] -= b[2];
        }
        for(int i = 1; i <= n; i++) {
            d[i] += d[i - 1];
            ans[i - 1] = d[i];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(nums, n)));
        // [10, 55, 45, 25, 25]
    }
}
