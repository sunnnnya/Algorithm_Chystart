package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: Add
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午4:31
 * @Description: 不用加号的加法
 *
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符
 *
 * leetcode: https://leetcode.cn/problems/add-without-plus-lcci/
 */
public class Add {

    /**
     * 知识点梳理，^ 无进位相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = ((a & b) << 1);
            a = sum;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int result = add(1, 4);
        System.out.println("result = " + result);
        // result = 5
    }
}
