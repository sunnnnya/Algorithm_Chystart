package basic_knowledge.tree.segment_tree;

/**
 * @BelongsPackage: basic_knowledge.tree.segment_tree
 * @ClassName: SegmentTree
 * @Author: 丛虹羽
 * @Date: 2024/8/4 下午5:41
 * @Description: 线段树：如果原数组的长度是 N ，则准备 4N 长度的数组一定够用。
 * 因为数组是从 1 ~ arr.length：
 *     结论：
 *         一个节点的父亲 ： i / 2
 *         一个节点的左孩子：i * 2
 *         一个节点的右孩子：(i * 2) + 1
 *
 * arr数组  ：[3, 4, 6, 7]
 * index索引： 1  2  3  4
 * 线段树数组：[20, 7, 13, 3, 4, 6, 7]
 * index索引： 1   2   3  4  5  6  7
 * 线段树结构：
 *                              20 ---> 表示下标 1 ~ 4 的累加和
 *                            |    \
 *   表示 1 ~ 2 的累加和  <--- 7     13 ---> 表示下标 3 ~ 4 的累加和
 *                          |  \   |  \
 *                         3    4  6   7
 *                         ↓    ↓  ↓   ↓
 *                        1~1  2~2 3~3 4~4
 *
 * 更新策略：懒更新（如果需要修改值的范围中有一个节点没有全部包住[继续传递]，有一个节点全部包住了[不传递，记住该值]）
 *      lazy：[0,  0,  0,  0,  0,  0,  0]   ->   [3,  0,  0,  0,  0,  0,  0]    ->   [0,  3,  3,  0,  0,  0,  0]    ->  [0,  4,  3,  3,  3,  0,  0]
 *     初始数组 1   2   3   4   5   6   7  完成(1)  1   2   3   4   5   6   7  完成[1]  1   2   3   4   5   6   7  完成[2]  1   2   3   4   5   6   7
 *            1~4 1~2 3~4 1~1 2~2 3~3 4~4        1~4 1~2 3~4 1~1 2~2 3~3 4~4         1~4 1~2 3~4 1~1 2~2 3~3 4~4        1~4 1~2 3~4 1~1 2~2 3~3 4~4
 *      （1）现在要在 1 ~ 4 的范围上统一加 3，则 1 ~ 4 范围就可以全包了：故 lazy数组更新：lazy[1] = 3 表示 1 ~ 4 范围的值每一个都需要加 3;
 *      （2）现在需要在 1 ~ 2 范围上加 4，首先查看 1 ~ 4 有没有拦住。
 *              [1]如果拦住了就把当前的 lazy[1] 向下一层传递，然后自己清空（lazy[1] = 0、lazy[2] = 3、lazy[3] = 3）;
 *              [2]然后看 1 ~ 2 有没有拦住，发现 lazy[2] = 3，则按照规律接着向下传递，然后清空lazy[2]并设置为4
 *-----------------------------------------------------------------------------------
 *  arr数组  ：[3, 2, 1, 0, 3]
 *  index索引： 1  2  3  4  5
 *
 *  线段树数组：[9, 5, 4, 3, 2, 1, 3, null, null, null, null, null, null, 0, 3]
 *  index索引： 1  2  3  4  5  6  7   8     9     10    11    12    13   14 15
 *                                 9 ---> 表示下标 1 ~ 5 的累加和
 *                             |        \
 *   表示 1 ~ 2 的累加和  <--- 5           4 ---> 表示下标 3 ~ 5 的累加和
 *                          |  \        |    \
 *      1 ~ 1 的累加和 <--- 3    2(2~2) 1(3~3) 3
 *                        |\    |\    |\     | \
 *                      空 空  空 空  空 空   0  3
 *                                          ↓   ↓
 *                                         4~4  5~5
 */
public class SegmentTree {
    // arr[]为原序列的信息从0开始，但在arr里是从1开始的
    // sum[]模拟线段树维护区间和
    // lazy[]为累加和懒惰标记
    // change[]为更新的值
    // update[]为更新慵懒标记
    private int MAXN;
    private int[] arr;
    private int[] sum;
    private int[] lazy;
    private int[] change;
    private boolean[] update;

    public SegmentTree(int[] origin) {
        MAXN = origin.length + 1;
        arr = new int[MAXN]; // arr[0] 不使用从index = 1开始
        for (int i = 0; i < origin.length; i++) {
            arr[i + 1] = origin[i];
        }
        sum = new int[MAXN << 2];       // 用来支持脑补概念中，某一个范围的累加和信息
        lazy = new int[MAXN << 2];      // 用来支持脑补概念中，某一个范围没有往下懒惰的累加任务
        change = new int[MAXN << 2];    // 用来支持脑补概念中，某一个范围有没有更新操作的任务
        update= new boolean[MAXN << 2]; // 用来支持脑补概念中，某一个范围更新任务，更新成了什么
    }

    /**
     * 利用左右孩子来填充当前节点的sum[]
     *
     * @param rootIndex 当前节点的下标，范围（1 ~ N）
     */
    private void pushUp(int rootIndex) {
        // rootIndex << 1      <=> rootIndex * 2
        // rootIndex << 1 | 1  <=> rootIndex * 2 + 1
        sum[rootIndex] = sum[rootIndex << 1] + sum[rootIndex << 1 | 1];
    }

    /**
     * 填充整个 sum 数组
     *
     * @param l
     * @param r
     * @param rt
     */
    public void build(int l, int r, int rt) {
        // 相当于只是对叶节点的值进行了sum[]填充
        if (l == r) {
            sum[rt] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, rt << 1);
        build(mid + 1, r, rt << 1 | 1);
        // 填充完所有的叶节点之后，对sum数组所有下标进行填充，逐个完善
        pushUp(rt);
    }

}
