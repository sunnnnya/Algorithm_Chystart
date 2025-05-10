package job_interview.code_top.string.string_simulation;

/**
 * @BelongsPackage: job_interview.code_top.string.string_simulation
 * @ClassName: AddStrings
 * @Author: 丛虹羽
 * @Date: 2025/5/10 23:52
 * @Description: 字符串相加
 * https://leetcode.cn/problems/add-strings/description/
 */
public class AddStrings {

    /**
     * 字符串模拟乘法
     *
     * @param num1 字符串 1
     * @param num2 字符串 2
     * @return String
     */
    static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int number = n1 + n2 + carry;
            carry = number / 10;
            sb.append(number % 10);
            i--;
            j--;
        }
        if(carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "11";
        System.out.println(addStrings(s1, s2));
        // 134

        String s11 = "999";
        String s22 = "1";
        System.out.println(addStrings(s11, s22));
        // 1000
    }
}
