package job_interview.code_top.dfs.graph_ext;

/**
 * @BelongsPackage: job_interview.code_top.dfs.graph_ext
 * @ClassName: MaxAreaOfIsland
 * @Author: 丛虹羽
 * @Date: 2025/5/10 14:03
 * @Description: 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    /**
     * dfs
     *
     * @param grid 图
     * @return
     */
    static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    /**
     * 深度优先搜索
     *
     * @param nums 二维数组
     * @param i    i index
     * @param j    j index
     * @return int
     */
    static int dfs(int[][] nums, int i, int j) {
        if(i < 0 || i >= nums.length || j < 0 ||j >= nums[0].length || nums[i][j] == 0) {
            return 0;
        }
        nums[i][j] = 0;
        return dfs(nums, i - 1, j)
                + dfs(nums, i, j + 1)
                + dfs(nums, i + 1, j)
                + dfs(nums, i , j - 1) + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
        // 6
    }
}
