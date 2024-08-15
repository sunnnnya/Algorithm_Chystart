package practice_questions.bit_operation.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: FindArray
 * @Author: 丛虹羽
 * @Date: 2024/8/15 上午10:24
 * @Description: 找出前缀异或的原始数组
 *
 * leetcode：https://leetcode.cn/problems/find-the-original-array-of-prefix-xor
 */
public class FindArray {

    /**
     * 异或的简单使用
     *
     * @param pref
     * @return
     */
    public static int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 0, 3, 1};
        System.out.println(Arrays.toString(findArray(arr)));
        // [5, 7, 2, 3, 2]
    }
}
