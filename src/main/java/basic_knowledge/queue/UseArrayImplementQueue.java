package basic_knowledge.queue;

/**
 * @BelongsPackage: basic_knowledge.queue
 * @ClassName: ImplementQueuUseArray
 * @Author: 丛虹羽
 * @Date: 2024/7/22 下午11:44
 * @Description: 使用 数组 模拟队列
 *
 * 本质就是边界指针的作用，因为不会出现在头部添加的情况，所以没有向双端链表那么复杂的边界判断
 */
public class UseArrayImplementQueue {

    public static class MyQueue {
        int[] queue;
        int l, r;

        public MyQueue(int k) {
            queue = new int[k];
            l = 0;
            r = 0;
        }

        /**
         * 添加元素
         *
         * @param number
         */
        public void add(int number) {
            if (r != queue.length) {
                queue[r++] = number;
            }
        }

        /**
         * 获取队头元素（不删除）
         *
         * @return
         */
        public int peek() {
            return queue[l];
        }

        /**
         * 获取队列头的元素，同时删除
         *
         * @return
         */
        public int pop() {
            return queue[l++];
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
        System.out.println(queue.pop());  // 12
        System.out.println(queue.peek()); // 32
        System.out.println(queue.pop()); //32
        System.out.println(queue.pop()); // 10
        System.out.println(queue.isEmpty()); // true
    }
}
