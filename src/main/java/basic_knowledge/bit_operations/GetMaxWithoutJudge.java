package basic_knowledge.bit_operations;

/**
 * @BelongsPackage: basic_knowledge.bit_operations
 * @ClassName: GetMaxWithoutJudge
 * @Author: 丛虹羽
 * @Date: 2024/12/21 下午10:44
 * @Description: 不使用条件判断返回两个数的最大值
 */
public class GetMaxWithoutJudge {

    /**
     * 1 -> 0
     * 0 -> 1
     *
     * @param n 原始数据
     * @return
     */
    private static int flip(int n) {
        return n ^ 1;
    }

    /**
     * 获取符号位，正数 -> 1、负数 -> 0
     *
     * @param n
     * @return
     */
    private static int sign(int n) {
        // 不带符号右移
        return flip(n >>> 31);
    }

    /**
     * 不适用比较的方法返回两个数的最大值
     *
     * @param a 数值 a
     * @param b 数值 b
     * @return
     */
    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        // 判断 a 和 b 的符号是否相同，相同 -> 0，不同 -> 1
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);
        // 构成返回 a 的条件
        // a 和 b 的符号不同，并且 a 是正数，返回 a
        // a 和 b 的符号相同，并且 c 是正数，返回 a
        int returnA = diffAB * sa + sameAB * sc;
        int returnB= flip(returnA);
        return a * returnA + b * returnB;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getMax(10, 20));
        // 20

        System.out.println(getMax(-5, -2));
        // -2
    }
}
