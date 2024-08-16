package practice_questions.trie_tree.medium;

/**
 * @BelongsPackage: practice_questions.trie_tree.medium
 * @ClassName: Trie
 * @Author: 丛虹羽
 * @Date: 2024/8/16 下午1:22
 * @Description: 实现 Trie (前缀树)
 *
 * 实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/implement-trie-prefix-tree
 */
public class Trie {
    /**
     * 字典树中节点信息的抽象，内部类
     */
    private class TrieNode {
        private int pass;
        private int end;
        private TrieNode[] nexts;
        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    /**
     * 根节点信息
     */
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * 插入字符串操作
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode node = root;
        node.pass++;
        char[] str = word.toCharArray();
        int path = 0;
        for (char c : str) {
            path = c - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new TrieNode();
            }
            node = node.nexts[path];
            node.pass++;
        }
        // 最后一个节点的值end值++
        node.end++;
    }

    /**
     * 查找是否包含字符串
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        char[] str = word.toCharArray();
        int path = 0;
        for (char chr : str) {
            path = chr - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.end != 0;
    }

    /**
     * 寻找指定前缀的个数
     *
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        TrieNode node = root;
        char[] str = prefix.toCharArray();
        for (char chr : str) {
            int path = chr - 'a';
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
        System.out.println(trie.startsWith("appaa"));
        // false
        trie.insert("app");
        System.out.println(trie.search("app"));
        // true
    }
}
