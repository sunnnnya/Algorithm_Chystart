package practice_questions.bit_operation.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: Decode
 * @Author: 丛虹羽
 * @Date: 2024/8/8 下午11:03
 * @Description: 解码异或后的数组
 *
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * leetcode： https://leetcode.cn/problems/decode-xored-array/description/
 */
public class Decode {

    /**
     * 强化按位异或操作
     *
     * @param encoded
     * @param first
     * @return
     */
    public static int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int first = 1;
        System.out.println(Arrays.toString(decode(arr, first)));
        // [1, 0, 2, 1]

        int[] arr1 = new int[]{6, 2, 7, 3};
        int second = 4;
        System.out.println(Arrays.toString(decode(arr1, second)));
        // [4, 2, 0, 7, 4]
    }
}
