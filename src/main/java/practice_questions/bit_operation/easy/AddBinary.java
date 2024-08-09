package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: AddBinary
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午1:26
 * @Description: 二进制求和
 *
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * leetcode：https://leetcode.cn/problems/JFETK5/description/
 */
public class AddBinary {

    /**
     * 把两个整数对应的二进制进行求和运算，然后再转换为二进制字符串进行输出
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    /**
     * 一个二进制格式的字符串 -> 十进制数字
     *
     * @param a
     * @return
     */
    public static int parseInteger(String a) {
        int N = a.length() - 1;
        int res = 0;
        for (int len = N; len >= 0; len--) {
            res |= Integer.parseInt(a.charAt(len) + "") << N - len;
        }
        return res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=================测试二进制字符串转化为十进制数字=====================");
        String str = "101";
        System.out.println(parseInteger(str));
        // 5

        String str1 = "1101";
        System.out.println(parseInteger(str1));
        // 13

        String str2 = "000";
        System.out.println(parseInteger(str2));
        // 0

        System.out.println("=======================测试结果=====================");
        String s1 = "11";
        String s2 = "10";
        System.out.println(addBinary(s1, s2));
        // 101

        String s3 = "1010";
        String s4 = "1011";
        System.out.println(addBinary(s3, s4));
        // 10101
    }
}
