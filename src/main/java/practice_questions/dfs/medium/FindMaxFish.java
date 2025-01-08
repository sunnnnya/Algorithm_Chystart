package practice_questions.dfs.medium;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: FindMaxFish
 * @Author: 丛虹羽
 * @Date: 2025/1/8 下午8:31
 * @Description: 网格图中鱼的最大数目
 *
 * leetcode: https://leetcode.cn/problems/maximum-number-of-fish-in-a-grid
 */
public class FindMaxFish {

    /**
     * 基础 dfs + 状态数组
     *
     * @param grid 原始数组
     * @return
     */
    public static int findMaxFish(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    /**
     * 函数含义：返回以(x, y)点拓展可以到达的的区域和的数值。
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return     返回以(x, y)点拓展可以到达的的区域和的数值。
     */
    public static int dfs(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int tmp = grid[x][y];
        grid[x][y] = 0;
        return tmp +
                dfs(grid, x - 1, y) +
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
        int[][] grid = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(findMaxFish(grid));
        // 7

        int[][] grid1 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };
        System.out.println(findMaxFish(grid1));
        // 1
    }
}