package job_interview.code_top.string.string_simulation;

/**
 * @BelongsPackage: job_interview.code_top.string.string_simulation
 * @ClassName: MyAtoi
 * @Author: 丛虹羽
 * @Date: 2025/5/12 15:17
 * @Description: 字符串转换整数 (atoi)
 * https://leetcode.cn/problems/string-to-integer-atoi/description/
 */
public class MyAtoi {

    /**
     * 字符串模拟
     *  注意：
     *      Integer.MAX_VALUE = 2147483647
     *      Integer.MIN_VALUE = -2147483648
     *
     * @param s 字符串
     * @return int
     */
    static int myAtoi(String s) {
        char[] c = s.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, sign = 1, sIdx = 1;
        int bound = Integer.MAX_VALUE / 10;
        if(c[0] == '-') sign = -1;
        else if (c[0] != '+') sIdx = 0;
        for(int j = sIdx; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bound || (res == bound && c[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = (res * 10) + c[j] - '0';
        }
        return sign * res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(myAtoi("1337c0d3"));
        // 1337
    }
}
