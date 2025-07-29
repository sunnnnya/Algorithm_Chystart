package job_interview.hot100.stack;

import java.util.Stack;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: DecodeString
 * @Author: 丛虹羽
 * @Date: 2025/7/29 10:50
 * @Description: 字符串解码
 * https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DecodeString {

    /**
     * 栈的使用
     *
     * @param s 原始字符串
     * @return String
     */
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> digitStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '[') {
                digitStack.push(multi);
                strStack.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int number = digitStack.pop();
                for(int i = 0; i < number; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strStack.pop() + tmp.toString());
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        System.out.println(decodeString(str));
        // abcabccdcdcdef
    }
}
