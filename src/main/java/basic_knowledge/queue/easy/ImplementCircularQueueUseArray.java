package basic_knowledge.queue.easy;

/**
 * @BelongsPackage: basic_knowledge.queue
 * @ClassName: ImplementLoopQueueUseArray
 * @Author: 丛虹羽
 * @Date: 2024/7/23 上午12:33
 * @Description: 使用数组实现循环队列
 *
 * 设计循环队列
 *
 */
public class ImplementCircularQueueUseArray {

    /**
     * 使用循环数组实现队列
     */
    public static class CircularQueue {
        public int[] queue;
        public int l, r, size, limit;

        /**
         * init
         * @param k 数组的容量大小
         */
        public CircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        // 入队
        public boolean enQueue(int value) {
            if (isFull()) {
                // 满了不能再入队了
                return false;
            } else {
                // 相当于入队列
                queue[r] = value;
                // 如果当前的有边界已经在数组索引的 basic_knowledge.queue.length - 1 位置，需要重新置换成0， 否则正常 + 1
                r = r == limit - 1 ? 0 : r + 1;
                size++;
                return true;
            }
        }

        // 弹出队列 左指针右移
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == queue.length - 1 ? 0 : l + 1;
                size--;
                return true;
            }
        }

        // 返回队列头部的数字
        public int front() {
            if(isEmpty()) {
                return -1;
            } else {
                return queue[l];
            }
        }

        // 返回队列尾巴的数字
        public int rear() {
            if(isEmpty()) {
                return -1;
            } else {
                int last = r == 0 ? (limit -1) : (r - 1);
                return queue[last];
            }
        }

        /**
         * 判断队列是否空了
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 判断队列是否满了
         *
         * @return
         */
        public boolean isFull() {
            return size == limit;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        // 测试入队
        System.out.println(queue.enQueue(10)); // true
        System.out.println(queue.enQueue(20)); // true
        System.out.println(queue.enQueue(30)); // true
        System.out.println(queue.enQueue(40)); // true
        System.out.println(queue.enQueue(50)); // true
        System.out.println(queue.enQueue(60)); // false (队列已满)

        // 测试队列头部和尾部
        System.out.println(queue.front()); // 10
        System.out.println(queue.rear()); // 50

        // 测试出队
        System.out.println(queue.deQueue()); // true
        System.out.println(queue.deQueue()); // true

        // 测试队列头部和尾部
        System.out.println(queue.front()); // 30
        System.out.println(queue.rear()); // 50

        // 测试再次入队
        System.out.println(queue.enQueue(60)); // true
        System.out.println(queue.enQueue(70)); // true
        System.out.println(queue.enQueue(80)); // false (队列已满)

        // 测试队列头部和尾部
        System.out.println(queue.front()); // 30
        System.out.println(queue.rear()); // 70
    }
}
