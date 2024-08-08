package practice_questions.bit_operation.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: CountBits
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午4:08
 * @Description: 比特位计数
 *
 * leetcode：https://leetcode.cn/problems/counting-bits/description/
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class CountBits {

    /**
     * 使用数组的方式返回计算之后的数组
     *
     * @param n
     * @return
     */
    public static int[] countBits1(int n) {
        int index = 0;
        int[] ans = new int[n + 1];
        while (index <= n) {
            ans[index] = bitCount(index++);
        }
        return ans;
    }

    /**
     * n & (n - 1)：会消除掉n的最右一位二进制位
     * n & (~n + 1)：会拿到n的最后一位二进制位
     *
     * 比较笨的方式可以使用，左移或者右移进行统计
     *
     * @param number
     * @return
     */
    public static int bitCount(int number) {
        int sum = 0;
        while (number != 0) {
            number &= (number - 1);
            sum++;
        }
        return sum;
    }

    /**
     * 性能优化，直接使用for
     *
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i, sum = 0; j > 0; j = j & (j - 1)) {
                arr[i] = ++sum;
            }
        }
        return arr;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        // [0, 1, 1]

        System.out.println(Arrays.toString(countBits(5)));
        // [0, 1, 1, 2, 1, 2]
    }
}
