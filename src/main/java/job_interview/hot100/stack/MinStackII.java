package job_interview.hot100.stack;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: MinStackII
 * @Author: 丛虹羽
 * @Date: 2025/7/29 21:48
 * @Description: 最小栈
 * https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinStackII {

    public class Node {
        int dataNode, minNode;
        public Node(int dataNode, int minNode) {
            this.dataNode = dataNode;
            this.minNode = minNode;
        }
    }

    private final int MAXN = 30005;

    private Node[] stack;

    private int r = 0;

    public MinStackII() {
        stack = new Node[MAXN];
    }

    public void push(int val) {
        stack[r] = r == 0 ? new Node(val, val) : new Node(val, Math.min(val, stack[r - 1].minNode));
        r++;
    }

    public void pop() {
        r--;
    }

    public int top() {
        return stack[r - 1].dataNode;
    }

    public int getMin() {
        return stack[r - 1].minNode;
    }
}