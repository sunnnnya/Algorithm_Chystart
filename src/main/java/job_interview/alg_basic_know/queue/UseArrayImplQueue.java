package job_interview.alg_basic_know.queue;

/**
 * @BelongsPackage: job_interview.alg_basic_know.queue
 * @ClassName: UseArrayImplQueue
 * @Author: 丛虹羽
 * @Date: 2025/5/9 13:48
 * @Description: 使用数组模拟队列
 */
public class UseArrayImplQueue {

    /**
     * 使用数组模拟队列
     */
    private static class MyQueue {
        int l, r;

        private int[] queue;

        public MyQueue(int k) {
            l = r = 0;
            queue = new int[k];
        }

        /**
         * 添加元素
         *
         * @param x 添加的值
         */
        public void add(int x) {
            if (r != queue.length) {
                queue[r++] = x;
            }
        }

        /**
         * 获取队头元素（不删除）
         *
         * @return int
         */
        public int peek() {
            return queue[l];
        }

        /**
         * 获取队列头的元素，同时删除
         *
         * @return int
         */
        public int pop() {
            return queue[l++];
        }

        /**
         * 获取当前队列中的元素个数
         *
         * @return int
         */
        public int size() {
            return r - l;
        }

        /**
         * 判断是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return l == r;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(7);
        queue.add(12);
        queue.add(32);
        queue.add(10);
        System.out.println(queue.size()); // 3
        System.out.println(queue.pop());  // 12
        System.out.println(queue.peek()); // 32
        System.out.println(queue.pop()); //32
        System.out.println(queue.pop()); // 10
        System.out.println(queue.isEmpty()); // true
        System.out.println(queue.size()); // 0
    }
}
