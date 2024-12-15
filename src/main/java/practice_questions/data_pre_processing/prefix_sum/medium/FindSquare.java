package practice_questions.data_pre_processing.prefix_sum.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: FindSquare
 * @Author: 丛虹羽
 * @Date: 2024/12/15 下午8:25
 * @Description: 最大黑方阵
 *
 * leetcode： https://leetcode.cn/problems/max-black-square-lcci
 */
public class FindSquare {

    /**
     * 二维前缀和
     *
     * @param matrix 原始数组
     * @return [r, c, size] -> 左上角 x、y 以及 宽度
     */
    public static int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        build(matrix, n, m);
        int ans = 0;
        int x = -1;
        int y = -1;
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < m; b++) {
                for(int c = a + ans, d = b + ans, k = ans + 1; c < n && d < n; c++, d++, k++) {
                    // ans 直接做了剪枝，只会返回比验证过的值中更大的值，否则就会记录
                    if(sum(matrix, a, b, c, d) - sum(matrix, a + 1, b + 1, c - 1,  d - 1) == 0) {
                        ans = k;
                        x = a;
                        y = b;
                    }
                }
            }
        }
        if(x == -1 && y == -1) {
            return new int[]{};
        } else {
            return new int[]{x, y, ans};
        }
    }

    /**
     * 构建前缀和数组
     *
     * @param g 原始数组
     * @param n 长度
     * @param m 宽度
     */
    private static void build(int[][] g, int n, int m) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                g[i][j] += get(g, i - 1, j) + get(g, i, j - 1) - get(g, i - 1, j - 1);
            }
        }
    }

    /**
     * 直接抛去边界的使用
     *
     * @param g 原始数组
     * @param i index
     * @param j index
     * @return 0 | g[i][j]
     */
    private static int get(int[][] g, int i, int j) {
        return (i < 0 || j < 0) ? 0 : g[i][j];
    }

    /**
     * 求(a, b) -> (c, d) 之间的矩阵的长度
     *
     * @param g 原始数组
     * @param a 左上角 x
     * @param b 左上角 y
     * @param c 右下角 x
     * @param d 右下角 y
     * @return
     */
    private static int sum(int[][] g, int a, int b, int c, int d) {
        return a > c ? 0 : get(g, c, d) - get(g, a - 1, d) - get(g, c, b - 1) + get(g, a - 1, b - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1}, {0, 0, 1}, {0, 0, 1}};
        System.out.println(Arrays.toString(findSquare(arr)));
        // [1, 0, 2]

        int[][] arr1 = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        System.out.println(Arrays.toString(findSquare(arr1)));
        // [0, 0, 1]
    }
}