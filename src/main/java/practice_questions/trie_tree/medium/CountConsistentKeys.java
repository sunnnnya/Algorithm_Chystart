package practice_questions.trie_tree.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.trie_tree.medium
 * @ClassName: CountConsistentKeys
 * @Author: 丛虹羽
 * @Date: 2024/8/23 下午8:03
 * @Description: 接头密匙
 *
 * 牛牛和他的朋友们约定了一套接头密匙系统，用于确认彼此身份。密匙由一组数字序列表示，两个密匙被认为是一致的，如果满足以下条件：
 * 密匙 b 的长度不超过密匙 a 的长度。
 * 对于任意 0 <= i < length(b)，有 b[i+1] - b[i] == a[i+1] - a[i]。
 * 现在给定了m个密匙 b 的数组，以及n个密匙 a 的数组。请你返回一个长度为 m 的结果数组 ans，表示每个密匙b都有多少一致的密匙a。
 *
 * nowcoder：https://www.nowcoder.com/practice/c552d3b4dfda49ccb883a6371d9a6932
 */
public class CountConsistentKeys {

    public static int MAXN = 2000001;

    public static int[][] tree = new int[MAXN][12];

    public static int[] pass = new int[MAXN];

    public static int[] end = new int[MAXN];

    public static int cnt;

    /**
     * 前缀树的使用
     *
     * @param b
     * @param a
     * @return
     */
    public static int[] countConsistentKeys (int[][] b, int[][] a) {
        if (b == null || a == null) {
            return new int[]{};
        }
        // System.out.println("a[][]数组：");
        for (int[] arr : a) {
            // System.out.println(getStringByArr(arr));
            insert(getStringByArr(arr));
        }
        ArrayList<Integer> list = new ArrayList<>();
        // System.out.println("b[][]数组：");
        for (int[] arr : b) {
            // System.out.println(getStringByArr(arr));
            list.add(prefixString(getStringByArr(arr)));
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        clear();
        return ans;
    }

    /**
     * 数组变成密钥字符串，重点就是一定要使用分隔符，避免产生歧义
     * 如果arr[i] - arr[i-1] = 2 下一个是 3
     * 同时如果返回 23 的话，是会产生歧义的。
     *
     * @param arr
     * @return
     */
    public static String getStringByArr(int[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < arr.length; i++) {
            stringBuffer.append((arr[i] - arr[i - 1]) + "#");
        }
        return stringBuffer.toString();
    }

    /**
     * 初始化cnt
     */
    public static void build() {
        cnt = 1;
    }

    /**
     * 根据有限的字符，设置优先的索引下标
     *
     * @param ch
     * @return
     */
    public static int path(char ch) {
        if (ch == '#') {
            return 10;
        } else if (ch == '-') {
            return 11;
        }
        return ch - '0';
    }

    /**
     * 构建前缀树
     *
     * @param word
     */
    public static void insert(String word) {
        if(word == null || word.isEmpty()) {
            return ;
        }
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    /**
     * 查询以 word 为前缀的字符串有多少个
     *
     * @param word
     * @return
     */
    public static int prefixString(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    /**
     * 数据清除
     */
    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
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
        int[][] b = new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8}, {1, 4, 7, 10}};
        int[][] a = new int[][]{{3, 4, 5, 6, 7, 8}, {2, 4, 6, 8}, {1, 3, 5, 7, 9}};
        System.out.println(Arrays.toString(countConsistentKeys(b, a)));
        // [1, 2, 0]

        int[][] b1 = new int[][]{{1, 2, 3}, {4, 5, 6, 7, 8}, {2, 4, 6, 8}};
        int[][] a1 = new int[][]{{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6, 7, 8}, {1, 4, 7, 10}};
        System.out.println(Arrays.toString(countConsistentKeys(b1, a1)));
        // [2, 2, 0]
    }
}