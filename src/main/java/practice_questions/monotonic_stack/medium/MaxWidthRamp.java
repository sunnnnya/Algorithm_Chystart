package practice_questions.monotonic_stack.medium;

/**
 * @BelongsPackage: practice_questions.monotonic_stack.medium
 * @ClassName: MaxWidthRamp
 * @Author: 丛虹羽
 * @Date: 2024/8/25 下午9:54
 * @Description: 最大宽度坡 单调栈的拓展
 *
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 * leetcode：https://leetcode.cn/problems/maximum-width-ramp
 *
 * bilibili: https://www.bilibili.com/video/BV1GH4y1D7TB/?spm_id_from=333.999.0.0
 */
public class MaxWidthRamp {

    public static int MAXN = 50001;

    public static int[] stack = new int[MAXN];

    public static int r;

    /**
     * 单调栈：有可能出现答案的数据才会进入栈中
     *
     * @param nums
     * @return
     */
    public static int maxWidthRamp(int[] nums) {
        r = 1;
        // 先把依次变小信息集中到栈中，不一股脑放进去
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[stack[r - 1]]) {
                stack[r++] = i;
            }
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (r > 0 && nums[stack[r - 1]] <= nums[i]) {
                ans = Math.max(ans, i - stack[--r]);
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
        int[] arr = new int[]{6, 0, 8, 2, 1, 5};
        System.out.println(maxWidthRamp(arr));
        // 4

        int[] arr1 = new int[]{9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(arr1));
        // 7
    }
}
