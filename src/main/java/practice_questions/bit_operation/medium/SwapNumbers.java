package practice_questions.bit_operation.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: SwapNumbers
 * @Author: 丛虹羽
 * @Date: 2024/8/11 上午10:07
 * @Description: 交换数字
 *
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * leetcode: https://leetcode.cn/problems/swap-numbers-lcci
 */
public class SwapNumbers {

    /**
     * 交换数组中的两个数;
     * 知识点：0 ^ N = N、 N ^ N = 0
     *
     * @param numbers
     * @return
     */
    public static int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(Arrays.toString(swapNumbers(arr)));
        // [2, 1]
    }
}
