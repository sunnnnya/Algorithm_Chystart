package leetcode.hot100;

/**
 * @BelongsPackage: leetcode.hot100
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2025/3/3 23:19
 * @Description: 岛屿数量
 *
 * leetcode：https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class NumIslands {

    /**
     * 基础 dfs
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * dfs函数
     *
     * @param grid 原始数组
     * @param i    i index
     * @param j    j index
     */
    public static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
        // 1

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid1));
        // 3
    }
}
