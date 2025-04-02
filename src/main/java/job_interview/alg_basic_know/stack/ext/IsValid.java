package job_interview.alg_basic_know.stack.ext;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack.ext
 * @ClassName: IsValid
 * @Author: 丛虹羽
 * @Date: 2025/4/2 22:00
 * @Description: 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/
 */
public class IsValid {

    /**
     * 栈的基本使用
     *  细节：需要进行匹配，证明字符串的长度信息一定是 2 的倍数
     *
     * @param s 字符串
     * @return 返回是否是一个匹配的字符串
     */
    public static boolean isValid(String s) {
        if((s.length() & 1) != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> st = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                st.push(c);
            } else if(st.isEmpty() || st.pop() != map.get(c)){
                return false;
            }
        }
        return st.isEmpty();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "()[]{}";
        System.out.println(isValid(str1));
        // true

        String str2 = "(]";
        System.out.println(isValid(str2));
        // false
    }
}
