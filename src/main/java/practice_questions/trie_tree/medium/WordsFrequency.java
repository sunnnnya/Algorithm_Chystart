package practice_questions.trie_tree.medium;

/**
 * @BelongsPackage: practice_questions.trie_tree.medium
 * @ClassName: WordsFrequency
 * @Author: 丛虹羽
 * @Date: 2024/8/27 下午2:12
 * @Description: 单词频率
 *
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * 你的实现应该支持如下操作：
 *      WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 *      get(word)查询指定单词在书中出现的频率
 *
 * leetcode: https://leetcode.cn/problems/words-frequency-lcci
 */
public class WordsFrequency {

    public int MAXN = 200000;

    public int[][] tree = new int[MAXN][26];

    public int[] end = new int[MAXN];

    public int cnt;

    public WordsFrequency(String[] book) {
        cnt = 1;
        for(String s : book) {
            insert(s);
        }
    }

    /**
     * 查询字符串的个数
     *
     * @param word
     * @return
     */
    public int get(String word) {
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
        return end[cur];
    }

    /**
     * 插入字符串到字典树中
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
        end[cur]++;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(arr);
        System.out.println(wordsFrequency.get("you"));
        // 0
        System.out.println(wordsFrequency.get("have"));
        // 2
        System.out.println(wordsFrequency.get("an"));
        // 1
        System.out.println(wordsFrequency.get("apple"));
        // 1
        System.out.println(wordsFrequency.get("pen"));
        // 1
    }
}
