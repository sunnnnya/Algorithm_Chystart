package basic_knowledge.stack;

import java.util.Stack;

/**
 * @BelongsPackage: basic_knowledge.stack
 * @ClassName: MinStack
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午5:44
 * @Description: 最小栈（数组实现栈）
 * 关键点：使用O(1)的时间获取栈中最小的元素的
 *      知识点：
 *          记忆化搜索的思想
 *          数组实现栈，维持size变量 stack[size++] stack[--size]
 *  leetcode：https://leetcode.cn/problems/min-stack
 *      datastack：正常记录数字的栈
 *      minstack：记录状态信息，如果插入的值，比栈顶的元素大，则插入栈顶元素，反之插入当前值
 */
public class MinStack {

    public static class MyMinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyMinStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        /**
         * 插入元素
         *
         * @param number
         */
        public void push(Integer number) {
            this.dataStack.push(number);
            if (minStack.isEmpty() || number < minStack.peek()) {
                minStack.push(number);
            } else {
                // 重复压入最小的栈顶
                minStack.push(minStack.peek());
            }
        }

        /**
         * 不要忘记删除记录最小值的minStack中的信息
         *
         * @return
         */
        public Integer pop() {
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 查询栈顶元素
         *
         * @return
         */
        public Integer top() {
            return dataStack.peek();
        }

        /**
         * 返回栈的元素是否为null
         *
         * @return
         */
        public boolean isEmpty() {
            return dataStack.isEmpty();
        }

        /**
         * 获取栈中最小的元素
         *
         * @return
         */
        public Integer getMinNumber() {
            if(!minStack.isEmpty()) {
                return minStack.peek();
            } return null;
        }
    }

    /**
     * 使用数组的方式模拟 栈，优化
     */
    public static class MyMinStack2 {
        public static final Integer MAXN = 80001;
        public int[] data;
        public int[] min;
        int size;

        public MyMinStack2() {
            this.data = new int[MAXN];
            this.min = new int[MAXN];
            size = 0;
        }

        /**
         * 压入元素
         *
         * @param val
         */
        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]) {
                min[size] = val;
            } else {
                // 当前插入stack中的元素大于minStack的栈顶元素，minstack中直接压入栈顶元素
                min[size] = min[size - 1];
            }
            size++;
        }

        /**
         * 删除栈顶元素
         *
         * @return
         */
        public int pop() {
            // minstack维持的size同样也会变，做到删除的作用，如果重新添加就是值的覆盖
            return data[--size];
        }

        /**
         * 查看栈顶的值，但不删除
         *
         * @return
         */
        public int peek() {
            return data[size - 1];
        }

        /**
         * 获取当前datastack中的最小值
         *
         * @return
         */
        public int getMinNumber() {
            return min[size - 1];
        }
    }

    public static void main(String[] args) {
        MyMinStack myMinStack = new MyMinStack();
        myMinStack.push(32);
        myMinStack.push(21);
        myMinStack.push(3);
        myMinStack.push(2);
        myMinStack.push(1);
        System.out.println(myMinStack.getMinNumber()); // 1
        myMinStack.pop();
        System.out.println(myMinStack.getMinNumber()); // 2
        myMinStack.pop();
        System.out.println(myMinStack.getMinNumber()); // 3

        MyMinStack2 myMinStack2 = new MyMinStack2();
        myMinStack2.push(23);
        myMinStack2.push(2);
        myMinStack2.push(4);
        System.out.println(myMinStack2.getMinNumber()); // 2
        System.out.println(myMinStack2.peek()); // 4
        System.out.println(myMinStack2.pop()); // 4
        System.out.println(myMinStack2.getMinNumber()); // 2
        System.out.println(myMinStack2.pop()); // 2
        System.out.println(myMinStack2.getMinNumber()); // 23
    }
}
