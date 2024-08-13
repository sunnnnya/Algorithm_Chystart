package practice_questions.stack.easy;

/**
 * @BelongsPackage: practice_questions.stack.easy
 * @ClassName: MinStackII
 * @Author: 丛虹羽
 * @Date: 2024/8/13 下午2:41
 * @Description: 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *      MinStack() 初始化堆栈对象。
 *      void push(int val) 将元素val推入堆栈。
 *      void pop() 删除堆栈顶部的元素。
 *      int top() 获取堆栈顶部的元素。
 *      int getMin() 获取堆栈中的最小元素。
 *
 * leetcode：https://leetcode.cn/problems/min-stack
 */
public class MinStackII {

    private static final int MAXN = 30000;
    private int[] dataStack;
    private int[] minStack;
    private int size;

    public MinStackII() {
        this.dataStack = new int[MAXN];
        this.minStack = new int[MAXN];
        this.size = 0;
    }

    /**
     * 向栈中添加元素
     *
     * @param val
     */
    public void push(int val) {
        dataStack[size] = val;
        if (size == 0) {
            minStack[size] = val;
        } else {
            // minStack[size - 1]：表示栈顶元素
            if (minStack[size - 1] > val) {
                minStack[size] = val;
            } else {
                minStack[size] = minStack[size - 1];
            }
        }
        size++;
    }

    /**
     * 删除栈顶元素
     */
    public void pop() {
        this.size--;
    }

    /**
     * 返回栈顶元素的位置
     *
     * @return
     */
    public int top() {
        return dataStack[size - 1];
    }

    /**
     * 获取最小的值
     *
     * @return
     */
    public int getMin() {
        return minStack[size - 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStackII stack = new MinStackII();
        stack.push(12);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(25);
        System.out.println(stack.top()); // 25
        System.out.println(stack.getMin()); // 2
        stack.pop();
        stack.pop();
        System.out.println(stack.top()); // 7
        System.out.println(stack.getMin()); //3
    }
}
