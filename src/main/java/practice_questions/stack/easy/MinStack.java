package practice_questions.stack.easy;

import java.util.Stack;

/**
 * @BelongsPackage: practice_questions.stack
 * @ClassName: MinStack
 * @Author: 丛虹羽
 * @Date: 2024/8/13 上午11:11
 * @Description: 最小栈(使用系统提供的容器实现)
 *
 * 请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *      MinStack() 初始化堆栈对象。
 *      void push(int val) 将元素val推入堆栈。
 *      void pop() 删除堆栈顶部的元素。
 *      int top() 获取堆栈顶部的元素。
 *      int getMin() 获取堆栈中的最小元素。
 *
 * leetcode:https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof
 */
public class MinStack {

    /**
     * 成员的私有变量
     */
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * 初始化变量
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 更新最小栈中的信息
     *
     * @param x
     */
    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        }
    }

    /**
     * 删除栈顶元素，别忘记删除最小栈的栈顶元素，做好数据同步
     */
    public void pop() {
        if(!dataStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    /**
     * 获取栈顶元素
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * 获取当前栈中最小的值
     *
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }

    /**
     * 测试最小栈结构
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(-2);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); // 3
        System.out.println(stack.getMin()); // -2
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin()); // 1
    }
}
