package job_interview.hot100.double_pointer;

/**
 * @BelongsPackage: job_interview.hot100.double_pointer
 * @ClassName: Trap
 * @Author: 丛虹羽
 * @Date: 2025/7/13 11:35
 * @Description: 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Trap {

    /**
     * 双指针，分析指针动向，进行指针移动条件判断
     *
     * @param height 原始数组
     * @return 返回能接到的最大雨水
     */
    public static int trap(int[] height) {
        int ans = 0, n = height.length;
        int lmax = height[0], rmax = height[n - 1];
        int l = 1, r = n - 2;
        while(l <= r) {
            if(lmax <= rmax) {
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l++]);
            } else {
                ans += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r--]);
            }
        }
        return ans;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
        // 6
    }
}
