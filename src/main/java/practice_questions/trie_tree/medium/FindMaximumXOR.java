package practice_questions.trie_tree.medium;

/**
 * @BelongsPackage: practice_questions.trie_tree.medium
 * @ClassName: FindMaximumXOR
 * @Author: 丛虹羽
 * @Date: 2024/8/24 上午11:09
 * @Description: 数组中两个数的最大异或值
 *
 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * leetcode: https://leetcode.cn/problems/ms70jA
 */
public class FindMaximumXOR {

    public static int MAXN = 3000001;

    public static int[][] tree = new int[MAXN][2];

    public static int cnt;

    // 数组中的最大值的，最左侧的1的索引位置，否则浪费空间
    public static int high;

    /**
     * 前缀树的拓展使用
     *
     * @return
     */
    public static int findMaximumXOR(int[] nums) {
        build(nums);
        int ans = 0;
        for (int number : nums) {
            ans = Math.max(ans, maxXor(number));
        }
        clear();
        return ans;
    }

    /**
     * 构建前缀树
     *
     * @param nums
     */
    public static void build(int[] nums) {
        cnt = 1;
        // 找最大值
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }

    /**
     * 插入数据到前缀树
     *
     * @param num
     */
    public static void insert(int num) {
        int cur = 1;
        for (int i = high, path; i >= 0; i--) {
            path = (num >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    /**
     * 找到最大的异或值
     *
     * @param num
     * @return
     */
    public static int maxXor(int num) {
        int cur = 1;
        int ans = 0;
        for (int i = high, status, want; i >= 0; i--) {
            status = (num >> i) & 1;
            want = status ^ 1;
            if (tree[cur][want] == 0) {
                want ^= 1;
            }
            ans |= (status ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }

    /**
     * 清楚函数
     */
    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            tree[i][0] = tree[i][1] = 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3,10,5,25,2,8};
        System.out.println(findMaximumXOR(arr));
        // 28

        int[] arr1 = new int[]{0};
        System.out.println(findMaximumXOR(arr1));
        // 0
    }
}
