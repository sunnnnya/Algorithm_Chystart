package basic_knowledge.math;

/**
 * @BelongsPackage: basic_knowledge.math
 * @ClassName: GCD
 * @Author: 丛虹羽
 * @Date: 2024/8/27 下午11:09
 * @Description: 最大公约数的使用 欧几里得算法
 */
public class GCD {

    /**
     * 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        long gcd = gcd(50, 30);
        System.out.println("gcd = " + gcd);
        // gcd = 10
    }
}
