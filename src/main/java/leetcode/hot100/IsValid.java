package leetcode.hot100;

import java.util.Stack;

/**
 * @package: leetcode.hot100
 * @author: chystart
 * @create: 2025-03-06 22:36
 * @description: 有效的括号、
 *
 * leetcode: https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 **/
public class IsValid {

    /**
     * 原始栈的使用
     *
     * @param s 原始字符串
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(char ch : c) {
            if(stack.isEmpty() || ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if(ch == ')' && stack.peek() != '(') {
                    return false;
                } else if (ch == ']' && stack.peek() != '[') {
                    return false;
                } else if(ch == '}' && stack.peek() != '{') {
                    return false;
                } else if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "()";
        System.out.println(isValid(str1));
        // true

        String str2 = "()[]{}";
        System.out.println(isValid(str2));
        // true

        String str3 = "([])";
        System.out.println(isValid(str3));
        // true

        String str4 = "(]";
        System.out.println(isValid(str4));
        // false
    }
}
