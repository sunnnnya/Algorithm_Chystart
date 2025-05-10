package job_interview.code_top.stack.min_stack;

import java.util.Stack;

/**
 * @BelongsPackage: job_interview.code_top.stack.min_stack
 * @ClassName: MinStack
 * @Author: 丛虹羽
 * @Date: 2025/5/10 23:18
 * @Description: 最小栈
 * https://leetcode.cn/problems/min-stack/description/
 */
public class MinStack {
    private Stack<Integer> dataSt;

    private Stack<Integer> minSt;

    public MinStack() {
        dataSt = new Stack<>();
        minSt = new Stack<>();
    }

    /**
     * 添加元素到栈中
     *
     * @param val 数值
     */
    public void push(int val) {
        dataSt.push(val);
        if(minSt.isEmpty()) {
            minSt.push(val);
        } else {
            minSt.push(Math.min(minSt.peek(), val));
        }
    }

    /**
     * 删除元素
     */
    public void pop() {
        dataSt.pop();
        minSt.pop();
    }

    /**
     * 获取当前栈顶元素的值
     *
     * @return int
     */
    public int top() {
        return dataSt.peek();
    }

    /**
     * 获取当前栈中的最小值
     *
     * @return int
     */
    public int getMin() {
        return minSt.peek();
    }
}
