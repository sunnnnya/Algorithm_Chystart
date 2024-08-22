package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: Near2Power
 * @Author: 丛虹羽
 * @Date: 2024/8/22 下午5:36
 * @Description: 返回大于等于n的最小的2的幂
 */
public class Near2Power {

    /**
     * number = 17            10001
     * number = number - 1    10000
     * number = number >> 1   01000
     * number |= number >> 1  11001
     * number = number >> 2   00110
     * number |= number >> 2  11111
     * ...
     * 最后相当于吧第一位1后面的1都刷成了1，如果当前的值是16（已经是2的幂次，先减一，然后加1，最后还是等一16）
     *
     * @param number
     * @return
     */
    public static int near2Power(int number) {
        if (number <= 0) {
            return 1;
        }
        --number;
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        return number + 1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(near2Power(23));
        // 32

        System.out.println(near2Power(-1));
        // 1
    }
}
