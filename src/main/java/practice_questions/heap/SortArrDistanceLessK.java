package practice_questions.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @BelongsPackage: practice_questions.heap
 * @ClassName: HeapSortPlus
 * @Author: 丛虹羽
 * @Date: 2024/7/31 下午4:26
 * @Description: 堆排序的拓展
 *
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过 k，
 * 并且 k 相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 *
 * 使用优先队列 逐渐 填充数组， 然后确定最小值
 */
public class SortArrDistanceLessK {

    /**
     * 排序，使用优先级队列进行逐步填充，然后逐步取顶，逐步填充
     *
     * @param arr
     * @param k
     */
    public static void sortArrDistanceLessK(int[] arr, int k) {

        /**
         * 使用优先级队列，默认小根堆
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int index = 0;
        int i = 0;
        for (;index < Math.min(arr.length, k + 1); index++) {
            priorityQueue.add(arr[index]);
        }
        for (;index < arr.length; index++, i++) {
            priorityQueue.add(arr[index]);
            arr[i] = priorityQueue.poll();
        }
        // 全部遍历完成之后，但是队列中的其他值还有弹出呢
        while (!priorityQueue.isEmpty()) {
            arr[i++] = priorityQueue.poll();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 3, 6, 7, 9, 8};
        sortArrDistanceLessK(arr, 2);
        System.out.println(Arrays.toString(arr));
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
