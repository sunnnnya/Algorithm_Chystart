package practice_questions.bit_operation.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: SumIndicesWithKSetBits
 * @Author: 丛虹羽
 * @Date: 2024/8/13 下午3:52
 * @Description: 计算 K 置位下标对应元素的和
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 *
 * leetcode：https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits
 */
public class SumIndicesWithKSetBits {

    /**
     * 返回 k 置位信息之和
     *
     * @param nums
     * @param k
     * @return
     */
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (process(i, k)) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    /**
     * 一个数包含多少个1bit，如果包含k个的话，就返回当前值，反之返回0
     *
     * @param number
     * @param k
     * @return
     */
    public static boolean process(int number, int k) {
        int sum = 0;
        while (number != 0) {
            number &= (number - 1);
            ++sum;
        }
        return sum == k;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("测试 1 中是否含有 2 个置位: ");
        System.out.println(process(1, 2));
        // false

        System.out.print("测试 3 中是否含有 2 个置位: ");
        System.out.println(process(3, 2));
        // true

        System.out.print("测试 7 中是否含有 3 个置位: ");
        System.out.println(process(7, 3));
        // true

        System.out.print("测试 0 中是否含有 0 个置位: ");
        System.out.println(process(0, 3));
        // false

        System.out.print("测试 0 中是否含有 0 个置位: ");
        System.out.println(process(0, 0));
        // true

        System.out.println("数据测试：");
        List<Integer> list = Arrays.asList(4, 3, 2, 1);
        System.out.println(sumIndicesWithKSetBits(list, 2));
        // 1

        List<Integer> list1 = Arrays.asList(5, 10, 1, 5, 2);
        System.out.println(sumIndicesWithKSetBits(list1, 1));
        // 13
    }
}
