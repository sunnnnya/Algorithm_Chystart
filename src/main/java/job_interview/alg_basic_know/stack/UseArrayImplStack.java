package job_interview.alg_basic_know.stack;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack
 * @ClassName: UseArrayImplStack
 * @Author: 丛虹羽
 * @Date: 2025/5/7 23:02
 * @Description: 使用数组的方式实现栈
 */
public class UseArrayImplStack {

    private static class MyStack<T> {

        private Object[] st;

        private int idx;

        public MyStack() {
            st = new Object[2000];
            idx = 0;
        }

        public void push(T t) {
            st[idx++] = t;
        }

        public T pop() {
            return (T) st[--idx];
        }

        public T peek() {
            return (T) st[idx - 1];
        }

        public boolean isEmpty() {
            return idx == 0;
        }

        public int size() {
            return idx;
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(12);
        myStack.push(90);
        myStack.push(100);
        System.out.println(myStack.size());    // 3
        System.out.println(myStack.peek());    // 100
        System.out.println(myStack.pop());     // 100
        System.out.println(myStack.peek());    // 90
        System.out.println(myStack.isEmpty()); // false
        System.out.println(myStack.pop());     // 90
        System.out.println(myStack.pop());     // 12
        System.out.println(myStack.size());    // 0
        System.out.println(myStack.isEmpty()); // true
    }
}
