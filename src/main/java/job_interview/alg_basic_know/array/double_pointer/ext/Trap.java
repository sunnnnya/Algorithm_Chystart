package job_interview.alg_basic_know.array.double_pointer.ext;

/**
 * @BelongsPackage: job_interview.alg_basic_know.array.double_pointer.ext
 * @ClassName: Trap
 * @Author: 丛虹羽
 * @Date: 2025/5/1 19:55
 * @Description: 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class Trap {

    /**
     * 双指针
     *
     * @param height 高度数组
     * @return 返回存储水的数量
     */
    public static int trap(int[] height) {
        int l = 1, r = height.length - 2, lmax = height[0], rmax = height[height.length - 1];
        int ans = 0;
        while(l <= r) {
            if(lmax <= rmax) {
                ans += Math.max(lmax - height[l], 0);
                lmax = Math.max(lmax, height[l++]);
            } else {
                ans += Math.max(rmax - height[r], 0);
                rmax = Math.max(rmax, height[r--]);
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
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
        // 6
    }
}
