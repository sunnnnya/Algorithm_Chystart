package job_interview.hot100.double_pointer;

/**
 * @BelongsPackage: job_interview.hot100.double_pointer
 * @ClassName: MaxArea
 * @Author: 丛虹羽
 * @Date: 2025/7/13 11:05
 * @Description: 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxArea {

    /**
     * 双指针
     *
     * @param height 原始数组
     * @return 最大的接雨水的含量
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
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
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
        // 49
    }
}
