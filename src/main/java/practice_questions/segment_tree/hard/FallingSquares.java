package practice_questions.segment_tree.hard;

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

    public static class SegmentTree {
        private int[] max;
        private int[] change;
        private boolean[] update;
        public SegmentTree(int size) {
            int N = size + 1;
            max = new int[N << 2];
            change = new int[N << 2];
            update = new boolean[N << 2];
        }

        public void pushUp(int rt) {
            max[rt] = Math.max(max[rt << 1], max[rt << 1 | 1]);
        }

        public void pushDown(int rt, int )
    }

    /**
     * 改写线段树实现返回最大值
     *
     * @param positions
     * @return
     */
    public List<Integer> fallingSquares(int[][] positions) {
        return null;
    }
}
