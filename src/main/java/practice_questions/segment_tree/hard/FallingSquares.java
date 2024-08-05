package practice_questions.segment_tree.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.segment_tree
 * @ClassName: FallingSquares
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午2:56
 * @Description: 掉落的方块 - 线段树的改写
 *
 * leetcode：https://leetcode.cn/problems/falling-squares/description/
 *
 * 在二维平面上的 x 轴上，放置着一些方块。
 * 给你一个二维整数数组 positions ，其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。
 * 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。一个方块仅仅是擦过另一个方块的左侧边或右侧边不算着陆。一旦着陆，它就会固定在原地，无法移动。
 * 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。
 * 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。
 *
 * 注意点：
 *      防止贴边，比如 [1, 3]表示以 x = 1 起点，长度为 3,则 [1 ~ 4] + 3
 *      如果，再来一个[4, 2] 表示 [4 ~ 6] + 2，就会出现问题，正常是不会摞起来的而是，贴边对齐的
 *      所以，[1, 3]表示[1~3] + 3
 *
 * 思路：先查询要落下的范围的最大值是多少，然后再加上高度
 *
 */
public class FallingSquares {

    public static int MAXN = 2001;

    public static int[] arr = new int[MAXN];

    public static int[] max = new int[MAXN << 2];

    public static int[] change = new int[MAXN << 2];

    public static boolean[] update = new boolean[MAXN << 2];

    public static int collect(int[][] poss) {
        int size = 1;
        for (int[] pos : poss) {
            arr[size++] = pos[0];
            arr[size++] = pos[0] + pos[1] - 1;
        }
        Arrays.sort(arr, 1, size);
        int n = 1;
        for (int i = 2; i < size; i++) {
            if (arr[n] != arr[i]) {
                arr[++n] = arr[i];
            }
        }
        return n;
    }

    public static int rank(int n, int v) {
        int ans = 0;
        int l = 1, r = n, m;
        while (l <= r) {
            m = (l + r) >> 1;
            if (arr[m] >= v) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void up(int i) {
        max[i] = Math.max(max[i << 1], max[i << 1 | 1]);
    }

    public static void down(int i) {
        if (update[i]) {
            lazy(i << 1, change[i]);
            lazy(i << 1 | 1, change[i]);
            update[i] = false;
        }
    }

    public static void lazy(int i, int v) {
        update[i] = true;
        change[i] = v;
        max[i] = v;
    }

    public static void build(int l, int r, int i) {
        if (l < r) {
            int mid = (l + r) >> 1;
            build(l, mid, i << 1);
            build(mid + 1, r, i << 1 | 1);
        }
        max[i] = 0;
        change[i] = 0;
        update[i] = false;
    }

    public static void update(int jobl, int jobr, int jobv, int l, int r, int i) {
        if (jobl <= l && r <= jobr) {
            lazy(i, jobv);
        } else {
            int mid = (l + r) >> 1;
            down(i);
            if (jobl <= mid) {
                update(jobl, jobr, jobv, l, mid, i << 1);
            }
            if (jobr > mid) {
                update(jobl, jobr, jobv, mid + 1, r, i << 1 | 1);
            }
            up(i);
        }
    }

    public static int query(int jobl, int jobr, int l, int r, int i) {
        if (jobl <= l && r <= jobr) {
            return max[i];
        }
        int mid = (l + r) >> 1;
        down(i);
        int ans = Integer.MIN_VALUE;
        if (jobl <= mid) {
            ans = Math.max(ans, query(jobl, jobr, l, mid, i << 1));
        }
        if (jobr > mid) {
            ans = Math.max(ans, query(jobl, jobr, mid + 1, r, i << 1 | 1));
        }
        return ans;
    }

    /**
     * 改写线段树实现返回最大值
     *
     * @param positions
     * @return
     */
    public List<Integer> fallingSquares(int[][] positions) {
        int n = collect(positions);
        build(1, n, 1);
        List<Integer> ans = new ArrayList<>();
        int max = 0, l, r, h;
        for (int[] square : positions) {
            l = rank(n, square[0]);
            r = rank(n, square[0] + square[1] - 1);
            h = query(l, r, 1, n, 1) + square[1];
            max = Math.max(max, h);
            ans.add(max);
            update(l, r, h, 1, n, 1);
        }
        return ans;
    }
}
