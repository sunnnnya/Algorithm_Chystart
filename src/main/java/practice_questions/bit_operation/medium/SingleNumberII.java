package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: SingleNumberII
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午3:34
 * @Description: 只出现一次的数字 II
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * leetcode：https://leetcode.cn/problems/single-number-ii
 */
public class SingleNumberII {

    /**
     * 找到出现1次的数字,
     * 使用状态压缩的方式记录，对二进制数对应数组种的下标
     * 14 -> [0, 1, 1, 1, 0, ...]
     * index  0  1  2  3  4 表示：表示第index位的值对应二进制种是 0 还是 1
     * 14 -> 1110
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int number : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += ((number >> i) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] % 3 != 0) {
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
        int[] arr = {2,2,3,2};
        System.out.println(singleNumber(arr));
        // 3

        int[] arr1 = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(arr1));
        // 99
    }
}
