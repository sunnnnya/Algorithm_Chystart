package job_interview.alg_basic_know.tree.trie_tree.ext;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.trie_tree.ext
 * @ClassName: SharedSecretKey
 * @Author: 丛虹羽
 * @Date: 2025/3/26 16:27
 * @Description: 前缀树练习题
 * https://www.nowcoder.com/practice/c552d3b4dfda49ccb883a6371d9a6932
 */
public class SharedSecretKey {

    public static int MAXN = 32;

    // 重点：针对数值很大的时候，没必要开过大的数组，直接使用 9 -> 8 -> 7 当路径使用。
    // 0 1 2 3 4 5 6 7 8 9 # -
    public static int[][] tree = new int[MAXN][12];

    public static int[] pass = new int[MAXN];

    // 此题没有要求 word 出现的次数，所以 end 数组并不是强制需要的！！
    public static int[] end = new int[MAXN];

    public static int cnt;

    /**
     * 返回 a 中包含的密钥信息，返回一个数组
     *
     * @param b int[][]
     * @param a int[][]
     * @return  int[]
     */
    public static int[] countConsistentKeys(int[][] b, int[][] a) {
        StringBuilder stringBuilder = new StringBuilder();
        build();
        int[] arr = new int[b.length];
        int index = 0;
        for(int[] aa : a) {
            stringBuilder.setLength(0);
            for(int i = 1; i < aa.length; i++) {
                stringBuilder.append((aa[i] - aa[i - 1])).append("#");
            }
            insert(stringBuilder.toString());
        }
        for(int i = 0; i < b.length; i++) {
            stringBuilder.setLength(0);
            for(int j = 1; j < b[i].length; j++) {
                stringBuilder.append((b[i][j] - b[i][j - 1])).append("#");
            }
            arr[i] = prefixString(stringBuilder.toString());
        }
        clear();
        return arr;
    }

    /**
     * 树的重新构建过程
     */
    public static void build() {
        cnt = 1;
    }

    /**
     * 前缀树的插入操作
     *
     * @param word 单词
     */
    public static void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for(int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if(tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    /**
     * 返回以 word 为前缀的字符串数量
     *
     * @param word 字符串
     * @return 个数
     */
    public static int prefixString(String word) {
        int cur = 1;
        for(int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if(tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    /**
     * 根据不同的字符返回不同的路径信息，多字符的时候重点
     *
     * @param c 字符串
     * @return  返回路径
     */
    public static int path(char c) {
        if(c == '#') {
            return 10;
        }
        if(c == '-') {
            return 11;
        }
        return c - '0';
    }

    /**
     * 数组擦除，防止出现脏数据
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
        int[][] b = new int[][]{{1, 2, 3, 4, 5},
                                {2, 4, 6, 8},
                                {1, 4, 7, 10}};
        int[][] a = new int[][]{{3, 4, 5, 6, 7, 8},
                                {2, 4, 6, 8},
                                {1, 3, 5, 7, 9}};
        System.out.println(Arrays.toString(countConsistentKeys(b, a)));
        // [1, 2, 0]
    }
}
