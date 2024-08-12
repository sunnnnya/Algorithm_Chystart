package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: MechanicalAccumulator
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午4:57
 * @Description: 设计机械累加器
 *
 * 请设计一个机械累加器，计算从 1、2... 一直累加到目标数值 target 的总和。注意这是一个只能进行加法操作的程序，
 * 不具备乘除、if-else、switch-case、for 循环、while 循环，及条件判断语句等高级功能。
 *
 * leetcode：https://leetcode.cn/problems/qiu-12n-lcof
 */
public class MechanicalAccumulator {

    /**
     * 使用递归的方式，进行数据的累加
     *
     * @param target
     * @return
     */
    public static int mechanicalAccumulator(int target) {
        if(target == 0) {
            return 0;
        }
        return target + mechanicalAccumulator(target - 1);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(mechanicalAccumulator(5));
        // 15

        System.out.println(mechanicalAccumulator(7));
        // 28
    }
}
