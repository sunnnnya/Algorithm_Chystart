package basic_knowledge.list.easy;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: CreateDequeUsingLinkedList
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午11:12
 * @Description: 使用双端链表的方式创建双端队列
 */
public class CreateDequeUsingLinkedList {

    /**
     * 双端队列中的节点信息
     *
     * @param <V>
     */
    public static class Node<V> {
        private V value;
        private Node<V> last;
        private Node<V> next;
        public Node(V value) {
            this.value = value;
        }
    }

    /**
     * 实现队列
     *
     * @param <V>
     */
    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;
        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * 判断双端队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回size
         *
         * @return
         */
        public int size() {
            return size;
        }

        /**
         * 向双端队列的头部添加元素
         *
         * @param value
         */
        public void offerFirst(V value) {
            Node<V> firstNode = new Node<>(value);
            if (head == null) {
                head = firstNode;
                tail = firstNode;
            } else {
                firstNode.next = head;
                head.last = firstNode;
                head = firstNode;
            }
            size++;
        }

        /**
         * 向双端队列的头部添加元素
         *
         * @param value
         */
        public void offerLast(V value) {
            Node<V> lastNode = new Node<>(value);
            if (head == null) {
                head = lastNode;
                tail = lastNode;
            } else {
                tail.next = lastNode;
                lastNode.last = tail;
                tail = lastNode;
            }
            size++;
        }

        /**
         * 查看双端队列队首元素
         *
         * @return
         */
        public V peekFirst() {
            V ans = null;
            if(head != null) {
                ans = head.value;
            }
            return ans;
        }

        /**
         * 查看双端队列队尾元素
         *
         * @return
         */
        public V peekLast() {
            V ans = null;
            if(tail != null) {
                ans = tail.value;
            }
            return ans;
        }

        /**
         * 查看双端队列的队首元素且删除
         *
         * @return
         */
        public V popFirst() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            // 说明当前队列中就一个节点，需要重新置空，细节的考虑一定要注意！！！
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                // JVM自动释放断掉
                head.last = null;
            }
            return ans;
        }

        /**
         * 查看双端队列的队尾元素且删除
         *
         * @return
         */
        public V popLast() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                // JVM自动释放断掉
                tail.next = null;
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
        MyDeque<Integer> deque = new MyDeque<>();
        deque.offerFirst(21);
        System.out.println(deque.peekFirst()); // 21
        System.out.println(deque.popFirst()); // 21
        System.out.println(deque.isEmpty()); // true
        System.out.println(deque.size()); // 0
        deque.offerFirst(99);
        System.out.println(deque.peekLast()); // 99
        System.out.println(deque.popLast()); // 99
        System.out.println(deque.isEmpty()); // true
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println(deque.size()); // 4
        System.out.println(deque.peekFirst()); // 2
        System.out.println(deque.peekLast()); // 4
    }
}
