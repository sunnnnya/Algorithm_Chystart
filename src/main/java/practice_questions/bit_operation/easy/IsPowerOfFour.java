package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: IsPowerOfFour
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午8:04
 * @Description: 4的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * leetcode：https://leetcode.cn/problems/power-of-four/description/
 */
public class IsPowerOfFour {

    /**
     * 在给定的数据范围内进行枚举
     * 1431655765 -> 1010101010101010101010101010101
     * 使用 n & (n - 1)来验证是不是2的幂次，一旦表示是2的幂次，说明二进制位中只有一个1
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0 && (n & 1431655765) == n;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        // true

        System.out.println(isPowerOfFour(5));
        // false

        System.out.println(isPowerOfFour(1));
        // true
    }
}
