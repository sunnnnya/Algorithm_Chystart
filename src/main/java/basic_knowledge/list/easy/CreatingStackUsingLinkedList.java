package basic_knowledge.list.easy;

/**
 * @BelongsPackage: basic_knowledge.list.easy
 * @ClassName: CreatingStackUsingLinkedList
 * @Author: 丛虹羽
 * @Date: 2024/7/26 下午10:31
 * @Description: TODO
 */
public class CreatingStackUsingLinkedList {

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
    public static class MyStack<V> {
        private Node<V> head;
        private int size;

        public MyStack() {
            head = null;
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
        public void push(V value) {
            Node<V> node = new Node<>(value);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        /**
         * 查看并且删除单链表中的元素
         *
         * @return
         */
        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        /**
         * 查看队列中的队顶元素
         *
         * @return
         */
        public V peek() {
            return head != null ? head.value : null;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(99);
        stack.push(100);
        System.out.println(stack.size()); // 2
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.peek()); // 100
        System.out.println(stack.pop()); // 100
        System.out.println(stack.size());  // 1
        System.out.println(stack.pop()); // 99
        System.out.println(stack.size()); // 0
        System.out.println(stack.isEmpty()); // true
    }
}
