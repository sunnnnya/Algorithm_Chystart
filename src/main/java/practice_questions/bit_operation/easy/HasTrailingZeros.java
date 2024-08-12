package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: HasTrailingZeros
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午10:50
 * @Description: 检查按位或是否存在尾随零
 *
 * 给你一个 正整数 数组 nums 。
 * 你需要检查是否可以从数组中选出 两个或更多 元素，满足这些元素的按位或运算（ OR）结果的二进制表示中 至少 存在一个尾随零。
 *
 * 例如，数字 5 的二进制表示是 "101"，不存在尾随零，而数字 4 的二进制表示是 "100"，存在两个尾随零。
 *
 * 如果可以选择两个或更多元素，其按位或运算结果存在尾随零，返回 true；否则，返回 false 。
 *
 * leetcode：https://leetcode.cn/problems/check-if-bitwise-or-has-trailing-zeros
 */
public class HasTrailingZeros {

    /**
     * 使用 数组 + 位运算 进行状态转移
     * 思路：最后统计的arr[0]表示的是每个数对应的0bit位有多少是1的，arr的长度-0bit为1的个数，其他的就是0 bit位是0的个数，如果>=2就可以继续或出来0
     *
     * @param nums
     * @return
     */
    public static boolean hasTrailingZeros1(int[] nums) {
        int[] arr = new int[32];
        for (int number : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += (number >> i) & 1;
            }
        }
        return (nums.length - arr[0]) >= 2;
    }

    /**
     * 偶数必然可以或成0，奇数不行，直接最后统计个数
     * 小技巧：使用 N & 1 进行余数操作
     *      N & 1 == 1 说明 N 是奇数
     *      N & 1 == 0 说明 N 是偶数
     *
     * @param nums
     * @return
     */
    public static boolean hasTrailingZeros(int[] nums) {
        int len = nums.length;
        for (int number : nums) {
            len -= number & 1;
        }
        return len >= 2;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(hasTrailingZeros(arr));
        // true

        int[] arr1 = {2,4,8,16};
        System.out.println(hasTrailingZeros(arr1));
        // true

        int[] arr2 = {1,3,5,7,9};
        System.out.println(hasTrailingZeros(arr2));
        // false
    }
}
