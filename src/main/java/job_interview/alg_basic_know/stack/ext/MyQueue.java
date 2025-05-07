package job_interview.alg_basic_know.stack.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack.ext
 * @ClassName: MyQueue
 * @Author: 丛虹羽
 * @Date: 2025/5/7 22:51
 * @Description: 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
public class MyQueue {

    private final int MAXN = 2000;

    private int[] inSt;

    private int[] outSt;

    private int inIdx;

    private int outIdx;

    public MyQueue() {
        this.inSt = new int[MAXN];
        this.outSt = new int[MAXN];
        inIdx = 0;
        outIdx = 0;
    }

    public void push(int x) {
        inSt[inIdx++] = x;
    }

    public int pop() {
        addEleFromInStToOutSt();
        return outSt[--outIdx];
    }

    public int peek() {
        addEleFromInStToOutSt();
        return outSt[outIdx - 1];
    }

    public boolean empty() {
        return inIdx == 0 && outIdx == 0;
    }

    private void addEleFromInStToOutSt() {
        if (outIdx == 0) {
            while (inIdx != 0) {
                outSt[outIdx++] = inSt[--inIdx];
            }
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());  // 1
        System.out.println(myQueue.pop());   // 1
        System.out.println(myQueue.empty()); // false
    }
}
