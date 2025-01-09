package practice_questions.dfs.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.dfs.medium
 * @ClassName: Solve
 * @Author: 丛虹羽
 * @Date: 2025/1/9 下午10:37
 * @Description: 被围绕的区域
 *
 * leetcode: https://leetcode.cn/problems/surrounded-regions
 */
public class Solve {

    /**
     * 普通 dfs + 先遍历
     *
     * @param board 原始数组
     */
    public static void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    dfs(board, i, j);
                }
            }
        }
        // 处理 遍历过 和 未遍历 点
        // O -> X
        // X -> X
        // * -> O
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'O' ? 'X' : board[i][j] == '*' ? 'O' : 'X';
            }
        }
    }

    /**
     * 渲染函数，把边界的 O 渲染成 *，因为要考虑边界和渲染过的问题，所以要遇到'*'和'X'返回
     *
     * @param board 原始数组
     * @param x     坐标 x
     * @param y     坐标 y
     */
    public static void dfs(char[][] board, int x, int y) {
        // border[x][y] = 'X' || border[x][y] = '*' -> 说明被处理过或者到达了边界
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || board[x][y] == '*') {
            return;
        }
        board[x][y] = '*';
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                          {'X', 'O', 'O', 'X'},
                          {'X', 'X', 'O', 'X'},
                          {'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
        // [[X, X, X, X], [X, X, X, X], [X, X, X, X], [X, O, X, X]]
    }
}