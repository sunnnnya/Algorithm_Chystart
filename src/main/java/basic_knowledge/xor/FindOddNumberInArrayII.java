package basic_knowledge.xor;

import java.util.Arrays;

/**
 * @BelongsPackage: basic_knowledge.xor
 * @ClassName: FindOddNumberInArrayII
 * @Author: 丛虹羽
 * @Date: 2024/12/2 上午11:42
 * @Description: 数组中只有 "两个" 出现奇数次的数,且这两个数不相同，其他的所有数都出现了偶数次，找到这两个数！！
 */
public class FindOddNumberInArrayII {

    /**
     * 组中只有 "两个" 出现奇数次的数，其他的所有数都出现了偶数次，找到这两个数！！
     * 知识点：使用异或 N ^ N = 0、0 ^ N = N
     *
     * 想法：使用 eor 一直异或到底，因为 a != b 所有最后的 eor = a ^ b 一定不等 0 ，
     * 故所以肯定在 a、b上面有一个二进制位不相同，所以对整个数组中的元素针对某一位为1的数，进行异或就会拿到 a 或者 b
     *
     * @return
     */
    public static int[] findOddNumberInArrayII(int[] arr) {
        int eor = 0;
        for (int number : arr) {
            eor ^= number;
        }
        int xor = 0;
        // eor = a ^ b;
        // a != b
        // eor != 0 -> 某一个二进制位上面必然为 x x 0 0 0 1 0 0 1 0 0 x x x
        // eor & (~eor + 1) -> 提取出最右侧为 1 -> 0 0 0 0 0 0 1 0 0
        // (~eor + 1) -> 表示为 eor 的相反数
        for (int number : arr) {
            if ((number & (eor & ~eor + 1)) == 0) {
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
        int[] arr = {2, 2, 2, 2, 1, 4, 2, 4, 1, 1, 5, 5, 6, 6, 7, 7};
        System.out.println("两个出现奇数次的数是：" + Arrays.toString(findOddNumberInArrayII(arr)));

        // 相反数测试
        int number = 3;
        int negNumber = ~number + 1;
        System.out.println("negNumber = " + negNumber);
        // negNumber = -3

        int number1 = -2;
        int negNumber1 = ~number1 + 1;
        System.out.println("negNumber1 = " + negNumber1);
        // negNumber1 = 2
    }
}