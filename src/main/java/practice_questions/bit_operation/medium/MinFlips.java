package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: MinFlips
 * @Author: 丛虹羽
 * @Date: 2024/8/11 上午11:17
 * @Description: 或运算的最小翻转次数
 *
 * 给你三个正整数 a、b 和 c，可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *
 * leetcode：https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c
 */
public class MinFlips {
    /**
     * 或运算的最小翻转次数,使用 a | b 获取出两者能拼凑出来的值,然后和c异或操作，查看需要补多少位
     * -- 模拟实现，一种情况，一种情况的分析；然后进行累加
     * 如果c的某一位是1的话，而a | b的某一位是1就不需要进行修改
     * 如果c的某一位是1的话，而a | b的某一位是0则需要修改1位
     * 如果c的某一位是0的话，而a | b的某一位是1；
     *      如果a和b的某一位分别为1的话，就需要修改两次；
     *      如果a和b的某一位是1或者0的话，只需要修改一次就行；
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int minFlips(int a, int b, int c) {
        int sum = 0;
        for(int i = 0; i < 31; i++) {
            int number1 = ((a | b) >> i) & 1;
            int number2 = ((c >> i) & 1);
            if (number2 == 1 && number1 == 1) {
                sum += 0;
            } else if(number2 == 1 && number1 == 0) {
                sum += 1;
            } else if (number2 == 0 && number1 == 1){
                if (((a >> i) & 1) == 1 && ((b >> i) & 1) == 1) {
                    sum += 2;
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 分析：
         *      2：0010 -> 0001
         *      6：0110 -> 0100
         *      5：0101 -> 需要改动：3位
         */
        System.out.println(minFlips(2, 6, 5));
        // 3

        /**
         * 分析：
         *      4：0100 -> 0101
         *      2：0010 -> 0010
         *      7：0111 -> 需要改动：1位
         */
        System.out.println(minFlips(4, 2, 7));
        // 1

        /**
         * 分析：
         *      1：0001 -> 0001
         *      2：0010 -> 0010
         *      3：0011 -> 需要改动：0位
         */
        System.out.println(minFlips(1, 2, 3));
        // 0
    }
}
