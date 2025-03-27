package job_interview.alg_basic_know.tree.trie_tree.ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.trie_tree.ext
 * @ClassName: FindWords
 * @Author: 丛虹羽
 * @Date: 2025/3/27 11:35
 * @Description: 单词搜索 II
 * https://leetcode.cn/problems/word-search-ii/description/
 */
public class FindWords {

    public static int MAXN = 10001;

    public static int[][] tree = new int[MAXN][26];

    public static int[] pass = new int[MAXN];

    // 端点的值是查找到的字符串
    public static String[] end = new String[MAXN];

    public static int cnt;

    /**
     * dfs + 前缀树剪枝
     *
     * @param board 二维字符数组
     * @param words 一维字符串数组
     * @return 可查询到的字符串集合
     */
    public static List<String> findWords(char[][] board, String[] words) {
        build(words);
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, 1, ans);
            }
        }
        clear();
        return ans;
    }

    /**
     *
     * @param board 字符数组
     * @param i     i index
     * @param j     j index
     * @param t     前缀树的编号
     * @param ans   答案统计序列
     * @return      从(i, j)位置出发，收集到了几个字符串
     */
    public static int dfs(char[][] board, int i, int j, int t, List<String> ans) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 0) {
            return 0;
        }
        char tmp = board[i][j];
        int road = tmp - 'a';
        t = tree[t][road];
        if(t == 0 || pass[t] == 0) {
            return 0;
        }
        int fix = 0;
        if(end[t] != null) {
            fix++;
            ans.add(end[t]);
            end[t] = null;
        }
        board[i][j] = 0;
        fix += dfs(board,i - 1, j, t, ans);
        fix += dfs(board,i + 1, j, t, ans);
        fix += dfs(board, i,j - 1, t, ans);
        fix += dfs(board, i,j + 1, t, ans);
        pass[t] -= fix;
        board[i][j] = tmp;
        return fix;
    }

    /**
     * 构建前缀树的过程
     *
     * @param words 字符串数组
     */
    public static void build(String[] words) {
        cnt = 1;
        for(String word : words) {
            int cur = 1;
            pass[cur]++;
            for(int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if(tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur] = word;
        }
    }

    /**
     * 清除数据
     */
    public static void clear() {
        for(int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = null;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
        // [oath, eat]
    }
}
