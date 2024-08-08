package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: FindComplement
 * @Author: 丛虹羽
 * @Date: 2024/8/7 下午9:07
 * @Description: 数字的补数
 *
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 *
 * leetcode： https://leetcode.cn/problems/number-complement/description/
 */
public class FindComplement {

    /**
     * 使用循环进行进行按位取反 相加，主要 n >>= 1 而不是 n >>= i否则会出现跳跃的情况
     * 数组加强练习
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; num != 0; num >>= 1, i++) {
            res |= (num & 1) > 0 ? 0 : 1 << i;
        }
        return res;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        // 2

        System.out.println(findComplement(1));
        // 0

        System.out.println(findComplement(8));
    }
}
