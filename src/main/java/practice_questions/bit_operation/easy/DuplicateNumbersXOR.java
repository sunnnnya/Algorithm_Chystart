package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: DuplicateNumbersXOR
 * @Author: 丛虹羽
 * @Date: 2024/8/8 下午2:22
 * @Description: 求出出现两次数字的 XOR 值
 *
 * leetcode：https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice
 *
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 */
public class DuplicateNumbersXOR {

    /**
     * 使用计数排序的技巧，然后进行异或累计
     *
     * @param nums
     * @return
     */
    public static int duplicateNumbersXOR1(int[] nums) {
        int[] ans = new int[51];
        for (int i = 0; i < nums.length; i++) {
            ans[nums[i]]++;
        }
        int eor = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 2) {
                eor ^= i;
            }
        }
        return eor;
    }

    /**
     * 由于1 <= nums[1] <= 50 故使用一个long类型的整数就可以处理
     *
     * @param nums
     * @return
     */
    public static int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        long vis = 0;
        for (int number : nums) {
            // 如果当前的结果出现了>0的情况，证明此值以前出现过，参加异或
            if (((vis >> number) & 1) > 0) {
                ans ^= number;
            } else {
                // number: 表示需要移动多少位
                vis |= 1L << number;
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
        int[] arr = new int[]{1, 2, 2, 1};
        System.out.println(duplicateNumbersXOR(arr));
        // 3

        int[] arr1 = new int[]{1, 2, 3};
        System.out.println(duplicateNumbersXOR(arr1));
        // 0

        int[] arr2 = new int[]{1, 2, 1, 3};
        System.out.println(duplicateNumbersXOR(arr2));
        // 1
    }
}
