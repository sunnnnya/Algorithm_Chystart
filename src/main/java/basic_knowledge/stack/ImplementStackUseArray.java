package basic_knowledge.stack;

/**
 * @BelongsPackage: basic_knowledge.stack
 * @ClassName: ImplementStackUseArray
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午11:59
 * @Description: 使用数组的方式实现栈
 */
public class ImplementStackUseArray {

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
         * 入栈
         *
         * @param val
         */
        public void push(int val) {
            stack[size++] = val;
        }

        /**
         * 查看栈顶元素（不删除）
         *
         * @return
         */
        public int peek() {
            return stack[size - 1];
        }

        /**
         * 返回栈顶元素（删除）
         *
         * @return
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
        System.out.println(stack.peek()); // 4
        System.out.println(stack.size()); // 5
        System.out.println(stack.pop()); // 4
        System.out.println(stack.empty()); // false
        System.out.println(stack.pop()); // 9
        System.out.println(stack.pop()); // 10
        System.out.println(stack.pop()); // 32
        System.out.println(stack.pop()); // 12
        System.out.println(stack.size); // 0
        System.out.println(stack.empty()); // true
    }
}
