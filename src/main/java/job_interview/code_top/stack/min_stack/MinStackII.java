package job_interview.code_top.stack.min_stack;


/**
 * @BelongsPackage: job_interview.code_top.stack.min_stack
 * @ClassName: MinStackII
 * @Author: 丛虹羽
 * @Date: 2025/5/10 23:20
 * @Description: 最小栈
 * https://leetcode.cn/problems/min-stack/description/
 */
public class MinStackII {

    private final int MAXN = 30001;

    private int[] dst;

    private int[] mst;

    private int r;

    public MinStackII() {
        r = 0;
        dst = new int[MAXN];
        mst = new int[MAXN];
    }

    /**
     * 插入元素
     *
     * @param val 元素
     */
    public void push(int val) {
        dst[r] = val;
        if(r == 0) {
            mst[r] = val;
        } else {
            mst[r] = Math.min(mst[r - 1], val);
        }
        r++;
    }

    /**
     * 弹出数据栈顶中的数据
     */
    public void pop() {
        r--;
    }

    /**
     * 获取栈中栈顶的元素，但不删除
     *
     * @return int
     */
    public int top() {
        return dst[r - 1];
    }

    /**
     * 获取栈中的最小值
     *
     * @return int
     */
    public int getMin() {
        return mst[r - 1];
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
