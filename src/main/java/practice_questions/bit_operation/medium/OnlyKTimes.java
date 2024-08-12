package practice_questions.bit_operation.medium;

/**
 * @BelongsPackage: practice_questions.bit_operation.medium
 * @ClassName: OnlyKTimes
 * @Author: 丛虹羽
 * @Date: 2024/8/12 上午11:09
 * @Description:  状态压缩
 *
 * 一个数组中，有一种数出现了K次，其他数都出现了M次，M > 1，K < M ，找到出现了K次的数。要求：额外空间复杂度O(1)，时间复杂度O(N)
 *      分析：
 *        所有的数的二进制位相加的数组，是32个元素的int数组
 *        int数组的每个元素如果是M的倍数，说明出现K次的这种数在这个位上是0，不是1
 *        int数组的每个元素如果不是M的倍数，说明出现K次的这种数在这个位上是1，不是0
 */
public class OnlyKTimes {

    /**
     * 请保证arr中，只有一种数出现了K次，其他数都出现了M次
     *
     * @param nums
     * @param K
     * @param M
     * @return
     */
    public static int onlyKTimes(int[] nums, int K, int M) {
        int[] arr = new int[32];
        // 17 -> [... 0, 0, 1, 0, 0, 0, 1]
        for (int number : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += (number >> i) & 1;
            }
        }
        int ans = 0;
        // 证明：一个数出现 M 次，说明arr[i] % M == 0
        for (int i = 0; i < 32; i++) {
            if (arr[i] % M != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 3, 2, 1, 5, 5, 5, 5, 1, 1, 1};
        System.out.println(onlyKTimes(arr, 2, 4));
        // 2
    }
}
