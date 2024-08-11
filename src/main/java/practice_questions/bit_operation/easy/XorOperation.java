package practice_questions.bit_operation.easy;

/**
 * @BelongsPackage: practice_questions.bit_operation.easy
 * @ClassName: XorOperation
 * @Author: 丛虹羽
 * @Date: 2024/8/11 下午5:52
 * @Description: 数组异或操作
 *
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * leetcode: https://leetcode.cn/problems/xor-operation-in-an-array
 */
public class XorOperation {

    /**
     * 进行异或的操作
     *
     * @param n
     * @param start
     * @return
     */
    public static int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            // System.out.println("ans: " + ans);
            ans ^= (start + 2 * i);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }
}
