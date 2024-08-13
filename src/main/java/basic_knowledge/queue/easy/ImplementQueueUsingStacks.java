package basic_knowledge.queue.easy;

import java.util.Stack;

/**
 * @BelongsPackage: basic_knowledge.stack
 * @ClassName: SimulatedQueue
 * @Author: 丛虹羽
 * @Date: 2024/7/22 上午11:48
 * @Description: 使用两个栈 模拟 队列
 *
 * leetcode: https://leetcode.cn/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {

    public static class MyQueue<T> {
        // 插入的值存放的栈
        private Stack<T> inStack;
        // 查询的值存放的栈
        private Stack<T> outStack;

        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        /**
         * 倒数据
         */
        private void fromInStackToOutStack() {
            if(outStack.empty()) {
                while(!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        /**
         * 向队列中插入元素
         *
         * @param t
         */
        public void push(T t) {
            inStack.push(t);
            // 如果 outStack 全部为null的话，直接全部倒过去
            fromInStackToOutStack();
        }

        /**
         * 向队列中查询元素
         *
         * @return
         */
        public T pop() {
            // 只有outstack删除干净之后，才会从insatck把值倒出来，否则就是用outstack中的值
            fromInStackToOutStack();
            return outStack.pop();
        }

        /**
         * 获取队列的顶端，直接返回队列顶的值
         *
         * @return
         */
        public T peek() {
            fromInStackToOutStack();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(23);
        queue.push(25);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}