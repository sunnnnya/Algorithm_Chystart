package job_interview.hot100.graph;

/**
 * @BelongsPackage: job_interview.hot100.graph
 * @ClassName: Trie
 * @Author: 丛虹羽
 * @Date: 2025/7/26 11:13
 * @Description: 前缀树
 * https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class Trie {

    private int MAXN = 150001;

    private int[][] tree;

    private int[] pass;

    private int[] end;

    private int cnt;

    public Trie() {
        cnt = 1;
        tree = new int[MAXN][26];
        pass = new int[MAXN];
        end = new int[MAXN];
    }

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
}
