package basic_knowledge.tree.prefix_tree;

import java.util.Scanner;

/**
 * @BelongsPackage: basic_knowledge.tree.prefix_tree
 * @ClassName: PrefixTree
 * @Author: 丛虹羽
 * @Date: 2024/8/16 上午9:26
 * @Description: 前缀树 又称 字典树 Trie树
 *
 * （1）单个字符串中，字符从前到后的加到一棵多叉树上；
 * （2）字符放在”路上“节点上有专属的数据项(常见的是 pass[通过了几次] 和 end[是多少个字符串的结尾节点] 值)；
 * （3）所有样本都这样添加，如果没有路就新建，如有路就复用；
 * （4）沿途节点的 pass 值增加 1，每个字符串结束时来到的节点 end 值增加 1；
 *
 * 样例：
 *      ["abc", "abd", "bce", "abcd", "bcf"]
 *                          O(p5e0)
 *                    a /       \ b
 *                     O(p3e0)   O(p2e0)
 *                b  /          / c
 *                 O(p3e0)    O(p2e0)
 *            c /    \ d    / e  \ f
 *      (p2e1)O (p1e1)O   O(p1e1) O(p1e1)
 *            \ d
 *             O(p1e1)

 *
 */
public class PrefixTree {

    /**
     * 前缀树的节点信息
     */
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            /**
             * 说明全是小写字母，如果字符过多长度就不是26
             * 0   a
             * 1   b
             * .. ..
             * 25  z
             * nexts[i] == null -> 说明路径不存在
             * nexts[i] != null -> 说明路径存在
             */
            this.nexts = new TrieNode[26];
        }
    }

    /**
     * 前缀树的结构
     */
    public static class TrieTree {

        private TrieNode root;

        public TrieTree() {
            this.root = new TrieNode();
        }

        /**
         * 构建前缀树
         *
         * @param word
         */
        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            char[] str = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        /**
         * @param word
         */
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int path = 0;
                for (int i = 0; i < chs.length; i++) {
                    path = chs[i] - 'a';
                    // 重点：if()：当()中为true时执行{}中的内容，但()中的语句是会执行的
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        /**
         * word 方法添加过几次
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 所有加入的字符串中，有几个是以 pre 这个字符串作为前缀的
         *
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null || pre.isEmpty()) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===============测试if()中的条件一定会执行==============");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (--number == 1) {
            System.out.println("number:" + number);
        }
        System.out.println(number);

        System.out.println("==================测试前缀树代码===================");
    }
}