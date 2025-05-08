package job_interview.code_top.array.hash_map;

import java.util.HashMap;
import java.util.Stack;

/**
 * @BelongsPackage: job_interview.code_top.array.hash_map
 * @ClassName: IsValid
 * @Author: 丛虹羽
 * @Date: 2025/5/8 20:08
 * @Description: 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/
 */
public class IsValid {

    /**
     * 哈希表的基本使用
     *
     * @param s 字符串
     * @return boolean
     */
    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        if ((c.length & 1) == 1) {
            return false;
        }
        HashMap<Character, Character> mp = new HashMap<>();
        Stack<Character> st = new Stack<>();
        mp.put(']', '[');
        mp.put('}', '{');
        mp.put(')', '(');
        for(char cc : c) {
            if (!mp.containsKey(cc)) {
                st.push(cc);
            } else if (st.isEmpty() || mp.get(cc) != st.pop()) {
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
        String s = "()[]{}";
        System.out.println(isValid(s));
        // true
    }
}
