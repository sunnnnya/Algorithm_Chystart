package practice_questions.prefix_sum_array.easy;

import java.util.Arrays;

/**
 * @BelongsPackage: practice_questions.prefix_sum_array.easy
 * @ClassName: LargestAltitude
 * @Author: 丛虹羽
 * @Date: 2024/8/9 下午2:05
 * @Description: 找到最高海拔
 *
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 */
public class LargestAltitude {

    /**
     * 使用前缀和数组进行记录， 饭后返回最大化值
     *
     * @param gain
     * @return
     */
    public static int largestAltitude(int[] gain) {
        int[] pre = new int[gain.length + 1];
        pre[0] = 0;
        int max = pre[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = gain[i - 1] + pre[i - 1];
            max = Math.max(max, pre[i]);
        }
        // System.out.println(Arrays.toString(pre));
        return max;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(arr));
        // 1

        int[] arr1 = new int[]{-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(arr1));
        // 0
    }
}
