package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: NumberOfSteps
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午8:33
 * @Description: 将数字变成 0 的操作次数
 *
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 *
 * leetcode：https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class NumberOfSteps {

    /**
     * 简单的循环的使用
     *
     * @param num
     * @return
     */
    public static int numberOfSteps(int num) {
        int sum = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }
            ++sum;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        // 6

        System.out.println(numberOfSteps(8));
        // 4
    }
}
