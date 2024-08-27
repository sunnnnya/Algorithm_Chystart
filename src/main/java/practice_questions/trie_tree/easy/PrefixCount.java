package practice_questions.trie_tree.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.trie_tree.easy
 * @ClassName: PrefixCount
 * @Author: 丛虹羽
 * @Date: 2024/8/27 下午1:42
 * @Description: 统计包含给定前缀的字符串
 *
 * 给你一个字符串数组 words 和一个字符串 pref，返回 words 中以 pref 作为 前缀 的字符串的数目。
 * 字符串 s 的 前缀 就是  s 的任一前导连续字符串。
 *
 * leetcode：https://leetcode.cn/problems/counting-words-with-a-given-prefix
 */
public class PrefixCount {

    public static int MAXN = 10001;

    public static int[][] tree = new int[MAXN][26];

    public static int[] pass = new int[MAXN];

    public static int[] end = new int[MAXN];

    public static int cnt;

    /**
     * 静态数组的方式描述前缀树
     *
     * @param words
     * @param pref
     * @return
     */
    public static int prefixCount(String[] words, String pref) {
        if (pref.isEmpty() || words.length == 0) {
            return 0;
        }
        build();
        for (String s : words) {
            insert(s);
        }
        int result = prefixNumber(pref);
        clear();
        return result;
    }

    /**
     * 初始化前缀树
     */
    public static void build () {
        cnt = 1;
    }

    /**
     * 插入字符串到前缀树中
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
     * 返回以 word 为前缀的字符串有多少个
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
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    /**
     * 擦除
     */
    public static void clear() {
        for(int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = new String[]{"pay","attention","practice","attend"};
        String str = "at";
        System.out.println(prefixCount(arr, str));
        // 2

        String[] strs = new String[]{"leetcode","win","loops","success"};
        String str1 = "code";
        System.out.println(prefixCount(strs, str1));
        // 0

        String[] arr1 = new String[]{"msqhtquyqd","haxfaqn","mot","m","euxmdypr","covbm","tepbu","uidbyor","gzslsy","opns","dqdkbsjzg","uncsqzbgvj","unmoycxt","w","bklfoindmn","gsli","g","wngannxx","uykth","l","jm","af","qrtneoqvm","kxpvh","g"};
        String s2 = "arnzo";
        System.out.println(prefixCount(arr1, s2));
        // 0
    }
}
