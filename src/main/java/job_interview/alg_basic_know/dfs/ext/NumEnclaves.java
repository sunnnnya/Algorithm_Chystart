package job_interview.alg_basic_know.dfs.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.dfs.ext
 * @ClassName: NumEnclaves
 * @Author: 丛虹羽
 * @Date: 2025/4/3 13:52
 * @Description: 飞地的数量
 * https://leetcode.cn/problems/number-of-enclaves/description/
 */
public class NumEnclaves {

    /**
     * 简单 dfs
     *  先处理边界再处理内部
     *
     * @param grid 原始数组
     * @return
     */
    public static int numEnclaves(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                    if(grid[i][j] == 1) {
                        // 感染
                        dfs(grid, i, j);
                    }
                }
            }
        }
        // 统计
        int count = 0;
        for(int i = 1; i < grid.length - 1; i++) {
            for(int j = 1; j < grid[0].length - 1; j++) {
                count += grid[i][j] == 1 ? 1 : 0;
            }
        }
        return count;
    }

    /**
     * 感染过程
     *
     * @param grid 原始数组
     * @param i    i index
     * @param j    j index
     */
    private static void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
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
        int[][] grid = {{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0}};
        System.out.println(numEnclaves(grid));
        // 3
    }
}
