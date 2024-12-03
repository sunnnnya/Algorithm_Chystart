package basic_knowledge.queue.easy;

/**
 * @BelongsPackage: basic_knowledge.queue.easy
 * @ClassName: ImplementQueueUsingStackWithArray
 * @Author: 丛虹羽
 * @Date: 2024/12/3 下午4:32
 * @Description: 使用栈模拟队列 - 同时使用数组的方式模拟栈结构
 */
public class ImplementQueueUsingStackWithArray {

    static class MyQueue {

        private final int MAXN = 2000;
        private int[] inStack;
        private int[] outStack;
        private int iIndex;
        private int oIndex;

        public MyQueue() {
            inStack = new int[MAXN];
            outStack = new int[MAXN];
            iIndex = 0;
            oIndex = 0;
        }

        /**
         * 向队列中添加元素
         *
         * @param x
         */
        public void push(int x) {
            inStack[iIndex++] = x;
        }

        /**
         * 弹出队列中的队首元素,题目中的要求数据自洽，不会出现没值直接弹出来的情况
         *
         * @return
         */
        public int pop() {
            if (oIndex == 0) {
                while(iIndex != 0) {
                    outStack[oIndex++] = inStack[--iIndex];
                }
            }
            return outStack[--oIndex];
        }

        /**
         * 查看队列中的元素
         *
         * @return
         */
        public int peek() {
            // 如果
            if(oIndex == 0) {
                while(iIndex != 0) {
                    outStack[oIndex++] = inStack[--iIndex];
                }
            }
            return outStack[oIndex - 1];
        }

        /**
         * 判断当前队列的值是否为空，只有两个队列中的index 都为0 的时候才为空
         *
         * @return
         */
        public boolean empty() {
            return iIndex == 0 && oIndex == 0;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(12);
        queue.push(31);
        queue.push(15);
        System.out.println(queue.empty()); // false
        System.out.println(queue.peek()); // 12
        System.out.println(queue.pop()); // 12
        System.out.println(queue.pop()); // 31
        System.out.println(queue.pop()); // 15
        System.out.println(queue.empty()); // true
    }
}