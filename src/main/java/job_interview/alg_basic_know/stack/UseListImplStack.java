package job_interview.alg_basic_know.stack;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack
 * @ClassName: UseListImplStack
 * @Author: 丛虹羽
 * @Date: 2025/5/9 17:32
 * @Description: 使用链表模拟栈
 */
public class UseListImplStack {

    /**
     * 节点
     *
     * @param <T>
     */
    static class Node<T> {
        T val;
        Node<T> next;
        public Node(T value) {
            this.val = value;
        }
    }

    /**
     * 自定义栈结构信息
     *
     * @param <V> 泛型
     */
    static class MyStack<V> {
        private Node<V> head;
        private int size;

        /**
         * 插入元素
         *
         * @param value 添加的元素
         */
        public void push(V value) {
            Node<V> node = new Node(value);
            if(head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
            size++;
        }

        /**
         * 弹出队列的头部信息
         *
         * @return 返回队列的头部信息
         */
        public V pop() {
            V ans = null;
            if(!isEmpty()) {
                ans = head.val;
                head = head.next;
                size--;
            }
            return ans;
        }

        /**
         * 获取队列的头部信息
         *
         * @return 查询到
         */
        public V peek() {
            V ans = null;
            if(!isEmpty()) {
                ans = head.val;
            }
            return ans;
        }

        /**
         * 获取栈中的元素个数
         *
         * @return int
         */
        public int size() {
            return size;
        }

        /**
         * 判断当前的栈是否为null
         *
         * @return true | false
         */
        public boolean isEmpty() {
            return size == 0;
        }
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<>();
        st.push(12);
        st.push(32);
        st.push(21);
        st.push(11);
        System.out.println(st.size()); // 4
        System.out.println(st.pop());  // 11
        System.out.println(st.size()); // 3
        System.out.println(st.peek()); // 21
        System.out.println(st.pop());  // 21
        System.out.println(st.size()); // 2
    }
}
