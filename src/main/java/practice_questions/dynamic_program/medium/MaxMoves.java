package practice_questions.dynamic_program.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dynamic_program.medium
 * @ClassName: MaxMoves
 * @Author: 丛虹羽
 * @Date: 2025/1/10 上午12:50
 * @Description: 矩阵中移动的最大次数
 *
 * leetcode: https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/
 */
public class MaxMoves {

    /**
     * 暴力递归 + 尝试策略
     *  TLE
     *
     * @param grid
     * @return
     */
    public static int maxMoves1(int[][] grid) {
        int m = grid.length, ans = 0;
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, dfs1(grid, i, 0));
        }
        return ans;
    }

    /**
     * 函数含义：从(x, y)向三个方向走能达到的最大深度
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return
     */
    public static int dfs1(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if(get(grid, x - 1, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs1(grid, x - 1, y + 1));
        }
        if(get(grid, x, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs1(grid, x, y + 1));
        }
        if(get(grid, x + 1, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs1(grid, x + 1, y + 1));
        }
        return max == Integer.MIN_VALUE ? 0 : max + 1;
    }

    /**
     * 处理越界
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return     越界返回 0，反之返回 grid[x][y]
     */
    public static int get(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        return grid[x][y];
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param grid 原始数组
     * @return
     */
    public static int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, dfs(grid, i, 0, dp));
        }
        return ans;
    }

    /**
     * 函数含义：从(x, y)向三个方向走能达到的最大深度
     *
     * @param grid 原始数组
     * @param x    坐标 x
     * @param y    坐标 y
     * @return
     */
    public static int dfs(int[][] grid, int x, int y, int[][] dp) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        int max = Integer.MIN_VALUE;
        if(get(grid, x - 1, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs(grid, x - 1, y + 1, dp));
        }
        if(get(grid, x, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs(grid, x, y + 1, dp));
        }
        if(get(grid, x + 1, y + 1) > grid[x][y]) {
            max = Math.max(max, dfs(grid, x + 1, y + 1, dp));
        }
        dp[x][y] = max == Integer.MIN_VALUE ? 0 : max + 1;;
        return dp[x][y];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 暴力递归 —— TLE
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(maxMoves1(grid));
        // 3

        // 记忆化搜索
        int[][] grid1 = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(maxMoves(grid1));
        // 3
    }
}