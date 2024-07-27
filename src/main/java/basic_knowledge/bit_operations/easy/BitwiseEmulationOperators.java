package basic_knowledge.bit_operations.easy;

/**
 * @BelongsPackage: basic_knowledge.bit_operations.easy
 * @ClassName: BitwiseEmulationOperators
 * @Author: 丛虹羽
 * @Date: 2024/7/27 下午6:01
 * @Description: 使用位运算模拟加减乘除
 * 异或 ^ ：无进位相加 的信息
 * 与   & ：左移1位之后就是 进位信息
 * leetcode: https://leetcode.cn/problems/divide-two-integers/description/
 */
public class BitwiseEmulationOperators {

    /**
     * 使用位运算替换操作符 +
     * 原理：a ^ b表示的是无进位相加
     *      (a & b) << 1 表示的是进位信息
     * a = 7、 b = 15
     * a = 0 1 1 1
     * b = 1 1 1 1
     * ------------
     * a ^ b = 1 0 0 0 (1)
     * a & b = 0 1 1 1 (2)
     * (a & b << 1) = 1 1 1 0 (3)
     *
     * (1) ^ (3) = 0 1 1 0 (3)
     * (1) & (3) = 1 0 0 0 (4)
     * (1) & (3) << 1 = 1 0 0 0 0 (5)
     *
     * (3) ^ (5) = 1 0 1 1 0
     * (3) & (5) = 0 0 0 0 0
     * (3) & (5) << 1 = 0 0 0 0 0 0 -> 终止
     * return (3) ^ (5): 1 0 1 1 0 = 22
     *
     * 已经进行循环直到 进位信息 为 0 时停止
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 减法操作
     *
     * @param a
     * @param b
     * @return
     */
    public static int sub(int a, int b) {
        // a + b <=> a + (-b)
        return add(a, numNeg(b));
    }

    /**
     * 乘法操作
     * a = 14, b = 6
     * a = 1 1 1 0
     * b = 0 1 1 0
     * b & 1  = 0 -> ans 不加 a <<= 1 : 1 1 1 0 0， b >>>= 1 ：0 0 1 1
     * b & 1 != 0 -> ans +=   1 1 1 0 0， a <<= 1: 1 1 1 0 0 0， b >>= 1 : 0 0 0 1
     * b & 1 != 0 -> ans += 1 1 1 0 0 0， a << = 1: 1 1 1 0 0 0 0，b >> = 1 : 0 0 0 0 -> 终止
     * return： 1 1 1 0 0 0
     *      +   0 1 1 1 0 0
     *      = 1 0 1 0 1 0 0
     *      = 84
     */
    public static int mult(int a, int b) {
        int ans = 0;
        if (a == 0 || b == 0) {
            return ans;
        } else {
            while (b != 0) {
                if ((b & 1) != 0) {
                    ans = add(ans, a);
                }
                a <<= 1;
                b >>>= 1;
                // b >>= 1， 符号位来补
                // b >>>= 1，0来补
            }
        }
        return ans;
    }

    public static int div(int a, int b) {
        // 保证 x 和 y 都是正数
        int x = isNeg(a) ? numNeg(a) : a;
        int y = isNeg(b) ? numNeg(b) : b;
        // 结果
        int res = 0;
        for (int i = 30; i >= 0; i = subb(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i); // 结果进行记录
                x = subb(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? numNeg(res) : res;
    }

    /**
     * 返回 i = i - 1 的结果
     *
     * @param i
     * @param i1
     * @return
     */
    private static int subb(int i, int i1) {
        return sub(i, i1);
    }

    /**
     * 求一个数的相反数
     *
     * @param b
     * @return
     */
    public static int numNeg(int b) {
        // b的相反数 = ~b + 1
        return add(~b, 1);
    }

    /**
     * 判断一个数是不是负数
     *
     * @param number
     * @return
     */
    public static boolean isNeg(int number) {
        return number < 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int result = add(12, 21);
        System.out.println("result = " + result);
        // result = 33
        int sub = sub(-1, -2);
        System.out.println("sub = " + sub);
        // sub = 1
        int mult = mult(17, 0);
        System.out.println("mult = " + mult);
        // mult = 0
        int mult1 = mult(18, 8);
        System.out.println("mult1 = " + mult1);
        // mult = 144
        int div = div(12, 4);
        System.out.println("div = " + div);
    }
}
