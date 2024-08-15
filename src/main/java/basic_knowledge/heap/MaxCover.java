package basic_knowledge.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: basic_knowledge.heap
 * @ClassName: Demo
 * @Author: 丛虹羽
 * @Date: 2024/8/15 下午4:19
 * @Description:
 *
 * 最大线段重合问题（堆实现）
 *      给定很多线段，每个线段都有两个数[start, end], 表示线段开始位置和结束位置，左右都是闭区间规定 :
 *      （1）线段的开始和结束位置一定都是整数值
 *      （2）线段重合区域的长度必须 >= 1
 *   返回线段最多重合区域中，包含了几条线段
 */
public class MaxCover {

    /**
     * 线段的实体类
     */
    public static class Line {
        public int start;
        public int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 所有的线段，先按照 start 位置，排序（从小到大）【准备一个小根堆】；
     *      然后依次遍历所有的线段[start, end] 在优先队列中找到 <= start 的值弹出【理解：用左边界去剔除不满足条件的数】
     *      然后塞入 end 到优先队列中，此时队列中有几个数，就是当前线段对应的答案，
     *      最后的最大答案，就是最大重合数。
     */
    public static int maxCover(int[][] segment) {
        // 初始化线段数组
        Line[] lines = new Line[segment.length];
        for (int i = 0; i < segment.length; i++) {
            lines[i] = new Line(segment[i][0], segment[i][1]);
        }
        Arrays.sort(lines, (o1, o2) -> o1.start - o2.start);
        // 创建小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < segment.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= segment[i][0]) {
                heap.poll();
            }
            heap.add(segment[i][1]);
            max = Math.max(max, heap.size());
        }
        return max;
    }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
