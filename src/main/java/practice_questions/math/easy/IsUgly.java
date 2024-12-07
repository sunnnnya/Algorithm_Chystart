package practice_questions.math.easy;

/**
 * @BelongsPackage: practice_questions.math.easy
 * @ClassName: IsUgly
 * @Author: 丛虹羽
 * @Date: 2024/12/7 上午11:57
 * @Description: 丑数
 *      丑数就是只包含质因数 2、3 和 5 的 正整数。
 *
 *      给你一个整数 n，请你判断 n 是否为丑数 。如果是，返回 true ；否则，返回 false 。
 */
public class IsUgly {

    /**
     * 首先包含 3 的因子的数去掉、再去掉 5 的因子，然后如果是2 的幂次就是丑数
     *
     * @param n
     * @return
     */
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return (n & (n - 1)) == 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        // true

        System.out.println(isUgly(1));
        // true

        System.out.println(isUgly(14));
        // false
    }
}