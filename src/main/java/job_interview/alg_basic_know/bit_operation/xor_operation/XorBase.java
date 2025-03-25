package job_interview.alg_basic_know.bit_operation.xor_operation;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.bit_operation.xor
 * @ClassName: SwapTwoNumberInArray
 * @Author: 丛虹羽
 * @Date: 2025/3/25 09:37
 * @Description: 异或运算基本操作
 *  相同为 0、不同为 1
 * 0 ^ N = N、N ^ N = 0
 */
public class XorBase {

    /**
     * 交换两个数
     *  约束：i != j
     *
     * @param arr 原始数组
     * @param i   i index
     * @param j   j index
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("使用异或进行交换：");
        int[] arr = new int[]{19, 2, 1, 3, 1, 2, 4,};
        swap(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        // 使用异或进行交换：[4, 2, 1, 3, 1, 2, 19]


    }
}
