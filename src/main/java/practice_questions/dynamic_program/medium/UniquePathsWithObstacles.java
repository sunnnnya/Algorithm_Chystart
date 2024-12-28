package practice_questions.dynamic_program.medium;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-28 14:17
 * @description: 不同路径 II
 *
 * leetcode: https://leetcode.cn/problems/unique-paths-ii/
 **/
public class UniquePathsWithObstacles {

    /**
     * 暴力递归
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        return process1(obstacleGrid, 0, 0, m - 1, n - 1);
    }

    /**
     * 含义：从 (startx, starty) 走到 (endx, endy) 的路径条数
     *
     * @param arr    原始数组
     * @param startx 当前点的 x 坐标
     * @param starty 当前点的 y 坐标
     * @param endx   终点的 x 坐标
     * @param endy   终点的 y 坐标
     * @return
     */
    public static int process1(int[][] arr, int startx, int starty, int endx, int endy) {
        if(startx < 0 || startx > endx || starty < 0 || starty > endy || arr[startx][starty] == 1) {
            return 0;
        }
        if(startx == endx && starty == endy) {
            return 1;
        }
        return process1(arr, startx + 1, starty, endx, endy) + process1(arr, startx, starty + 1, endx, endy);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param obstacleGrid 原始数组
     * @return
     */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(obstacleGrid, 0, 0, m - 1, n - 1, dp);
    }

    /**
     * 添加缓存表
     *
     * @param arr    原始数组
     * @param startx 当前点的 x 坐标
     * @param starty 当前点的 y 坐标
     * @param endx   终点的 x 坐标
     * @param endy   终点的 y 坐标
     * @param dp     缓存表
     * @return
     */
    public static int process2(int[][] arr, int startx, int starty, int endx, int endy, int[][] dp) {
        if(startx < 0 || startx > endx || starty < 0 || starty > endy || arr[startx][starty] == 1) {
            return 0;
        }
        if(dp[startx][starty] != -1) {
            return dp[startx][starty];
        }
        if(startx == endx && starty == endy) {
            return 1;
        }
        int ans = process2(arr, startx + 1, starty, endx, endy, dp) + process2(arr, startx, starty + 1, endx, endy, dp);
        dp[startx][starty] = ans;
        return dp[startx][starty];
    }

    /**
     * 动态规划版本
     *
     * @param obstacleGrid 原始数组
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int j = 1; j < n; j++) {
            if(obstacleGrid[0][j] == 0 && dp[0][j-1] == 1) {
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
        // 2
    }
}