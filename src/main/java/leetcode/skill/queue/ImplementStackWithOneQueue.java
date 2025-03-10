package leetcode.skill.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @package: leetcode.skill.queue
 * @author: chystart
 * @create: 2025-03-10 14:59
 * @description: 用队列实现栈
 *
 * leetcode: https://leetcode.cn/problems/implement-stack-using-queues/description/?envType=problem-list-v2&envId=CpTUTYZn
 **/
public class ImplementStackWithOneQueue {

    public static class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            // 队列初始化
            queue = new LinkedList<>();
        }

        /**
         * 压入数据
         *
         * @param x
         */
        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            for(int i = 0; i < size; i++) {
                queue.add(queue.poll());
            }
        }

        /**
         * 弹出队列的头部数据
         *
         * @return
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * 返回队列的头部数据
         *
         * @return
         */
        public int top() {
            return queue.peek();
        }

        /**
         * 通过是否为 空
         *
         * @return
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("top:" + stack.top());
        // seek:1
        System.out.println("pop:" + stack.pop());
        // pop:1
        System.out.println("empty:" + stack.empty());
        // empty:false
    }
}
