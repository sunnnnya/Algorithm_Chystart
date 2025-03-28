package job_interview.alg_basic_know.dfs.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.dfs.ext
 * @ClassName: Exist
 * @Author: 丛虹羽
 * @Date: 2025/3/28 22:59
 * @Description: 单词搜索
 * https://leetcode.cn/problems/word-search/description/
 */
public class Exist {

    /**
     * 检查是否存在指定字符串
     *
     * @param board 字符数组
     * @param word  单词
     * @return 返回确定的值
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否可以搜索出指定字符串
     *
     * @param board 字符数组
     * @param i     i index
     * @param j     j index
     * @param index 字符串的索引值
     * @return
     */
    public static boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, i + 1, j, index + 1, word)
                || dfs(board, i - 1, j, index + 1, word)
                || dfs(board, i, j + 1, index + 1, word)
                || dfs(board, i, j - 1, index + 1, word);
        board[i][j] = temp;
        return found;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] c = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String str = "ABCCED";
        System.out.println(exist(c, str));
        // true
    }
}
