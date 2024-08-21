package practice_questions.matrix_fast_power.medium;

/**
 * @BelongsPackage: practice_questions.matrix_fast_power.medium
 * @ClassName: NumTilings
 * @Author: 丛虹羽
 * @Date: 2024/8/21 下午8:24
 * @Description: 多米诺和托米诺平铺
 *
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
 *
 * leetcode：https://leetcode.cn/problems/domino-and-tromino-tiling
 */
public class NumTilings {

    /**
     * 暴力打标
     *
     * @param n
     * @return
     */
    public static void table(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("2 * " + i + " 的瓷砖总共有铺法: 有 " + process(i, 0) + " 种;");
        }
    }

    /**
     * 暴力递归
     *
     * @param n  表示宽度
     * @param m  是否单独多出来一块
     * @return
     */
    public static int process(int n, int m) {
        if (n == 0) {
            return m ^ 1;
            // return m == 0 ? 1 : 0;
        }
        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return process(n - 1, 1) + process(n - 1, 0);
        } else {
            return process(n - 1, 0) + 2 * process(n - 2, 1) + process(n - 2, 0);
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        table(9);
        // 2 * 1 的瓷砖总共有铺法: 有 1 种;
        // 2 * 2 的瓷砖总共有铺法: 有 2 种;
        // 2 * 3 的瓷砖总共有铺法: 有 5 种;
        // 2 * 4 的瓷砖总共有铺法: 有 11 种;
        // 2 * 5 的瓷砖总共有铺法: 有 24 种;
        // 2 * 6 的瓷砖总共有铺法: 有 53 种;
        // 2 * 7 的瓷砖总共有铺法: 有 117 种;
        // 2 * 8 的瓷砖总共有铺法: 有 258 种;
        // 2 * 9 的瓷砖总共有铺法: 有 569 种;
        // 总结：
        //      f(1) = 1
        //      f(2) = 2
        //      f(3) = 5
        //      f(4) = 11
        //      f(n) = 2 * f(n-1) + f(n-3)
    }
}
