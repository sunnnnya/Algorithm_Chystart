package practice_questions.bit_operation.medium;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: SockCollocation
 * @Author: 丛虹羽
 * @Date: 2024/8/12 下午10:16
 * @Description: 撞色搭配
 *
 * 整数数组 sockets 记录了一个袜子礼盒的颜色分布情况，其中 sockets[i] 表示该袜子的颜色编号。礼盒中除了一款撞色搭配的袜子，每种颜色的袜子均有两只。请设计一个程序，在时间复杂度 O(n)，空间复杂度O(1) 内找到这双撞色搭配袜子的两个颜色编号。
 *
 * leetcode: https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 */
public class SockCollocation {

    /**
     * 题目的理解：等价于求数组中出现两个奇数次的数，经典按位异或操作取 1
     *
     * @param sockets
     * @return
     */
    public static int[] sockCollocation(int[] sockets) {
        int eor = 0;
        for (int number : sockets) {
            eor ^= number;
        }
        int xor = 0;
        for (int number : sockets) {
            if ((number & (eor & (~eor + 1))) > 0) {
                xor ^= number;
            }
        }
        return new int[]{xor, xor ^ eor};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 4, 6, 6};
        System.out.println(Arrays.toString(sockCollocation(arr)));
        //

        int[] arr1 = new int[]{1, 2, 4, 1, 4, 3, 12, 3};
        System.out.println(Arrays.toString(sockCollocation(arr1)));
        //
    }
}
