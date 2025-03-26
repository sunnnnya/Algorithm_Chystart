package job_interview.alg_basic_know.tree.trie_tree;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.trie_tree
 * @ClassName: Trie
 * @Author: 丛虹羽
 * @Date: 2025/3/26 12:25
 * @Description: 前缀树
 */
public class TrieTree {

    public int MAXN = 150001;

    public int[][] tree;

    public int[] pass;

    public int[] end;

    public int cnt;

    public TrieTree() {
        cnt = 1;
        tree = new int[MAXN][26];
        pass = new int[MAXN];
        end = new int[MAXN];
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
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    /**
     * 查询字符串是否出现过
     *
     * @param word 字符串
     * @return true | false
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
     * 查询出现以 prefix 前缀出现的字符串的次数
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
     * 查询以 word 单词前缀的个数
     *
     * @param word 单词
     * @return 前缀单词个数
     */
    public int prefixNumber(String word) {
       if(!startsWith(word)) {
           return -1;
       }
       int cur = 1;
       for(int i = 0, path; i < word.length(); i++) {
           path = word.charAt(i) - 'a';
           cur = tree[cur][path];
       }
       return pass[cur];
    }

    /**
     * 返回一共插入了多少个字符串
     *
     * @return 插入的字符串的个数
     */
    public int count() {
        return pass[1];
    }

    /**
     * 删除字符串
     *
     * @param word 指定要删除的字符串
     */
    public void delete(String word) {
        if(search(word)) {
            int cur = 1;
            pass[cur]--;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[tree[cur][path]] == 0) {
                    tree[cur][path] = 0;
                    return;
                }
                cur = tree[cur][path];
            }
            end[cur]--;
        }
    }

    /**
     * 数据擦除
     */
    public void clear() {
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
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abc");
        trieTree.insert("adf");
        System.out.println("prefixNumber: " + trieTree.prefixNumber("a"));
        // prefixNumber: 2
        System.out.println("search qwe: " + trieTree.search("qwe"));
        // search qwe: false
        System.out.println("search abc: " + trieTree.search("abc"));
        // search abc: true
        System.out.println("starts with: " + trieTree.startsWith("a"));
        // starts with: true
        trieTree.delete("abc");
        System.out.println("prefixNumber: " + trieTree.prefixNumber("a"));
        // prefixNumber: 1
        System.out.println("search abc: " + trieTree.search("abc"));
        // search abc: false
        System.out.println("count: " + trieTree.count());
        // count: 1
    }
}
