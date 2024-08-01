package basic_knowledge.xor;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.xor
 * @ClassName: AddWithoutCarry
 * @Author: 丛虹羽
 * @Date: 2024/7/24 下午11:36
 * @Description: 异或运算 -> 无进位相加 1 ^ 1 = 0、1 ^ 0 = 1
 */
public class AddWithoutCarry {

    /**
     * 使用异或运算的性质完成数据交换,
     * 前提，交换的值再内存中是两个独立的区域，否则就会被抹成 0
     * 0 ^ N = N      N ^ N = 0
     *
     * @param arr 数组
     * @param i   i下标   ->   i不等于j
     * @param j   j下标   ->   i不等于j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 不引入额外变量交换数
     *
     * @param a
     * @param b
     */
    public static void swapTwoNumberWithOpearion(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 5, 6};
        swap(arr, 1, 2);
        System.out.println(Arrays.toString(arr));
        // [10, 3, 2, 5, 6]

        swapTwoNumberWithOpearion(12, 21);
    }
}
