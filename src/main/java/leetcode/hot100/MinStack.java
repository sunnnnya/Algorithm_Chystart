package leetcode.hot100;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 22:59
 * @description: 最小栈
 *
 * leetcode: https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class MinStack {

    // 最大数值
    public int MAXN = 30005;

    // 数据栈
    public int[] dataStack ;

    // 最小栈
    public int[] minStack ;

    // 栈指针
    public int r;

    // 初始化
    public MinStack() {
        dataStack = new int[MAXN];
        minStack = new int[MAXN];
        r = 0;
    }

    /**
     * 添加元素
     *
     * @param val
     */
    public void push(int val) {
        dataStack[r] = val;
        if (r == 0) {
            minStack[r] = val;
        } else {
            minStack[r] = Math.min(minStack[r - 1], val);
        }
        r++;
    }

    /**
     * 弹出元素
     */
    public void pop() {
        r--;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public int top() {
        return dataStack[r - 1];
    }

    /**
     * 获取最小元素
     *
     * @return
     */
    public int getMin() {
        return minStack[r - 1];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
