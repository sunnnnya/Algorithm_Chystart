package job_interview.code_top.array.data_pre_process;

/**
 * @BelongsPackage: job_interview.code_top.array.data_pre_process
 * @ClassName: Largest1BorderedSquare
 * @Author: 丛虹羽
 * @Date: 2025/5/8 19:20
 * @Description: 最大的以 1 为边界的正方形
 * https://leetcode.cn/problems/largest-1-bordered-square/description/
 */
public class Largest1BorderedSquare {

    /**
     * 二维数组前缀和
     *
     * @param grid
     * @return
     */
    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        build(grid, m, n);
        if (sum(grid, 0, 0, m - 1, n - 1) == 0) {
            return 0;
        }
        int ans = 1;
        for (int a = 0; a < m; a++) {
            for(int b = 0; b < n; b++) {
                for(int c = a + ans, d = b + ans, k = ans + 1; c < m && d < n; c++, d++, k++) {
                    if(sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2) {
                        ans = k;
                    }
                }
            }
        }
        return ans * ans;
    }

    /**
     * 矩阵的左上和右下角的累加和判断
     *
     * @param sum 原始数组
     * @param a   左上 x
     * @param b   左上 y
     * @param c   右下 x
     * @param d   右下 y
     * @return int
     */
    static int sum(int[][] sum, int a, int b, int c, int d) {
        return a > c ? 0 : (sum[c][d] - get(sum, c, b - 1) - get(sum, a - 1, d) + get(sum, a - 1, b - 1));
    }

    /**
     * 构建前缀和数组
     *
     * @param g 原始数组
     * @param m m line
     * @param n n line
     */
    static void build(int[][] g, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] += get(g, i - 1, j) + get(g, i, j - 1) - get(g, i - 1, j - 1);
            }
        }
    }

    /**
     * 获取数组的值
     *
     * @param g 原始数组
     * @param i i index
     * @param j j index
     * @return int
     */
    static int get(int[][] g, int i, int j) {
        return (i < 0 || j < 0) ? 0 : g[i][j];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(largest1BorderedSquare(nums));
        // 9
    }
}
