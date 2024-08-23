package basic_knowledge.tree.prefix_tree;

import java.util.Arrays; /**
 * @BelongsPackage: basic_knowledge.tree.prefix_tree
 * @ClassName: TrieTree
 * @Author: 丛虹羽
 * @Date: 2024/8/23 下午2:46
 * @Description: 使用 静态数组 的方式实现 前缀树
 */
public class TrieTree {

    // 非固定的大小
    public static int MAXN = 150001;

    public static int[][] tree = new int[MAXN][26];

    public static int[] pass = new int[MAXN];

    public static int[] end = new int[MAXN];

    public static int cnt;

    public static void build() {
        cnt = 1;
    }

    /**
     * 插入字符串
     *
     * @param word
     */
    public static void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    /**
     * 返回字符串的个数
     *
     * @param word
     * @return
     */
    public static int search(String word) {
        if(word == null || word.isEmpty()) {
            return 0;
        }
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return end[cur];
    }

    /**
     * 共同有几个前缀的字符串
     *
     * @param word
     * @return
     */
    public static int prefixNumber(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if(tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    /**
     * 删除字符串
     *
     * @param word
     */
    public static void delete(String word) {
        if(word == null || word.isEmpty()) {
            return;
        }
        int cur = 1;
        if (search(word) > 0) {
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[tree[cur][path]] == 0) {
                    tree[cur][path] = 0;
                    return ;
                }
                cur = tree[cur][path];
            }
            end[cur]--;
        }
    }

    /**
     * 数据清理
     */
    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i],0);
            end[i] = 0;
            pass[i] = 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        TrieTree.build();
        TrieTree.insert("hello");
        System.out.println(TrieTree.search("he"));
        // 0
        System.out.println(TrieTree.search("hello"));
        // 1
        TrieTree.delete("hello");
        System.out.println(TrieTree.search("hello"));
        // 0
        TrieTree.insert("apple");
        TrieTree.insert("app");
        System.out.println(TrieTree.prefixNumber("app"));
        // 2
        TrieTree.delete("app");
        System.out.println(TrieTree.prefixNumber("app"));
        // 1
    }
}