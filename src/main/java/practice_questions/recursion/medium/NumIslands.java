package practice_questions.recursion.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.recursion.medium
 * @ClassName: NumIslands
 * @Author: 丛虹羽
 * @Date: 2024/8/20 下午1:54
 * @Description: 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量?
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * leetcode: https://leetcode.cn/problems/number-of-islands
 */
public class NumIslands {

    /**
     * 使用递归实现
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    process(grid, i, j);
                }
            }
        }
        return ans;
    }

    public static void process(char[][] grid, int i, int j) {
        // i < 0 || i == grid.length || j < 0 || j == grid[0].length：是边界条件
        // grid[i][j] == '2' || grid[i][j] == '0'：遇到 '0' 和遇到 '2'的是否没有必要继续了
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '2' || grid[i][j] == '0') {
            return ;
        }
        grid[i][j] = '2';
        process(grid, i - 1, j); // ↑
        process(grid, i, j - 1); // ←
        process(grid, i, j + 1); // →
        process(grid, i + 1, j); // ↓
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] island = new char[][]{{'1', '1', '1', '1', '0'},
                                       {'1', '1', '0', '1', '0'},
                                       {'1', '1', '0', '0', '0'},
                                       {'0', '0', '0', '0', '1'}};
        System.out.println(numIslands(island));
        // 2
        System.out.println(Arrays.deepToString(island));
        // [[2, 2, 2, 2, 0],
        //  [2, 2, 0, 2, 0],
        //  [2, 2, 0, 0, 0],
        //  [0, 0, 0, 0, 2]]

        char[][] island1 = new char[][]{{'1', '1', '0', '0', '0'},
                                        {'1', '1', '0', '0', '0'},
                                        {'0', '0', '1', '0', '0'},
                                        {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(island1));
        // 3
        System.out.println(Arrays.deepToString(island1));
        // [[2, 2, 0, 0, 0],
        //  [2, 2, 0, 0, 0],
        //  [0, 0, 2, 0, 0],
        //  [0, 0, 0, 2, 2]]
    }
}
