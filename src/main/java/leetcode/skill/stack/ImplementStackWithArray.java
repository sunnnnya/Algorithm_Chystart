package leetcode.skill.stack;

/**
 * @BelongsPackage: basic_knowledge.stack
 * @ClassName: ImplementStackUseArray
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午11:59
 * @Description: 使用数组的方式实现栈 —— 常数时间比 stack 好
 */
public class ImplementStackWithArray {

    /**
     * 自定义stack结构
     */
    public static class MyStack {

        public int[] stack;
        int size;

        public MyStack(int k) {
            stack = new int[k];
            size = 0;
        }

        /**
         * 入栈，size 表示要填入的位置
         * stack[size++] = val; -> stack[0] = val | size = 1
         *
         * @param val 待添加的元素
         */
        public void push(int val) {
            stack[size++] = val;
        }

        /**
         * 查看栈顶元素（不删除）
         *
         * @return r 是下一个元素要添加的位置，所以需要 return stack[r - 1]
         */
        public int peek() {
            return stack[size - 1];
        }

        /**
         * 返回栈顶元素（删除）
         *
         * @return 返回栈顶的元素同时删除，使用前置自减进行处理
         */
        public int pop() {
            return stack[--size];
        }

        /**
         * 返回元素个数
         *
         * @return
         */
        public int size() {
            // size 表示的是元素待存放的位置，也表示栈中元素的个数
            return size;
        }

        /**
         * 返回当前栈是否为空
         *
         * @return
         */
        public boolean empty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(12);
        stack.push(32);
        stack.push(10);
        stack.push(9);
        stack.push(4);
        System.out.println(stack.peek());  // 4
        System.out.println(stack.size());  // 5
        System.out.println(stack.pop());   // 4
        System.out.println(stack.empty()); // false
        System.out.println(stack.pop());   // 9
        System.out.println(stack.pop());   // 10
        System.out.println(stack.pop());   // 32
        System.out.println(stack.pop());   // 12
        System.out.println(stack.size);    // 0
        System.out.println(stack.empty()); // true
    }
}