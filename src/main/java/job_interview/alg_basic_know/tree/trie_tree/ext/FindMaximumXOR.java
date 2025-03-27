package job_interview.alg_basic_know.tree.trie_tree.ext;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @BelongsPackage: job_interview.alg_basic_know.tree.trie_tree.ext
 * @ClassName: TwoNumberMaximumXor
 * @Author: 丛虹羽
 * @Date: 2025/3/26 19:24
 * @Description: 数组中两个数的最大异或值
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/
 */
public class FindMaximumXOR {

    public static int MAXN = 3000001;

    public static int[][] tree = new int[MAXN][2];

    public static int cnt;

    // left：数组中最大元素的最左的 1 的位置
    public static int left;

    /**
     * 前缀树
     *
     * @param nums 原始数组
     * @return     最大的异或值
     */
    public static int findMaximumXOR1(int[] nums) {
        build(nums);
        int ans = 0;
        for (int num : nums){
            ans = Math.max(ans, maxXor(num));
        }
        clear();
        return ans;
    }

    /**
     * 构建前缀树过程
     *
     * @param nums 原始数组
     */
    public static void build(int[] nums) {
        cnt = 1;
        int mx = Integer.MIN_VALUE;
        for(int num : nums) {
            mx = Math.max(mx, num);
        }
        left = 31 - Integer.numberOfLeadingZeros(mx);
        for(int num : nums) {
            insert(num);
        }
    }

    /**
     * 构建前缀树
     *
     * @param num 要填充的数值
     */
    public static void insert(int num) {
        int cur = 1;
        for(int i = left, path; i >= 0; i--) {
            path = (num >> i) & 1;
            if(tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    /**
     * 返回异或之后的最大结果
     *
     * @return 返回异或的最大值
     */
    public static int maxXor(int num) {
        int ans = 0;
        int cur = 1;
        for(int i = left, status, want; i >= 0; i++) {
            status = (num >> i) & 1; // 当前值的状态: 0 | 1
            want = status ^ 1;       // 想要的值   : 1 | 0
            if(tree[cur][want] == 0) {
                // 遇不到想要的，直接
                want ^= 1;
            }
            ans |= (want ^ status) << i;
            cur = tree[cur][want];
        }
        return ans;
    }

    /**
     * 清除数据
     */
    public static void clear() {
        for(int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
        }
    }

    /**
     * 使用哈希表的方式实现，理解比较 better 的过程
     *
     * @param nums 原始数组
     * @return 最大异或值
     */
    public static int findMaximumXOR(int[] nums) {
        int mx = Integer.MIN_VALUE;
        for(int num : nums) {
            mx = Math.max(mx, num);
        }
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 31 - Integer.numberOfLeadingZeros(mx); i >= 0; i--) {
            int better = ans | (1 << i);
            set.clear();
            for(int num : nums) {
                num = ((num >> i) << i);
                set.add(num);
                if(set.contains(num ^ better)) {
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println("Result: " + findMaximumXOR(nums));
        // Result: 304
    }
}
