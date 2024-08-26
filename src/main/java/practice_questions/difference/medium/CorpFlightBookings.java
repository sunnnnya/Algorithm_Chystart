package practice_questions.difference.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.difference.medium
 * @ClassName: CorpFlightBookings
 * @Author: 丛虹羽
 * @Date: 2024/8/26 下午6:54
 * @Description: 航班预订统计
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 * leetcode：https://leetcode.cn/problems/corporate-flight-bookings
 */
public class CorpFlightBookings {

    /**
     * 差分数组的基本使用
     *
     * @param bookings
     * @param n
     * @return
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
            diff[i] = diff[i] + diff[i - 1];
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
