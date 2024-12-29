package basic_knowledge.dynamic_program.two_dimensional;

/**
 * @package: basic_knowledge.dynamic_program.two_dimensional
 * @author: chystart
 * @create: 2024-12-29 12:00
 * @description: 转化数字字符串
 *
 * 规定 1 和 A 对应、2 和 B 对应、3 和 C 对应 ... 26 和 Z 对应
 *      那么一个数字字符串比如 "111" 可以转化为 "AAA"、"KA" 和 "AK"
 *      给定一个只有数字字符组成的字符串 str，返回有多少种转化结果？？
 **/
public class ConvertToLetterString {

    /**
     * 暴力递归
     *      表示从 i 到 str.length() - 1 有多少种返回策略？
     *
     * @param str 数字字符串
     * @return
     */
    public static int number1(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        return process1(str.toCharArray(), 0);
    }

    /**
     * 暴力递归函数，返回方法数
     *
     * @param c 字符数组
     * @param i 字符数组索引位置
     * @return
     */
    public static int process1(char[] c, int i) {
        // 字符串结束的时候能正常转换
        if(i == c.length) {
            return 1;
        }
        if(c[i] == '0') {
            return 0;
        }
        // 字符单独转
        int ways = process1(c, i + 1);
        // 字符不越界，且两个字符凑出来一种方法
        if(i < c.length - 1 && ((c[i] - '0') * 10 + (c[i + 1] - '0')) <= 26) {
            ways += process1(c, i + 2);
        }
        return ways;
    }

    /**
     * 动态规划
     *      从右到左的尝试模型
     *
     * @param str 数字字符串
     * @return
     */
    public static int number(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        char[] c = str.toCharArray();
        int N = c.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for(int j = N - 1; j >= 0; j--) {
            if(c[j] != '0') {
                dp[j] = dp[j + 1];
                if(j < c.length - 1 && ((c[j] - '0') * 10 + (c[j + 1] - '0')) <= 26) {
                    dp[j] += dp[j + 2];
                }
            }
        }
        return dp[0];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 测试用例1: "111" -> "AAA", "KA", "AK" (3种方法)
        System.out.println("Test case 1: '111'");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + number("111"));
        System.out.println();

        // 测试用例2: "12" -> "AB", "L" (2种方法)
        System.out.println("Test case 2: '12'");
        System.out.println("Expected: 2");
        System.out.println("Actual: " + number("12"));
        System.out.println();

        // 测试用例3: "226" -> "BBF", "VF", "BZ" (3种方法)
        System.out.println("Test case 3: '226'");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + number("226"));
        System.out.println();

        // 测试用例4: "06" -> (0种方法，因为以0开头)
        System.out.println("Test case 4: '06'");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + number("06"));
        System.out.println();

        // 测试用例5: "" -> (空字符串测试)
        System.out.println("Test case 5: ''");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + number(""));
        System.out.println();

        // 测试用例5: "" -> (空字符串测试)
        System.out.println("Test case 5: '7210231231232031203123'");
        System.out.println("Expected: 54");
        System.out.println("Actual: " + number("7210231231232031203123"));
        System.out.println();
    }
}