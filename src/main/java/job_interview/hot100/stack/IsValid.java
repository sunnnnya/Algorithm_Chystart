package job_interview.hot100.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: IsValid
 * @Author: 丛虹羽
 * @Date: 2025/7/29 09:34
 * @Description: 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsValid {

    /**
     * 栈实现
     *
     * @param s 字符串s
     * @return boolean
     */
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        for(char c : s.toCharArray()) {
            if(!mp.containsKey(c)) {
                st.push(c);
            } else if(st.isEmpty() || st.pop() != mp.get(c)) {
                return false;
            }
        }
        return st.isEmpty();
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String s = "{}";
        System.out.println(isValid(s));
        // true

        String str = "{(]}";
        System.out.println(isValid(str));
        // false
    }
}
