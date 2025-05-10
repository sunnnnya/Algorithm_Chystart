package job_interview.alg_basic_know.stack;

import java.util.Stack;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack
 * @ClassName: SystemStack
 * @Author: 丛虹羽
 * @Date: 2025/5/10 10:56
 * @Description: 使用系统的栈结构
 */
public class UseSystemStack {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(123);
        st.push(21);
        System.out.println(st.peek()); // 21
        System.out.println(st.size()); // 2
        System.out.println(st.isEmpty()); // false
        System.out.println(st.pop()); // 21
        System.out.println(st.pop()); // 123
        System.out.println(st.size()); // 0
        System.out.println(st.isEmpty()); // true
    }
}
