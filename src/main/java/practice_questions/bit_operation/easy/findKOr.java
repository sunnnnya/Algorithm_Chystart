package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: findKOr
 * @Author: 丛虹羽
 * @Date: 2024/8/13 下午7:29
 * @Description: 找出数组中的 K-or 值
 *
 * 给你一个整数数组 nums 和一个整数 k 。让我们通过扩展标准的按位或来介绍 K-or 操作。在 K-or 操作中，如果在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值是 1 。
 * 返回 nums 的 K-or 值。
 *
 * leetcode:https://leetcode.cn/problems/find-the-k-or-of-an-array
 */
public class findKOr {

    /**
     * 使用 数组 + 位运算 进行状态压缩
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKOr(int[] nums, int k) {
        int[] arr = new int[32];
        for (int number : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += (number >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] >= k) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{7,12,9,8,9,15};
        System.out.println(findKOr(arr, 4));
        // 9

        int[] arr1 = new int[]{2,12,1,11,4,5};
        System.out.println(findKOr(arr1, 6));
        // 0

        int[] arr2 = new int[]{10,8,5,9,11,6,8};
        System.out.println(findKOr(arr2, 1));
        // 15
    }
}
