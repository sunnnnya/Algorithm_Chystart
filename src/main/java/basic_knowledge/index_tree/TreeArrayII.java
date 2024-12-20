package basic_knowledge.index_tree;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.tree_array
 * @ClassName: TreeArrayII
 * @Author: 丛虹羽
 * @Date: 2024/12/19 下午7:25
 * @Description: 树状数组 —— 范围修改 + 单点查询，逻辑完全相同，只是维护的信息变了，使用的不是原始数组 而是 差分数组
 * 原因：差分数组的前缀和 -> 单点的值，而不是范围
 */
public class TreeArrayII {

    public static final int MAXN = 50002;

    public static int[] tree = new int[MAXN];

    public static int n;

    /**
     * 返回一个数对应二进制中最右侧的 1 的值
     * 0 1 1 0 1 0 1 0 0 -> 0 0 0 0 0 0 1 0 0
     *
     * @param n 原始数
     * @return
     */
    public static int lowBit(int n) {
        return n & (~n + 1);
    }

    /**
     * 差分原始数组某个位置的值 +v，对应树状数组记录修改
     *
     * @param i 差分数组 指定索引 位置
     * @param v 要增加的值
     */
    public static void add(int i, int v) {
        while(i <= n) {
            tree[i] += v;
            i += lowBit(i);
        }
    }

    /**
     * 返回 i 索引位置的值
     * 单点查询
     *
     * @param i 索引下标
     * @return
     */
    public static int sum(int i) {
        int ans = 0;
        while(i > 0) {
            ans += tree[i];
            i -= lowBit(i);
        }
        return ans;
    }

    /**
     * 范围增加
     *
     * @param l 左边界
     * @param r 有边界
     * @param v 要加的值
     */
    public static void rangeAdd(int l, int r, int v) {
        add(l, v);
        add(r + 1, -v);
    }

    /**
     * 测试：范围增加 + 单点查询
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeArrayII.n = 10;
        int[] nums = new int[]{8, 9, 12, 13, 21, 33, 1, 21, 9, 7};
        System.out.println("原始数组：" + Arrays.toString(nums));

        // 使用差分数据构建，树状数组
        for (int i = 0; i < nums.length; i++) {
            TreeArrayII.add(i + 1, i == 0 ? nums[i] : nums[i] - nums[i - 1]);
        }

        System.out.println("-------------------------范围增加-------------------------");
        TreeArrayII.rangeAdd(1, 3, 4);
        // [8, 9, 12, 13, 21, 33, 1, 21, 9, 7] -> [12, 13, 16, 13, 21, 33, 1, 21, 9, 7]
        TreeArrayII.rangeAdd(2, 5, 6);
        // [12, 13, 16, 13, 21, 33, 1, 21, 9, 7] -> [12, 19, 22, 19, 27, 33, 1, 21, 9, 7]

        System.out.println("-------------------------单点查询-------------------------");
        System.out.println(TreeArrayII.sum(2));
        // 19
        System.out.println(TreeArrayII.sum(8));
        // 21
        System.out.println(TreeArrayII.sum(3));
        // 22
    }
}