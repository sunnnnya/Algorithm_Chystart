package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: IsPowerOfTwo
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午9:58
 * @Description: 2 的幂
 *
 * leetcode：https://leetcode.cn/problems/power-of-two/description/
 *
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class IsPowerOfTwo {

    /**
     * 证明：2的x次幂等于 n <=> 31 bit位中只有一个1（抛去符号位，会出现负数的情况）
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        // 直接过滤，2 的 x次幂是不可能出现负数的
        if(n < 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                sum++;
            }
        }
        return sum == 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        // true
        System.out.println(isPowerOfTwo(16));
        // true
        System.out.println(isPowerOfTwo(3));
        // false
        System.out.println(isPowerOfTwo(0));
        // false
        System.out.println(isPowerOfTwo(-5));
        // false
    }
}
