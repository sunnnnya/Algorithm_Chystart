package job_interview.code_top.dfs.graph_ext;

/**
 * @BelongsPackage: job_interview.code_top.dfs.graph_ext
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2025/5/9 17:05
 * @Description: 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/
 */
public class NumIslands {

    /**
     * dfs 中图的应用
     *
     * @param grid 地图
     * @return int
     */
    static int numIslands(char[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 感染过程
     *
     * @param grid 地图
     * @param i    i index
     * @param j    j index
     */
    static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return ;
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
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '1' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '0' }
        };
        System.out.println(numIslands(grid));
        // 2
    }
}
