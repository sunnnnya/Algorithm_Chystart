package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @package: practice_questions.dynamic_program.medium
 * @author: chystart
 * @create: 2024-12-26 23:21
 * @description: 不同路径
 *
 * leetcode: https://leetcode.cn/problems/unique-paths/description
 **/
public class UniquePaths {

    /**
     * 暴力递归 —— TLE
     *
     * @param m 行数
     * @param n 列数
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        return process1(1, 1, m, n);
    }

    /**
     * 函数说明：从当前节点 (startx, starty) 走到 (m, n) 的方法数有多少种？？？
     *
     * @param startx 当前的 x 坐标信息
     * @param starty 当前的 y 坐标信息
     * @param m      总行数
     * @param n      总列数
     * @return
     */
    public static int process1(int startx, int starty, int m, int n) {
        if(startx < 1 || startx > m || starty < 1 || starty > n) {
            return 0;
        }
        // 说明当前已经走到了(m, n)节点了，找到了一种方法
        if(startx == m && starty == n) {
            return 1;
        }
        return process1(startx + 1, starty, m, n) + process1(startx, starty + 1, m, n);
    }

    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param m 行数
     * @param n 列数
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(1, 1, m, n, dp);
    }

    /**
     * 函数说明：从当前节点 (startx, starty) 走到 (m, n) 的方法数有多少种？？？
     *
     * @param startx 当前的 x 坐标信息
     * @param starty 当前的 y 坐标信息
     * @param m      总行数
     * @param n      总列数
     * @return
     */
    public static int process2(int startx, int starty, int m, int n, int[][] dp) {
        if(startx < 1 || startx > m || starty < 1 || starty > n) {
            return 0;
        }
        if(dp[startx][starty] != -1) {
            return dp[startx][starty];
        }
        // 说明当前已经走到了(m, n)节点了，找到了一种方法
        if(startx == m && starty == n) {
            return 1;
        }
        dp[startx][starty] = process2(startx + 1, starty, m, n, dp) + process2(startx, starty + 1, m, n, dp);
        return dp[startx][starty];
    }


    /**
     * 暴力递归 + 缓存表 = 记忆化搜索
     *
     * @param m 行数
     * @param n 列数
     * @return
     */
    public static int uniquePaths3(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == m && j == n) {
                    continue;
                }
                dp[i][j] = (i + 1 <= m ? dp[i + 1][j] : 0) + (j + 1 <= n ? dp[i][j + 1] : 0);
            }
        }
        return dp[1][1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 暴力递归 + 分类讨论
        System.out.println(uniquePaths1(3, 7));

        // 记忆化搜索
        System.out.println(uniquePaths2(3, 7));

        // 动态规划
        System.out.println(uniquePaths3(3, 7));
    }
}
