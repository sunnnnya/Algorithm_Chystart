package practice_questions.trie_tree.easy;

/**
 * @BelongsPackage: practice_questions.trie_tree.easy
 * @ClassName: Trie
 * @Author: 丛虹羽
 * @Date: 2024/8/23 上午11:20
 * @Description: 实现 Trie (前缀树)
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 *  leetcode：https://leetcode.cn/problems/QC3q1f/
 */
public class Trie {

    /**
     * 前缀树的节点结构
     */
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    private static TrieNode root;

    /**
     * 初始化节点信息
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入字符串到前缀树中
     *
     * @param word
     */
    public static void insert(String word) {
        if(word == null || word.isEmpty()) {
            return ;
        }
        TrieNode node = root;
        node.pass++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new TrieNode();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查询是否含有字符串
     *
     * @param word
     * @return
     */
    public static boolean search(String word) {
        if(word == null && word.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.end > 0;
    }

    /**
     * 是否包含以 prefix 为前缀的字符串
     *
     * @param prefix
     * @return
     */
    public static boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0, path; i < prefix.length(); i++) {
            path = prefix.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.pass > 0;
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
        // true
        System.out.println(trie.search("app"));
        // false
        System.out.println(trie.startsWith("app"));
        // true
        trie.insert("app");
        System.out.println(trie.search("app"));
        // true
        System.out.println(trie.startsWith("abc"));
        // false
    }
}
