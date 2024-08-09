package basic_knowledge.bit_operations.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.bit_operations.easy
 * @ClassName: Basics
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午7:35
 * @Description: 位运算的基础知识
 *  基础知识：
 *      （1）N & (N - 1)：消除 N的二进制表示中最后的一个1bit位
 *      （2）N & (~N + 1)：获取 N的二进制表示中最后一个1bit为
 *      （3）异或^：相同为 1 ，不同为 0
 *          【1】N ^ N = 0
 *          【2】0 ^ N = N
 *      （4）与&：有假为假，全真为真
 *          【1】0 & 1 = 0
 *          【2】1 & 1 = 1
 *      （5）或|：有真为真，全假为假
 *          【1】0 | 1 = 1
 *          【2】0 | 0 = 0
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
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 技巧1：数组进位信息取反
        int[] arr = new int[]{1, 0, 1, 1, 0, 0, 1, 1};
        exchangeElement(arr);
        System.out.println(Arrays.toString(arr));
        // [0, 1, 0, 0, 1, 1, 0, 0]

        // 技巧2：使用N &= (N - 1)获取十进制数中有多少个为1的bit位
        int result = getBitCount(5);
        System.out.println("result = " + result);
        // result = 2

        int result2 = getBitCount(128);
        System.out.println("result2 = " + result2);
        // result2 = 1
    }
}
