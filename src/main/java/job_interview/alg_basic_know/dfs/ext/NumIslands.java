package job_interview.alg_basic_know.dfs.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.dfs.ext
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2025/3/27 14:21
 * @Description: 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/
 */
public class NumIslands {

    /**
     * 简单的 dfs 遍历
     *
     * @param grid 地图
     * @return 岛屿的数量
     */
    public static int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * 简单感染模型
     *
     * @param grid 字符地图
     * @param i    i index
     * @param j    j index
     */
    public static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // 感染
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
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
        // 3
    }
}
