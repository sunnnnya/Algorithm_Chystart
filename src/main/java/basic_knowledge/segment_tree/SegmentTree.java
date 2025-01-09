package basic_knowledge.segment_tree;

/**
 * @BelongsPackage: basic_knowledge.tree.segment_tree
 * @ClassName: SegmentTree
 * @Author: 丛虹羽
 * @Date: 2024/8/4 下午5:41
 * @Description: 线段树：如果原数组的长度是 N ，则准备 4N 长度的数组一定够用。
 *
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
    // change[]更新的值
    // update[]表示change数组index对应的值是不是更新的值，因为change数组有歧义，默认值为0，是更新为0.还有没有更新的值
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
     * 任务下发
     *
     * @param rt 当前节点的数组下标
     * @param ln 左子树结点个数
     * @param rn 右子树结点个数
     */
    private void pushDown(int rt, int ln, int rn) {
        if (update[rt]) {
            update[rt << 1] = true;
            update[rt << 1 | 1] = true;
            change[rt << 1]= change[rt];
            change[rt << 1 | 1] = change[rt];
            lazy[rt << 1] = 0;
            lazy[rt << 1 | 1] = 0;
            sum[rt << 1] = change[rt] * ln;
            sum[rt << 1 | 1] = change[rt] * rn;
            update[rt] = false;
        }
        if (lazy[rt] != 0){
            lazy[rt << 1] += lazy[rt];
            sum[rt << 1] += lazy[rt] * ln;
            lazy[rt <<1 | 1] += lazy[rt];
            sum[rt << 1 | 1] += lazy[rt] * rn;
            lazy[rt] = 0;
        }
    }

    /**
     * 初始化阶段，先把整个sum数组，填好
     * 在arr[l~r]范围上，去 build，1 ~ N
     * rt：这个范围在 sum 中的下标
     *
     * @param l    左边界
     * @param r    右边界
     * @param rt   当前数组的index索引
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

    /**
     * 在数组的指定范围内 数组值 + C
     * 285 ~ 1000 8 -> 在 285 <= index <= 1000 范围内的值都 + 8
     * 5 ~ 100 7    -> 当前节点表示 5 ~ 100 范围，索引为 7
     *
     * @param L 任务的左边界
     * @param R 任务的右边界
     * @param C 要加的值大小
     * @param l 当前节点表示的左边界范围
     * @param r 当前节点表示的右边界范围
     * @param rt 当前节点在数组中的索引位置
     */
    public void add(int L, int R, int C, int l, int r, int rt) {
        // 任务包含了节点信息：任务在 3 ~ 100 都加 7，但该节点表示5 ~ 96，则该索引rt位置的sum[]直接 + 和的数，同时lazy数组更新
        if(L <= l && r <= R) {
            // 表示当前节点表示范围中的数都加上固定的值
            sum[rt] += C * (r - l + 1);
            // 不再往下发了，拦住了
            lazy[rt] += C;
            return;
        }
        // 没有全部包含
        int mid = l + ((r - l) >> 1);
        pushDown(rt, mid - l + 1, r- mid);
        if (L <= mid) {
            add(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    /**
     * 指定区间范围上进行值的更新
     *
     * @param L 任务的左边界
     * @param R 任务的右边界
     * @param C 要修改的值
     * @param l 当前节点表示的左边界范围
     * @param r 当前节点表示的右边界范围
     * @param rt 当前节点在数组中的索引位置
     */
    public void update(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && r <= R) {
            update[rt] = true;
            change[rt] = C;
            sum[rt] = C * (r - l + 1);
            // 即使前面有很多个累加操作，但是一旦更新的话，直接lazy清0
            lazy[rt] = 0;
            return;
        }
        // 当前任务躲不掉，无法懒更新，要往下发
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    // 1 ~ 6累加和是多少? 1~8 rt
    public long query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1,r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {
            ans +=query(L, R,mid + 1, r,rt << 1 | 1);
        }
        return ans;
    }
}