package basic_knowledge.bit_operations.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.bit_operations.easy
 * @ClassName: Basics
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午7:35
 * @Description: 位运算的基础知识
 *
 *  （1）N & (N - 1)：消除 N的二进制表示中最后的一个 1 bit 位
 *
 *  （2）N & (~N + 1)：获取 N的二进制表示中最后一个 1 bit 位
 *
 *  （3）异或 ^：相同为 0 ，不同为 1
 *      · N ^ N = 0
 *      · 0 ^ N = N
 *
 *  （4）与 &：有假为假，全真为真
 *      · 0 & 1 = 0
 *      · 1 & 1 = 1
 *
 *  （5）或 |：有真为真，全假为假
 *      · 0 | 1 = 1
 *      · 0 | 0 = 0
 *
 *  （6）使用二进制进行状态压缩：
 *      集合可以用二进制表示，二进制从低到高第i位为 1 表示 i 在集合中，为 0 表示 i 不在集合中;
 *      例如：集合 {0,2,3} 可以用二进制数 1101 表示; 反过来，二进制数 1101就对应着集合{0,2,3}；
 *      总结：例如集合 {0,2,3} 可以压缩成 2^0 + 2^2 +2^3= 13，也就是二进制数 1101；
 *      【1】对应四种题型：
 *          集合与集合
 *          集合与元素
 *          遍历集合
 *          枚举集合
 *      总结：https://leetcode.cn/circle/discuss/CaOJ45/
 */
public class Basics {

    /**
     * 异或操作
     *
     * @param arr
     */
    private static void exchangeElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 1;
            // 0 ^ 1 = 1;
            // 1 ^ 1 = 0;
        }
    }

    /**
     * N &= (N  - 1)的使用
     *
     * @param number
     * @return
     */
    private static int getBitCount(int number) {
        int sum = 0;
        while (number != 0) {
            number &= (number - 1);
            ++sum;
        }
        return sum;
    }

    /**
     * 有一个数出现了 1 次，其他的出现了 3 次，找到出现了 1 次的数
     *
     * @param arr
     * @return
     */
    private static int getSingleNumber(int[] arr) {
        int[] init = new int[32];
        for (int number : arr) {
            for (int i = 0; i < 32; i++) {
                init[i] += (number >> i) & 1;
            }
        }
        int result = 0;
        for(int i = 0; i < init.length; i++) {
            if (init[i] % 3 != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }

    /**
     * 打印十进制数的二进制信息
     *
     * @param number
     */
    public static void printObNumber(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((number >> i) & 1) > 0 ? '1' : '0');
        }
        System.out.println();
    }

    /**
     * 刷新后面的 bit 位
     *
     * @param number
     * @return
     */
    public static int fillZero(int number, int bits) {
        printObNumber(number);
        number >>= bits;
        number <<= bits;
        printObNumber(number);
        return number;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=============技巧1：数组进位信息取反============");
        int[] arr = new int[]{1, 0, 1, 1, 0, 0, 1, 1};
        exchangeElement(arr);
        System.out.println(Arrays.toString(arr));
        // [0, 1, 0, 0, 1, 1, 0, 0]

        System.out.println();
        System.out.println("=================技巧2：使用N &= (N - 1)获取十进制数中有多少个为1的bit位============");
        int result = getBitCount(5);
        System.out.println("result = " + result);
        // result = 2

        int result2 = getBitCount(128);
        System.out.println("result2 = " + result2);
        // result2 = 1

        System.out.println();
        System.out.println("===========技巧3【状态压缩】：有一个数出现了1次，其他的出现了3次，找到出现了1次的数=============");
        int[] ans = new int[]{1, 1, 1, 3, 4, 4, 4, 9, 3, 3};
        System.out.println(getSingleNumber(ans));
        // 9

        System.out.println();
        System.out.println("====================技巧4：打印十进制的二进制信息=========================");
        printObNumber(243);
        // 00000000000000000000000011110011

        System.out.println();
        System.out.println("======================技巧5：后置位状态刷0==================");
        System.out.println(fillZero(243, 6));
        // 00000000000000000000000011110011
        // 00000000000000000000000011000000
        // 192
    }
}
