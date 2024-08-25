package practice_questions.monotonic_stack.hard;

/**
 * @BelongsPackage: practice_questions.monotonic_stack.hard
 * @ClassName: LargestRectangleArea
 * @Author: 丛虹羽
 * @Date: 2024/8/25 下午4:32
 * @Description: 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * leetcode: https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    public static int MAXN = 100001;

    public static int[]stack = new int[MAXN];

    public static int r;

    /**
     * 单调栈 大压小
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int ans = -1, r = 0;
        int cur, left;
        for (int i = 0; i < heights.length; i++) {
            while (r > 0 && heights[i] <= heights[stack[r - 1]]) {
                cur = stack[--r];
                // left = -1 重点
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, ((i - left - 1) * heights[cur]));
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, ((heights.length - left - 1) * heights[cur]));
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
        // 10

        int[] arr1 = new int[]{2, 4};
        System.out.println(largestRectangleArea(arr1));
        // 4
    }
}
