package job_interview.hot100.back_track;

/**
 * @BelongsPackage: job_interview.hot100.back_track
 * @ClassName: Exist
 * @Author: 丛虹羽
 * @Date: 2025/7/26 23:02
 * @Description: 单词搜索
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Exist {

    /**
     * 深度优先搜索的遍历
     *
     * @param board 字符数组
     * @param word  单词的数量
     * @return boolean
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归函数的使用
     *
     * @param board 字符数组
     * @param i     i 索引
     * @param j     j 索引
     * @param index 字符串的索引
     * @param word  字符串
     * @return boolean
     */
    private static boolean dfs(char[][] board, int i, int j, int index, String word) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#'; // 感染
        boolean found = dfs(board, i - 1, j, index + 1, word) ||
                dfs(board, i, j + 1, index + 1, word) ||
                dfs(board, i + 1, j, index + 1, word) ||
                dfs(board, i, j - 1, index + 1, word);
        board[i][j] = tmp;
        return found;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
        // true
    }
}
