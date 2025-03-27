package job_interview.alg_basic_know.dfs.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.dfs.ext
 * @ClassName: MaxAreaOfIsland
 * @Author: 丛虹羽
 * @Date: 2025/3/27 14:14
 * @Description: 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    /**
     * 普通 dfs
     *
     * @param grid 地图信息
     * @return 最大的岛屿
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int mx = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    mx = Math.max(mx, dfs(grid, i, j));
                }
            }
        }
        return mx;
    }

    /**
     * 以 (i, j) 节点可以扩充（四个方向）出来岛屿的大小
     *
     * @param grid 地图信息
     * @param i    i index
     * @param j    j index
     * @return     当前岛屿的个数
     */
    public static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1);
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
