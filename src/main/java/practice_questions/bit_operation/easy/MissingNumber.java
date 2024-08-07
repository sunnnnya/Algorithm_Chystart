package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: MissingNumber
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午4:18
 * @Description: 消失的数字
 *
 * leetcode: https://leetcode.cn/problems/missing-number-lcci/description/
 *
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 */
public class MissingNumber {

    /**
     * 知识点：0 ^ N = N、 N ^ N = 0
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int eor = 0;
        for(int i = 0; i < nums.length; i++) {
            eor ^= (i ^ nums[i]);
        }
        return eor ^ nums.length;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr));
        // 8

        int[] arr1 = new int[]{3, 0, 1};
        System.out.println(missingNumber(arr1));
        // 2
    }
}
