package basic_knowledge.queue.easy;

import java.util.PriorityQueue;

/**
 * @BelongsPackage: basic_knowledge.queue.easy
 * @ClassName: PriorityQueue
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午10:52
 * @Description: 优先级队列 后面的树的结构会用到
 */
public class UsePriorityQueue {
    public static void main(String[] args) {
        // 默认使用的是小根堆
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(21);
        integers.add(32);
        integers.add(1);
        integers.add(15);
        System.out.print("小根堆的优先级队列：");
        while (!integers.isEmpty()) {
            if (integers.size() == 1) {
                System.out.print(integers.poll());
            } else {
                System.out.print(integers.poll() + " -> ");
            }
            // 小根堆的优先级队列：1 -> 15 -> 21 -> 32
        }

        System.out.println();

        // 大根堆 从大到小
        PriorityQueue<Integer> integers1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        integers1.add(21);
        integers1.add(19);
        integers1.add(99);
        integers1.add(3);
        System.out.print("大根堆的优先级队列：");
        while (!integers1.isEmpty()) {
            if (integers1.size() == 1) {
                System.out.print(integers1.poll());
            } else {
                System.out.print(integers1.poll() + " -> ");
            }
            // 大根堆的优先级队列：99 -> 21 -> 19 -> 3
        }
    }
}
