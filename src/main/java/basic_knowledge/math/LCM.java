package basic_knowledge.math;

/**
 * @BelongsPackage: basic_knowledge.math
 * @ClassName: LCM
 * @Author: 丛虹羽
 * @Date: 2024/8/27 下午11:14
 * @Description: 最小公倍数
 */
public class LCM {

    /**
     * 最大公因数：欧几里得算法
     *
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 最小公倍数：利用最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    /**
     * 测试数据填充
     *
     * @param args
     */
    public static void main(String[] args) {
        long lcm = lcm(10, 7);
        System.out.println("lcm = " + lcm);
        // lcm = 70
    }
}
