package practice_questions.bit_operation.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: EvenOddBit
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午11:05
 * @Description: 奇偶位数
 *
 * leetcode: https://leetcode.cn/problems/number-of-even-and-odd-bits/
 *
 * 给你一个 正 整数 n 。
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 */
public class EvenOddBit {

    /**
     * 参考数据量 1 <= n <= 1000 故 n 最多 10 bit
     * 故设计一个模板为 0101010101 -> 341
     *
     * @param n
     * @return
     */
    public static int[] evenOddBit(int n) {
        int even = n & 341;
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            ++sum;
        }
        int sum1 = 0;
        while (even != 0) {
            even = even & (even - 1);
            ++sum1;
        }
        return new int[]{sum1, sum - sum1};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(17)));
        // [2, 0]

        System.out.println(Arrays.toString(evenOddBit(2)));
        // [0, 1]

        System.out.println(Arrays.toString(evenOddBit(1)));
        // [1, 0]

        System.out.println(Arrays.toString(evenOddBit(50)));
        // [1, 0]
    }
}
