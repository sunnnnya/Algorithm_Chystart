package practice_questions.prefix_sum_array.easy;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: IsCovered
 * @Author: 丛虹羽
 * @Date: 2024/9/2 下午11:34
 * @Description: 检查是否区域内所有整数都被覆盖
 *
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered
 */
public class IsCovered {

    /**
     * 差分数组
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];
        // 差分思想
        for (int[] range : ranges) {
            arr[range[0]]++;
            arr[range[1] + 1]--;
        }
        // 前缀和思想
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        boolean result = true;
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {4, 4}, {5, 6}};
        System.out.println(isCovered(arr, 2, 5));
        // false

        int[][] arr1 = new int[][]{{1, 10}, {10, 20}};
        System.out.println(isCovered(arr1, 21, 21));
        // false

        int[][] arr3 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println(isCovered(arr3, 2, 5));
        // true
    }
}
