package practice_questions.dfs.medium;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: MaxAreaOfIsland
 * @Author: 丛虹羽
 * @Date: 2025/1/7 下午10:35
 * @Description: 岛屿的最大面积
 *
 * leetcode: https://leetcode.cn/problems/max-area-of-island/description/?envType=problem-list-v2&envId=1IkSmO7N
 */
public class MaxAreaOfIsland {

    /**
     * dfs 需要设计好，函数的返回值含义！！！
     *
     * @param grid 原始数组
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(dfs(i, j, grid), ans);
                }
            }
        }
        return ans;
    }

    /**
     *  函数含义：返回从(x, y)点四个方法扩充出来的点的个数
     *
     * @param x    坐标 x
     * @param y    坐标 y
     * @param grid 原始数组
     * @return
     */
    public static int dfs(int x, int y,int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return dfs(x - 1, y, grid) +
                dfs(x, y + 1, grid) +
                dfs(x + 1, y, grid) +
                dfs(x, y - 1, grid) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
        // 6
    }
}