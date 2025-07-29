package job_interview.hot100.stack;

/**
 * @BelongsPackage: job_interview.hot100.stack
 * @ClassName: LargestRectangleArea
 * @Author: 丛虹羽
 * @Date: 2025/7/29 12:48
 * @Description: 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class LargestRectangleArea {

    private static final int MAXN = 100001;

    private static int[] stack = new int[MAXN];

    private static int r = 0;

    /**
     * 相等的时候也需要结算答案
     *
     * @param heights 高度数组
     * @return int
     */
    public static int largestRectangleArea(int[] heights) {
        r = 0;
        int ans = -1, cur, left;
        for(int i = 0; i < heights.length; i++) {
            while(r > 0 && heights[i] <= heights[stack[r - 1]]) {
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, (i - left - 1) * heights[cur]);
            }
            stack[r++] = i;
        }
        while(r > 0) {
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, (heights.length - left - 1) * heights[cur]);
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
        // 10
    }
}
