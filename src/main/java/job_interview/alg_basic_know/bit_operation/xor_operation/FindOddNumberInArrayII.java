package job_interview.alg_basic_know.bit_operation.xor_operation;

import java.util.Arrays;

/**
 * @BelongsPackage: job_interview.alg_basic_know.bit_operation.xor_operation
 * @ClassName: FindOddNumberInArrayII
 * @Author: 丛虹羽
 * @Date: 2025/3/25 10:34
 * @Description: 找到数组中出现奇数次的两个数
 */
public class FindOddNumberInArrayII {

    /**
     * 知识点：使用异或 N ^ N = 0、0 ^ N = N
     *   思路：（1）使用 eor 一直异或到底，因为 a != b 所有最后的 eor = a ^ b 一定不等 0。
     *        （2）拿到 eor 最右侧的 1，进行分组异或，就会获取到出现奇数次的一个数，最后 eor ^ xor 拿到另一个数。
     * @return
     */
    public static int[] findOddNumberInArrayII(int[] arr) {
        int eor = 0;
        for (int number : arr) {
            eor ^= number;
        }
        int xor = 0;
        for (int number : arr) {
            if ((number & (eor & ~eor + 1)) == 0) { // eor & (~eor + 1): 获取二进制位最后的 1
                xor ^= number;
            }
        }
        return new int[]{xor, eor ^ xor};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 3, 3, 1};
        System.out.println(Arrays.toString(findOddNumberInArrayII(arr)));
        // [2, 1]
    }
}
