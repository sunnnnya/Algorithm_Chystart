package practice_questions.bit_operation.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: FindErrorNums
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午9:25
 * @Description: 错误的集合 <=> 利用数组的下标对出现不同的数进行异或然后区分重复和不重复
 *
 * leetcode：https://leetcode.cn/problems/set-mismatch/description/
 *
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 */
public class FindErrorNums {

    /**
     * 知识点： 查找数组中出现两个只出现一次的值
     * n & (n - 1)：去除一个二进制位的最后一位1
     * n & (~n + 1)：获取一个二进制位的最后一位1
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        // 对数组进行，扩容处理
        int N = nums.length;
        int[] arr = new int[2 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = nums[i];
            arr[i + N] = i + 1;
        }
        int eor = 0;
        for (int number : arr) {
            eor ^= number;
        }
        int xor = 0; // 出现重复的值 或 缺失的值
        for (int number : arr) {
            if ((number & (eor & (~eor + 1))) == 0) {
                xor ^= number;
            }
        }
        // 本题拓展：先确定重复的值，如果在 原数组 中出现了就为重复的值，反之就为缺失的值
        for (int number : nums) {
            if (number == xor) {
                return new int[]{xor, xor ^ eor}; // xor 的值是重复的值,命中直接返回
            }
        }
        return new int[]{xor ^ eor, xor}; // xor 不是重复的值，直接返回异或后的值是重复值
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
        // 2 3

        int[] arr1 = new int[]{1, 1};
        System.out.println(Arrays.toString(findErrorNums(arr1)));
        // 1 2
    }
}
