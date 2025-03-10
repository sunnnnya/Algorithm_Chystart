package leetcode.skill.stack;

import java.util.Stack;

/**
 * @package: leetcode.skill.stack
 * @author: chystart
 * @create: 2025-03-10 14:33
 * @description: 用栈实现队列
 *
 * leetcode: https://leetcode.cn/problems/implement-queue-using-stacks/description/
 **/
public class ImplementQueueUsingStacks {

    public static class MyQueue {

        // 用来存入数据的栈
        public Stack<Integer> in;

        // 用来输出数据的栈
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * 正常直接添加元素就可以
         *
         * @param x 元素
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * 直接弹出元素，但是当 out stack 空的时候需要到 in stack 倒出数据
         *
         * @return
         */
        public int pop() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        /**
         * 直接查看元素，但是当 out stack 空的时候需要到 in stack 倒出数据
         *
         * @return
         */
        public int peek() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /**
         * 只有当 in stack 和 out stack 为空的时候才为空
         *
         * @return
         */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("seek:" + queue.peek());
        // seek:1
        System.out.println("pop:" + queue.pop());
        // pop:1
        System.out.println("empty:" + queue.empty());
        // empty:false
    }
}
