package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: EncryptionCalculate
 * @Author: 丛虹羽
 * @Date: 2024/8/5 下午8:53
 * @Description: 加密运算
 *
 * 请不使用四则运算符的情况下实现一个函数计算两次通信的数据量之和（三种情况均需被统计），以确保在数据传输过程中的高安全性和保密性。
 *
 */
public class EncryptionCalculate {

    /**
     * 知识点：
     *      x ^ y      ：无进位相加
     *      x & y << 1 ：进位信息
     *
     * @param dataA
     * @param dataB
     * @return
     */
    public static int encryptionCalculate(int dataA, int dataB) {
        int sum = dataA;
        while (dataB != 0) {
            sum = dataA ^ dataB;
            dataB = ((dataA & dataB) << 1);
            dataA = sum;
        }
        return sum;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int dataA = 5;
        int dataB = -1;
        System.out.println(encryptionCalculate(dataA, dataB));
        // 4

        int dataA1 = -2;
        int dataB1 = -1;
        System.out.println(encryptionCalculate(dataA1, dataB1));
        // -3

        int dataA2 = 0;
        int dataB2 = -2;
        System.out.println(encryptionCalculate(dataA2, dataB2));
        // -2
    }
}
