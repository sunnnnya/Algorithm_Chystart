package practice_questions.dfs.medium;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: ClosedIsland
 * @Author: 丛虹羽
 * @Date: 2025/1/8 下午11:49
 * @Description: 统计封闭岛屿的数目
 *
 * leetcode: https://leetcode.cn/problems/number-of-closed-islands
 */
public class ClosedIsland {

    /**
     * dfs + 分析
     * 只要 0 区域接触到了边界证明当前岛屿不是封闭的，遍历完成后，如果在范围内还有 0 存在，证明当前的是就是封闭岛屿
     *
     * @param grid 原始数组
     * @return
     */
    public static int closedIsland(int[][] grid) {
        // 从边界进行遍历，一定分开处理，不能同时遍历同时判断，回出现误判的问题！！
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    dfs(grid, i, j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * 渲染函数，作用只是针对边界的 0 -> 1 处理
     *
     * @param grid 原始函数
     * @param x    坐标 x
     * @param y    坐标 y
     */
    public static void dfs(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(closedIsland(grid));
        // 2
    }
}