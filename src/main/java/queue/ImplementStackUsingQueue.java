package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsPackage: queue
 * @ClassName: ImplementStackUsingQueue
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午12:39
 * @Description: 使用 队列 模拟 实现 栈
 * leetcode: https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueue {

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
                queue.add(t);
                int size = queue.size();
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

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.add(12);
        myStack.add(21);
        System.out.println(myStack.empty()); // false
        System.out.println(myStack.top()); // 12
        System.out.println(myStack.top()); // 12
        System.out.println(myStack.pop()); // 12
        System.out.println(myStack.pop()); // 21
        System.out.println(myStack.top()); // null
        System.out.println(myStack.empty()); // true
    }
}
