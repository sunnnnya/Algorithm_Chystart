package practice_questions.dfs.easy;

/**
 * @BelongsPackage: practice_questions.dfs.easy
 * @ClassName: IslandPerimeter
 * @Author: 丛虹羽
 * @Date: 2025/1/8 下午8:11
 * @Description: 岛屿的周长
 *
 * leetcode: https://leetcode.cn/problems/island-perimeter
 */
public class IslandPerimeter {

    /**
     * dfs + 周长大小 -> 从一个岛屿到非岛屿区域：周长 + 1
     *
     * @param grid 原始数组
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    /**
     * 函数含义：返回以(x, y)点扩充出来的周长的大小
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return
     */
    public static int dfs(int[][] grid, int x, int y) {
        // 从岛屿到越界 -> 周长 + 1
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 1;
        }
        // 从岛屿到非岛屿 -> 周长 + 1
        if(grid[x][y] == 0) {
            return 1;
        }
        // 岛屿到岛屿 -> 周长 + 2
        if(grid[x][y] != 1) {
            return 0;
        }
        // 标记数组
        grid[x][y] = 2;
        return dfs(grid, x - 1, y) +
                dfs(grid, x, y + 1) +
                dfs(grid, x + 1, y) +
                dfs(grid, x, y - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
        // 16
    }
}