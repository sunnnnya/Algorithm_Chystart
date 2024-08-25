package practice_questions.monotonic_stack.hard;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.monotonic_stack.hard
 * @ClassName: MaximalRectangle
 * @Author: 丛虹羽
 * @Date: 2024/8/25 下午9:32
 * @Description: 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * leetcode：https://leetcode.cn/problems/maximal-rectangle
 */
public class MaximalRectangle {

    public static int MAXN = 201;

    public static int[] height = new int[MAXN];

    public static int[] stack = new int[MAXN];

    public static int r;

    /**
     * 数组压缩 + 单调栈
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Arrays.fill(height, 0, m, 0);
        int ans = 0;
        // 数组压缩的技巧实现
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            ans = Math.max(ans, largestRectangleArea(m));
        }
        return ans;
    }

    /**
     * 实际上就是求解最大矩阵问题
     *
     * @param n
     * @return
     */
    public static int largestRectangleArea(int n) {
        int ans = -1, r = 0;
        int cur, left;
        for (int i = 0; i < n; i++) {
            while (r > 0 && height[i] <= height[stack[r - 1]]) {
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, ((i - left - 1) * height[cur]));
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, ((n - left - 1) * height[cur]));
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] str = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(str));
        // 6
    }
}
