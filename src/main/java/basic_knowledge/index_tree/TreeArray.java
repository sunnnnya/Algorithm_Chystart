package basic_knowledge.index_tree;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.tree_array
 * @ClassName: TreeArray
 * @Author: 丛虹羽
 * @Date: 2024/12/19 下午3:55
 * @Description: 单点增加 + 范围查询
 *
 *  原始数组，如下：
 * [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
 *  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
 *  —  —  —  —  —  —  —  —  —  —  —  —  —  —  —  —
 *  ————  ————  ————  ————  ————  ————  ————  ————
 *  ——————————  ——————————  ——————————  ——————————
 *  ——————————————————————  ——————————————————————
 *  ——————————————————————————————————————————————
 *
 * tree[1] = nums[1] = 1
 * tree[2] = nums[1] + nums[2] = 2
 * tree[3] = nums[3] = 1
 * tree[4] = nums[1] + nums[2] + nums[3] + nums[4] = 4
 * tree[5] = nums[5] = 1
 * tree[6] = nums[5] + nums[6] = 2
 * tree[7] = nums[7] = 1
 * tree[8] = nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6] + nums[7] + nums[8] = 8
 * tree[9] = nums[9] = 1
 * tree[10] = nums[9] + nums[10] = 2
 * tree[11] = nums[11] = 1
 * tree[12] = nums[9] + nums[10] + nums[11] + nums[12] = 4
 * tree[13] = nums[13] = 1
 * tree[14] = nums[13] + nums[14] = 2
 * tree[15] = nums[15] = 1
 * tree[16] = nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6] + nums[7] + nums[8] + nums[9] + nums[10] + nums[11] + nums[12] + nums[13] + nums[14] + nums[15] = 16
 *
 * 树状数组，如下：表示原数组的某个区间和
 * [1, 2, 1, 4, 1, 2, 1, 8, 1, 2, 1, 4, 1, 2, 1, 16]
 *  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16
 *
 * 1： 如何求当前 tree[i] 管的范围？ i 去掉最右侧的 1，然后 + 1 到自己
 *     tree[8] <=> 8 的 二进制 0 1 0 0 0 去掉右的一个 1 -> 0 0 0 0 0 然后再加 1 -> 0 0 0 0 1
 *     表示的范围是 : tree[8] = 0 0 0 0 1 ~ 0 1 0 0 0 <=> nums[1] + ... + nums[8]
 *
 * 查询：
 * 2：如果求前 15 个数的和：
 *     15 -> 0 1 1 1 1 -> 0 1 1 1 1 ~ 0 1 1 1 1 = nums[15]
 *      然后 0 1 1 1 1 -> 0 1 1 1 0 -> 0 1 1 0 1 ~ 0 1 1 1 0 = nums[13] + nums[14]
 *      然后 0 1 1 1 0 -> 0 1 1 0 0 -> 0 1 0 0 1 ~ 0 1 1 0 0 = nums[9] + nums[10] + nums[11] + nums[12]
 *      然后 0 1 1 0 0 -> 0 1 0 0 0 -> 0 0 0 0 1 ~ 0 1 0 0 0 = nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6] + nums[7] + nums[8]
 *      然后 0 1 0 0 0 -> 0 0 0 0 0 终止
 *
 * 单点修改：
 * 3：某个索引的值 + v
 *    nums[5] += v
 *    i 的 二进制比如：0 0 0 0 1 0 1 -> 当前位置 tree[5] += v
 *    然后加上 当前二进制中的最后一个 1 -> 0 0 0 0 1 0 1 + 0 0 0 0 0 0 1 => 0 0 0 0 1 1 0 = tree[6] += v
 *    然后加上 当前二进制中的最后一个 1 -> 0 0 0 0 1 1 0 + 0 0 0 0 0 1 0 => 0 0 0 1 0 0 0 = tree[8] += v
 *    然后加上 当前二进制中的最后一个 1 -> 0 0 0 1 0 0 0 + 0 0 0 1 0 0 0 => 0 0 1 0 0 0 0 = tree[16] += v
 *
 *  4：总结
 *      （1）求和时，只需要找到对应的区间，将这些区间相加即可。
 *      （2）修改时，只需要找到包含当前值的区间，进行修改即可
 *
 *  https://blog.csdn.net/z135733/article/details/136507999
 */
public class TreeArray {

    public static final int MAXN = 50001;

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
     * 原始数组某个位置的值 +v，对应树状数组记录修改
     *
     * @param i 原始数组 指定索引 位置
     * @param v 要增加的值
     */
    public static void add(int i, int v) {
        while(i <= n) {
            tree[i] += v;
            i += lowBit(i);
        }
    }

    /**
     * 返回 1 ~ i 范围累加和
     *
     * @param i
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
     * 指定区间的累加和
     *
     * @param l 左边界
     * @param r 右边界
     * @return
     */
    public static int range(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    /**
     * 打印树状数组
     */
    public static void printTree() {
        System.out.print("[");
        for(int i = 1; i <= TreeArray.n; i++) {
            if(i != TreeArray.n) {
                System.out.print(tree[i] + ", ");
            } else {
                System.out.print(tree[i]);
            }
        }
        System.out.println("]");
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 初始化树状数组
        TreeArray.n = 16;
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("原始数组：" + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            TreeArray.add(i + 1, nums[i]);
        }

        System.out.print("树状数组：");
        printTree();

        System.out.println("----------------------------测试用例：单点增加----------------------------");
        TreeArray.add(5, 3);
        System.out.print("5 位置值 +3 之后的树状数组：");
        printTree();
        System.out.println("索引 5 的值: " + TreeArray.range(5,5));
        System.out.println("前 5 个数的和: " + TreeArray.range(1,5));
        System.out.println();

        System.out.println("----------------------------测试用例：范围查询----------------------------");
        int rangeResult = TreeArray.range(3,10);
        System.out.println("范围[3，10]的和: " + rangeResult);
        System.out.println();

        System.out.println("------------------------------多次修改和查询------------------------------");
        TreeArray.add(2,2);
        TreeArray.add(7,4);
        TreeArray.add(10,5);
        int sumAfterModifications = TreeArray.range(1, 10);
        System.out.println("前 10 个数的和: " + sumAfterModifications);
        int rangeAfterModifications = TreeArray.range(5,10);
        System.out.println("范围[5，10]的和: " + rangeAfterModifications);
        System.out.println();
    }
}