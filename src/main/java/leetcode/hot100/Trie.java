package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-19 11:43
 * @description: 实现 Trie (前缀树)
 *
 * leetcode: https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class Trie {

    /**
     * 静态数组的方式实现前缀树
     */
    public static int MAXN = 30001;

    public static int[] end;

    public static int[] pass;

    public static int[][] tree;

    public static int cnt;

    public Trie() {
        cnt = 1;
        end = new int[MAXN];
        pass = new int[MAXN];
        tree = new int[MAXN][26];
    }

    /**
     * 插入单词
     *
     * @param word 添加的单词
     */
    public void insert(String word) {
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
        end[cur]++;
    }

    /**
     * 查询单词是否存在
     *
     * @param word 添加的单词
     */
    public boolean search(String word) {
        int cur = 1;
        for(int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if(tree[cur][path] == 0) {
                return false;
            }
            cur = tree[cur][path];
        }
        return end[cur] > 0;
    }

    /**
     * 查询是否有以 prefix 开头的前缀单词
     *
     * @param prefix 前缀字符串
     * @return true | false
     */
    public boolean startsWith(String prefix) {
        int cur = 1;
        for(int i = 0, path; i < prefix.length(); i++) {
            path = prefix.charAt(i) - 'a';
            if(tree[cur][path] == 0) {
                return false;
            }
            cur = tree[cur][path];
        }
        return pass[cur] > 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
