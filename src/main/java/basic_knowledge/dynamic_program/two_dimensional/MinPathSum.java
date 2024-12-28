package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-28 15:15
 * @description: 最小路径和
 *
 * leetcode: https://leetcode.cn/problems/minimum-path-sum/description/
 **/
public class MinPathSum {

    /**
     * 暴力递归
     *
     * @param grid 原始数组
     * @return
     */
    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) {
            return grid[0][0];
        }
        return process1(grid, 0, 0, m - 1, n - 1);
    }

    /**
     * 函数说明：(startx, starty) 到 (endx, endy) 的路径长度最小值
     *      当前节点的值 + 右边 和 下边 值中较小的那个的路径
     *
     * @param grid    原始数组
     * @param startx  开始 x 坐标
     * @param starty  开始 y 坐标
     * @param endx    终点 x 坐标
     * @param endy    终点 y 坐标
     * @return
     */
    public static int process1(int[][] grid, int startx, int starty, int endx, int endy) {
        if(startx < 0 || startx > endx || starty < 0 || starty > endy) {
            // 返回值为无穷大认为达不到
            return Integer.MAX_VALUE;
        }
        if(startx == endx && starty == endy) {
            return grid[startx][starty];
        }
        return Math.min(process1(grid, startx, starty + 1, endx, endy),
                process1(grid, startx + 1, starty, endx, endy)) + grid[startx][starty];
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     * 使用缓存表记录下来每个递归节点计算出来的值，用来加速
     *
     * @param grid 原始数组
     * @return
     */
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) {
            return grid[0][0];
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(grid, 0, 0, m - 1, n - 1, dp);
    }

    /**
     * 递归函数要设计好参数、以及返回值、以及出口
     *
     * @param grid   原始数组
     * @param startx 当前点的 x 坐标
     * @param starty 当前点的 y 坐标
     * @param endx   终点的 x 坐标
     * @param endy   终点的 y 坐标
     * @param dp     缓存表
     * @return
     */
    public static int process2(int[][] grid, int startx, int starty, int endx, int endy, int[][] dp) {
        // 因为 process2 方法返回的是最小的值，当你发生越界的时候直接返回最大值，就可以，min 之后就是有效的数值
        if(startx < 0 || startx > endx || starty < 0 || starty > endy) {
            // 返回值为无穷大认为达不到
            return Integer.MAX_VALUE;
        }
        // 命中缓存，直接返回
        if(dp[startx][starty] != -1) {
            return dp[startx][starty];
        }
        if(startx == endx && starty == endy) {
            // 不要死板，根据题意，如果找到的是一种方法，直接返回 1 即可
            // 如果返回的是路径的最小和，你到了的终点，一定返回的是当前节点的值，而不是1
            return grid[startx][starty];
        }
        int ans = Math.min(process2(grid, startx, starty + 1, endx, endy, dp),
                process2(grid, startx + 1, starty, endx, endy, dp)) + grid[startx][starty];
        dp[startx][starty] = ans;
        return ans;
    }

    /**
     * 动态规划，真实实现的时候不要贪图代码的整洁而使用合起来的写法，直接就通过多个 for 循环进行填写表就可以
     *
     * @param grid 原始数组
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1) {
            return grid[0][0];
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
        }
        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        // 7

        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid1));
        // 12
    }
}
