package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: ConvertInteger
 * @Author: 丛虹羽
 * @Date: 2024/8/8 下午10:52
 * @Description: 整数转换
 *
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * leetcode: https://leetcode.cn/problems/convert-integer-lcci/description/
 */
public class ConvertInteger {

    /**
     * 本质就是计算两个不同进制之间的bit位有多少不同的，使用^然后逐位删除；
     *
     * @param A
     * @param B
     * @return
     */
    public static int convertInteger(int A, int B) {
        int sum = 0;
        for (int N = A ^ B; N != 0; N = N & (N - 1)) {
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
        System.out.println(convertInteger(29, 15));
        // 2
    }
}
