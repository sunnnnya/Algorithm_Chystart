package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: ReverseBits
 * @Author: 丛虹羽
 * @Date: 2024/8/6 下午9:40
 * @Description: 颠倒二进制位
 *
 * leetcode： https://leetcode.cn/problems/reverse-bits/description/
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {

    /**
     * n >>> i ：表示依次右移 i 位
     * (n >>> i) & 1 : 表示获取移动几位之后获取的bit位是 1 还是 0
     * ((n >>> i) & 1 << (31 - i))：表示获取到位数之后然后前移多少位，理解为反转
     * ans |= (((n >>> i) & 1) << (31 - i)): 使用 ans 进行结果的累加
     *
     * @param n
     * @return
     */
    public static int reverseBits1(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans |= (((n >>> i) & 1) << (31 - i));
        }
        return ans;
    }

    /**
     *   abcdef            abcdef
     * & 101010          & 010101
     * = a0c0e0 >> 1     = 0b0d0f << 1
     * = 0a0c0e     |    = b0d0f0
     * = badcfe【相当于隔位交换了，然后接着交换1、2、4、8、16】
     *
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        n = ((n & 0Xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0Xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n= (n >>> 16) | (n << 16);
        return n;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 43261596 -> 00000010100101000001111010011100
        System.out.println(reverseBits(43261596));
        // 964176192 -> 00000010100101000001111010011100
    }
}
