package basic_knowledge.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsPackage: basic_knowledge.queue
 * @ClassName: ImplementStackUsingQueue
 * @Author: 丛虹羽
 * @Date: 2024/12/3下午12:39
 * @Description: 使用 队列 模拟 实现 栈
 * 面试题：请使用 队列 实现图的 深度优先遍历 <=> 使用队列来模拟栈
 *
 * 思想：对插入队列中元素之前存储的元素进行重新入队，模拟倒序的情况
 *
 * leetcode: https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingOneQueue {

    public static class MyStack<T> {

        private Queue<T> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * 插入元素，如果插入的队列之前为空，则只插入就行，不需要反转
         * 但，如果插入之前的队列是有值的，先插入当前值，然后对之前队列的值进行反转，然后重新写入
         *
         * @param t
         */
        public void add(T t) {
            if (queue.isEmpty()) {
                queue.add(t);
            } else {
                // 先插入，然后再翻转
                int size = queue.size();
                queue.add(t);
                while(size-- != 0) {
                    queue.add(queue.poll());
                }
            }
        }

        /**
         * 查看并删除队首元素
         *
         * @return
         */
        public T pop() {
            return queue.poll();
        }

        /**
         * 查看队首元素
         *
         * @return
         */
        public T top() {
            return queue.peek();
        }

        /**
         * 判断队列是否为空
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
        MyStack<Integer> myStack = new MyStack<>();
        myStack.add(12);
        myStack.add(21);
        System.out.println(myStack.empty()); // false
        System.out.println(myStack.top()); // 21
        System.out.println(myStack.top()); // 21
        System.out.println(myStack.pop()); // 21
        System.out.println(myStack.pop()); // 12
        System.out.println(myStack.top()); // null
        System.out.println(myStack.empty()); // true
    }
}