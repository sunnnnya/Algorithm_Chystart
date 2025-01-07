package practice_questions.dfs.medium;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2025/1/7 下午10:09
 * @Description: 岛屿数量
 *
 * leetcode； https://leetcode.cn/problems/number-of-islands
 */
public class NumIslands {

    /**
     * 基础 dfs
     *
     * @param grid 原始数组
     * @return
     */
    public static int numIslands(char[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }

    /**
     * dfs 基础，使用 grid[][] 就充当了 vis[][]
     *
     * @param grid 原始数组
     * @param x    x 坐标
     * @param y    y 坐标
     * @param m    行数最大值
     * @param n    列数最大值
     */
    public static void dfs(char[][] grid, int x, int y, int m, int n) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
            return ;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y, m, n);
        dfs(grid, x, y + 1, m, n);
        dfs(grid, x + 1, y, m, n);
        dfs(grid, x, y - 1, m, n);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
        // 1

        char[][] grid1 = {{'1', '1', '0', '0', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '1', '0', '0'},
                          {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid1));
        // 3
    }
}