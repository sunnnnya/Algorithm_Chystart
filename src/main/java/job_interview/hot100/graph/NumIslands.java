package job_interview.hot100.graph;

/**
 * @BelongsPackage: job_interview.hot100.graph
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2025/7/16 12:12
 * @Description: 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class NumIslands {

    /**
     * dfs 简单的感染使用
     *
     * @param grid 图的遍历
     * @return int
     */
    public static int numIslands(char[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
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
     * 深度优先搜索使用
     *
     * @param grid 图的矩阵
     * @param i    i 索引
     * @param j    j 索引
     */
    private static void dfs(char[][] grid, int i, int j) {
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
     * @param args 参数
     */
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                                     {'1', '1', '0', '1', '0'},
                                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
        // 1
    }
}
