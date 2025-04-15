package job_interview.alg_basic_know.stack.ext;

import java.util.Stack;

/**
 * @BelongsPackage: job_interview.alg_basic_know.stack.ext
 * @ClassName: BackspaceCompare
 * @Author: 丛虹羽
 * @Date: 2025/4/15 23:15
 * @Description: 比较含退格的字符串
 * https://leetcode.cn/problems/backspace-string-compare/description/
 */
public class BackspaceCompare {

    /**
     * 栈的基本使用
     *
     * @param s string s
     * @param t string t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        return getDeletedString(s).equals(getDeletedString(t));
    }

    /**
     * 比较两个字符串
     *
     * @param str string
     * @return
     */
    private static String getDeletedString(String str) {
        char[] c = str.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char cc : c) {
            if(cc == '#' && st.isEmpty()) {
                continue;
            } else if (cc != '#') {
                st.push(cc);
            } else if(cc == '#' && !st.isEmpty()) {
                st.pop();
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        while(!st.isEmpty()) {
            strBuilder.append(st.pop());
        }
        return strBuilder.toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        // true
    }
}
