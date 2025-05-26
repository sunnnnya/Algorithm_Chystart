package job_interview.alg_basic_know.math.bit_operation;

/**
 * @BelongsPackage: job_interview.alg_basic_know.math.bit_operation
 * @ClassName: BitOperation
 * @Author: 丛虹羽
 * @Date: 2025/5/26 15:39
 * @Description: 位运算操作
 */
public class BitOperation {

    /**
     * 测试
     *  ： << num <=> << num % 32...
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 5;

        int afterLeftBitOpt = num << 2;
        System.out.println(Integer.toBinaryString(afterLeftBitOpt));
        // 10100

        int afterLeftBitOpt1 = num << 34;
        System.out.println(Integer.toBinaryString(afterLeftBitOpt1));
        // 10100
    }
}
