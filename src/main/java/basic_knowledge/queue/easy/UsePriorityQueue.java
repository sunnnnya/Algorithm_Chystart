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
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(21);
        integers.add(32);
        integers.add(1);
        integers.add(15);
        while (!integers.isEmpty()) {
            if (integers.size() == 1) {
                System.out.print(integers.poll());
            } else {
                System.out.print(integers.poll() + " -> ");
            }
        }
    }
}
