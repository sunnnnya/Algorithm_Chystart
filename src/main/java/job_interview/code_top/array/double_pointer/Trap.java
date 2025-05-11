package job_interview.code_top.array.double_pointer;

/**
 * @BelongsPackage: job_interview.code_top.array.double_pointer
 * @ClassName: Trap
 * @Author: 丛虹羽
 * @Date: 2025/5/11 23:36
 * @Description: 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class Trap {

    /**
     * 双指针问题
     *
     * @param height 高度数组
     * @return int
     */
    static int trap(int[] height) {
        int n = height.length, ans = 0;
        int lmax = height[0], rmax = height[n - 1], l = 1, r = n - 2;
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
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
