package job_interview.hot100.stack;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: MinStack
 * @Author: 丛虹羽
 * @Date: 2025/7/29 09:39
 * @Description: 最小栈
 * https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinStack {

    private final int MAXN = 30005;

    private int l, r;

    private int[] dataSt;

    private int[] minSt;


    public MinStack() {
        l = r = 0;
        dataSt = new int[MAXN];
        minSt = new int[MAXN];
    }

    public void push(int val) {
        dataSt[r] = val;
        minSt[r] = r == 0 ? val : Math.min(minSt[r - 1], val);
        r++;
    }

    public void pop() {
        r--;
    }

    public int top() {
        return dataSt[r - 1];
    }

    public int getMin() {
        return minSt[r - 1];
    }
}
