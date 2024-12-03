package basic_knowledge.queue.easy;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: CreatingQueueUsingLinkedList
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午9:56
 * @Description: 使用链表的方式创建队列
 */
public class ImplementQueueUsingLinkedList {

    /**
     * 链表中节点的结构
     *
     * @param <T>
     */
    public static class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 自定义的队列实体类
     */
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * 判断是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 查询队列中元素的个数
         *
         * @return
         */
        public int size() {
            return size;
        }

        /**
         * 向队列中添加值
         *
         * @param value
         */
        public void offer(V value) {
            Node<V> cur = new Node<V>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = tail.next;
            }
            size++;
        }

        /**
         * 查看并且删除单链表中的元素
         *
         * @return
         */
        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            } else { // 尾巴保持一致
                tail = null;
            }
            return ans;
        }

        /**
         * 查看队列中的队顶元素
         *
         * @return
         */
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(23);
        queue.offer(22);
        queue.offer(20);
        queue.offer(12);
        queue.offer(9);
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.size()); // 5
        System.out.println(queue.peek()); // 23
        System.out.println(queue.poll()); // 23
        System.out.println(queue.poll()); // 22
        System.out.println(queue.poll()); // 20
        System.out.println(queue.poll()); // 12
        System.out.println(queue.poll()); // 9
        System.out.println(queue.size()); // 0
        System.out.println(queue.isEmpty()); // true
    }
}