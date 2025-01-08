package practice_questions.dfs.medium;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: NumEnclaves
 * @Author: 丛虹羽
 * @Date: 2025/1/9 上午12:15
 * @Description: 飞地的数量
 *
 * leetcode: https://leetcode.cn/problems/number-of-enclaves
 */
public class NumEnclaves {

    /**
     * dfs 渲染
     *
     * @param grid 原始数组
     * @return
     */
    public static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    dfs(grid, i, j);
                }
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    // 内部全是不可移动的
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 渲染边界中的个数
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return
     */
    public static int dfs(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return  0;
        }
        grid[x][y] = 0;
        return dfs(grid, x - 1, y) +
                dfs(grid, x, y + 1) +
                dfs(grid, x + 1, y) +
                dfs(grid, x, y - 1) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
        // 3
    }
}