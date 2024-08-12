package practice_questions.bit_operation.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: SingleNumber
 * @Author: 丛虹羽
 * @Date: 2024/8/12 上午10:51
 * @Description: 只出现一次的数字 III
 *
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * leetcode: https://leetcode.cn/problems/single-number-iii
 */
public class SingleNumberIII {

    /**
     * 出现
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int number : nums) {
            eor ^= number;
        }
        int xor = 0;
        for (int number : nums) {
            if ((number & (eor & (~eor + 1))) == 0) {
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
        int[] arr = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(arr)));
        // [5, 3]

        int[] arr2 = {-1,0};
        System.out.println(Arrays.toString(singleNumber(arr2)));
        // [0, -1]

        int[] arr3 = {0, 1};
        System.out.println(Arrays.toString(singleNumber(arr3)));
        // [0, 1]
    }
}
