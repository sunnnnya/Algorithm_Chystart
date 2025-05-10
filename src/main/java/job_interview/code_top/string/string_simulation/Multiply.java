package job_interview.code_top.string.string_simulation;

/**
 * @BelongsPackage: job_interview.code_top.string.string_simulation
 * @ClassName: Multiply
 * @Author: 丛虹羽
 * @Date: 2025/5/11 00:04
 * @Description: 字符串相乘
 * https://leetcode.cn/problems/multiply-strings/description/
 */
public class Multiply {

    /**
     * 字符串的乘法模拟
     *
     * @param num1 字符串 1
     * @param num2 字符串 2
     * @return string
     */
    static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        for(int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            for(int k = num1.length() - 1; k >= 0; k--) {
                int n1 = num1.charAt(k) - '0';
                int tmp = (n1 * n2) + carry;
                carry = tmp / 10;
                sb.append(tmp % 10);
            }
            if(carry != 0) {
                sb.append(carry);
            }
            ans = add(ans, sb.reverse().toString());
        }
        return ans;
    }

    /**
     * 字符串加法
     *
     * @param s1 s1 字符串
     * @param s2 s2 字符串
     * @return String
     */
    static String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0) {
            int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1, s2));
        // 56088
    }
}
