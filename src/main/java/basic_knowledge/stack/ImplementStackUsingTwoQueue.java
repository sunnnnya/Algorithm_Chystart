package basic_knowledge.stack;

import java.util.LinkedList;

/**
 * @BelongsPackage: basic_knowledge.stack
 * @ClassName: ImplementStackUsingTwoQueue
 * @Author: 丛虹羽
 * @Date: 2024/12/3 下午12:14
 * @Description: 使用两个队列实现栈,
 */
public class ImplementStackUsingTwoQueue {

    static class MyStack {

        private final LinkedList<Integer> l1;
        private final LinkedList<Integer> l2;

        public MyStack() {
            l1 = new LinkedList<>();
            l2 = new LinkedList<>();
        }

        public void push(int x) {
            if (l1.isEmpty()) {
                l1.add(x);
                int size = l2.size();
                while(size-- != 0) {
                    l1.add(l2.poll());
                }
            } else {
                l2.add(x);
                int size = l1.size();
                while(size-- != 0) {
                    l2.add(l1.poll());
                }
            }
        }

        /**
         * 弹出栈顶元素同时删除
         *
         * @return
         */
        public int pop() {
            if (!l1.isEmpty()) {
                return l1.poll();
            }
            return l2.poll();
        }

        /**
         * 弹出栈顶元素
         *
         * @return
         */
        public int top() {
            if(!l1.isEmpty()) {
                return l1.peek();
            }
            return l2.peek();
        }

        /**
         * 返回是否为空
         *
         * @return
         */
        public boolean empty() {
            return l1.isEmpty() && l2.isEmpty();
        }
    }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("top -> " + myStack.top());
        // top -> 3
        System.out.println("pop -> " + myStack.pop());
        // pop -> 3
        System.out.println("top -> " + myStack.top());
        // top -> 2
        System.out.println("empty -> " + myStack.empty());
        // empty -> false
        System.out.println("pop -> " + myStack.pop());
        // pop -> 2
        System.out.println("pop -> " + myStack.pop());
        // pop -> 1
        System.out.println("empty -> " + myStack.empty());
        // empty -> true
    }
}