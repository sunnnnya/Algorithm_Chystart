package practice_questions.monotonic_stack.medium;

/**
 * @BelongsPackage: practice_questions.monotonic_stack.medium
 * @ClassName: SumSubarrayMins
 * @Author: 丛虹羽
 * @Date: 2024/12/20 下午6:06
 * @Description: 子数组的最小值之和
 *
 * 思路：
 *   基础性质： x ... arr[i] ... y
 *      x：表示左侧第一个比 arr[i] 小的位置
 *      y：表示右侧第一个比 arr[i] 小的位置
 *   问题转换：arr[i] 则是 x + 1 到 y - 1 中的最小值，以 arr[i] 最小值的子数组之和
 *
 * leetcode： https://leetcode.cn/problems/sum-of-subarray-minimums
 */
public class SumSubarrayMins {

    public static int MOD = 1000000007;

    public static int MAXN = 30001;

    public static int[] stack = new int[MAXN];

    public static int r;

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
