package leetcode.skill.queue;

/**
 * @package: leetcode.skill.queue
 * @author: chystart
 * @create: 2025-03-11 08:54
 * @description: 使用数组实现队列
 **/
public class ImplementQueueWithArray {

    public static class MyQueue {

        public int[] queue;
        int l, r;

        public MyQueue(int k) {
            queue = new int[k];
            l = r = 0;
        }

        /**
         * 入队列，r 指针直接移动
         *
         * @param val 待添加的元素
         */
        public void push(int val) {
            queue[r++] = val;
        }

        /**
         * 查看队列顶元素（不删除）
         *
         * @return l 表示队列的头部
         */
        public int peek() {
            return queue[l];
        }

        /**
         * 返回队列顶元素（删除）
         *
         * @return 返回队列顶的元素同时删除
         */
        public int pop() {
            return queue[l++];
        }

        /**
         * 返回元素个数
         *
         * @return 队列中元素个数
         */
        public int size() {
            return r - l;
        }

        /**
         * 返回当前栈是否为空
         *
         * @return
         */
        public boolean empty() {
            return l == r;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        System.out.println("empty: " + queue.empty());
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println("empty: " + queue.empty());
        System.out.println("pop: " + queue.pop());
        System.out.println("peek: " + queue.peek());
        System.out.println("pop: " + queue.pop());
        System.out.println("peek: " + queue.peek());
        System.out.println("pop: " + queue.pop());
        System.out.println("empty: " + queue.empty());
    }
}
