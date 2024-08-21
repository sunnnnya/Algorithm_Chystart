package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: Maximum
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午10:51
 * @Description: 最大数值
 *
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * leetcode：https://leetcode.cn/problems/maximum-lcci
 */
public class Maximum {

    /**
     * 返回一个两个数种的最大值
     *
     * @param a
     * @param b
     * @return
     */
    public static int maximum(int a, int b) {
        // c 可能是溢出的
        int c = a - b;
        // 各个数值对应的符号，表示正数还是负数
        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);
        // 判断 a 和 b 的符号是不是一样的，一样返回 0，不一样返回 1
        int diffAB = signA ^ signB;
        // 判断 a 和 b 的符号是不是一样的，一样返回 1，不一样返回 0
        int sameAB  = diffAB ^ 1;
        // 当 a 和 b 的符号不相等时，且 signA 非负（1）时候 a大，或 a 和 b 的符号相等时， 且 signC 非负（1）时候a大
        int resultA = diffAB * signA + sameAB * signC;
        // 相反 b 大
        int resultB = resultA ^ 1;
        // a 大返回 a、 b 大 返回 b
        return a * resultA + b * resultB;
    }

    /**
     * 整数返回 1， 负数返回 0
     *
     * @param n
     * @return
     */
    public static int sign(int n) {
        return (n >>> 31) ^ 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maximum(5, 2));
        // 5
    }
}
