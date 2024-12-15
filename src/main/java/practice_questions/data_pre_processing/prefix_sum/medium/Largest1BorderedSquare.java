package practice_questions.data_pre_processing.prefix_sum.medium;

/**
 * @BelongsPackage: practice_questions.data_pre_processing.prefix_sum.medium
 * @ClassName: Largest1BorderedSquare
 * @Author: 丛虹羽
 * @Date: 2024/12/15 下午5:41
 * @Description: 最大的以 1 为边界的正方形
 */
public class Largest1BorderedSquare {

    /**
     * 使用二维数组的前缀和，使用原数组假攻出来前缀和数组
     *
     * @param grid
     * @return
     */
    public static int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 构建前缀和数组信息
        build(grid, n, m);
        // 特判：如果整个数组中都不存在 1，直接返回 0
        if(sum(grid, 0, 0, n - 1, m - 1) == 0) {
            return 0;
        }
        // 找到的最大合法正方形边长 -> ans，剪枝
        int ans = 1;
        // 外两层 循环 枚举所有的左上角点
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < m; b++) {
                // 枚举所有的右下角点
                for(int c = a + ans, d = b + ans, k = ans + 1; c < n && d < m; c++, d++, k++) {
                    if(sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d - 1) == ((k - 1) << 2)) {
                        ans = k;
                    }
                }
            }
        }
        return ans * ans;
    }

    /**
     * 使用原始数组的空间求得前缀和数组
     *
     * @param g 原始数组
     * @param n 数组的行
     * @param m 数组的列
     */
    private static void build(int[][] g, int n, int m) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] += get(g, i - 1, j) + get(g, i, j - 1) - get(g, i - 1, j - 1);
            }
        }
    }

    /**
     * 二维数组求前缀和知识
     *
     * @param g 原始数组
     * @param a 左上角 x
     * @param b 左上角 y
     * @param c 右下角 x
     * @param d 右下角 y
     * @return  返回两个点之前的数据的总和
     */
    private static int sum(int[][] g, int a, int b, int c ,int  d) {
        return a > c ? 0 : get(g, c, d) - get(g, c, b - 1) - get(g, a - 1, d) + get(g, a - 1, b - 1);
    }

    /**
     * 获取数组中指定问题的元素
     *
     * @param g 原始数组
     * @param i 实际的索引位置 x
     * @param j 实际的索引位置 y
     * @return  返回数组的元素
     */
    private static int get(int[][] g, int i, int j) {
        return i < 0 || j < 0 ? 0 : g[i][j];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(largest1BorderedSquare(arr));
        // 9
    }
}
